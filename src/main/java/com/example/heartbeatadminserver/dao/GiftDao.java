package com.example.heartbeatadminserver.dao;

import com.example.heartbeatadminserver.entity.Category;
import com.example.heartbeatadminserver.entity.Gift;
import com.example.heartbeatadminserver.entity.Label;
import com.example.heartbeatadminserver.entity.LabelNew;
import com.example.heartbeatadminserver.service.pojo.GiftCategoryIds;
import com.example.heartbeatadminserver.service.pojo.GiftLabelsIds;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GiftDao {

    // 新增礼物
    Integer insertGift(Gift gift);

    // 查询礼物列表
    List<Gift> getGiftList(String key, Integer vendorId);

    // 统计记录数
    Integer countTotalGift(String key, Integer vendorId);

    // 更新礼物信息
    Integer updateGift(Gift gift);

    // 根据id查询礼物信息
    Gift getGiftById(Integer giftId);

    // 更新礼物上架状态
    Integer updateGiftIsShownById(Integer giftId, Integer showStatus);

    // 查询礼物所属分类信息
    List<Category> getGiftCategoriesByIds(@Param("ids") List<Integer> ids);

    // 查询礼物分类列表
    GiftCategoryIds getCategoriesIds(Integer third);

    // 查询礼物标签信息
    List<LabelNew> getGiftLabelsByIds(@Param("ids") List<Integer> ids);

    // 查询礼物标签列表
    GiftLabelsIds getLabelsIds(Integer third);

}
