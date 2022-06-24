package com.example.heartbeatadminserver.service.Impl;

import com.example.heartbeatadminserver.common.ServiceResultEnum;
import com.example.heartbeatadminserver.dao.GiftDao;
import com.example.heartbeatadminserver.entity.*;
import com.example.heartbeatadminserver.service.IGiftService;
import com.example.heartbeatadminserver.service.pojo.GiftCategoryIds;
import com.example.heartbeatadminserver.service.pojo.GiftLabelsIds;
import com.example.heartbeatadminserver.util.PageParam;
import com.example.heartbeatadminserver.util.PageResult;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GiftServiceImpl implements IGiftService {

    @Autowired
    private GiftDao giftDao;

    @Override
    public String addGift(Gift gift) {
        gift.setCreateTime(new Date());
        if (this.giftDao.insertGift(gift) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public PageResult<Gift> getGiftListPaged(String keywords, Integer vendorId, PageParam pageParam) {
        List<Gift> list = null;
        int count = 0;

        // 开始分页
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
        list = this.giftDao.getGiftList(keywords, vendorId);
        count = this.giftDao.countTotalGift(keywords, vendorId);

        int totalPage = 1;
        if (count >= pageParam.getPageSize()){
            totalPage = count / pageParam.getPageSize() + 1;
        }

        PageResult pageResult = new PageResult();
        pageResult.setList(list);
        pageResult.setCurrPage(pageParam.getPageNum());
        pageResult.setPageSize(pageParam.getPageSize());
        pageResult.setTotalCount(count);
        pageResult.setTotalPage(totalPage);

        return pageResult;
    }

    @Override
    public String updateGift(Gift gift) {
        Gift temp = this.giftDao.getGiftById(gift.getGiftId());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        gift.setUpdateTime(new Date());
        if (this.giftDao.updateGift(gift) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String updateGiftIsShown(Integer giftId, Integer showStatus) {
        Gift temp = this.giftDao.getGiftById(giftId);
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        if (this.giftDao.updateGiftIsShownById(giftId, showStatus) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public GiftDetail getGiftDetail(Integer giftId) {
        Gift gift = this.giftDao.getGiftById(giftId);
        if (gift == null) {
            return null;
        }
        List<Category> categories = this.getGiftCategories(gift);
        List<List<LabelNew>> labels = this.getGiftLabels(gift);
        return new GiftDetail(gift, categories, labels);
    }

    public List<Category> getGiftCategories(Gift gift) {
        GiftCategoryIds temp = this.getCategoryIds(gift.getGiftThirdCategoryId());
        List<Integer> ids = new ArrayList<>();
        ids.add(temp.getFirst());
        ids.add(temp.getSecond());
        ids.add(temp.getThird());
        System.out.println(ids);
        List<Category> categories = this.giftDao.getGiftCategoriesByIds(ids);
        return categories;
    }

    public GiftCategoryIds getCategoryIds(Integer third){
        GiftCategoryIds temp = this.giftDao.getCategoriesIds(third);
        temp.setThird(third);
        return temp;
    }

    public List<List<LabelNew>> getGiftLabels(Gift gift) {
        String labelIds = gift.getGiftLabelIdList();
        if (labelIds == null || labelIds.length()<=0) {
            return new ArrayList<>();
        }
        String[] temp = labelIds.split(",");
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < temp.length; i++) {
            ids.add(Integer.parseInt(temp[i]));
        }
        List<List<LabelNew>> labels = new ArrayList<>();
        for(int id : ids) {
            List<Integer> levelIds = this.getLabelLevelIds(id);
            List<LabelNew> labelNewList = this.giftDao.getGiftLabelsByIds(levelIds);
            labels.add(labelNewList);
        }

        return labels;
    }

    public List<Integer> getLabelLevelIds(Integer third){
        GiftLabelsIds temp = this.giftDao.getLabelsIds(third);
        temp.setThird(third);
        List<Integer> ids = new ArrayList<>();
        ids.add(temp.getFirst());
        ids.add(temp.getSecond());
        ids.add(temp.getThird());
        return ids;
    }
}
