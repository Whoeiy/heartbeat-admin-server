package com.example.heartbeatadminserver.service;

import com.example.heartbeatadminserver.entity.Category;
import com.example.heartbeatadminserver.entity.Gift;
import com.example.heartbeatadminserver.entity.GiftDetail;
import com.example.heartbeatadminserver.util.PageParam;
import com.example.heartbeatadminserver.util.PageResult;

import java.util.List;

public interface IGiftService {

    /**
     * 新增礼物
     * @param gift
     * @return
     */
    String addGift(Gift gift);


    /**
     * 分页查询礼物列表
     * @param keywords
     * @param vendorId
     * @param pageParam
     * @return
     */
    PageResult<Gift> getGiftListPaged(String keywords, Integer vendorId, PageParam pageParam);

    /**
     * 更新礼物信息
     * @param gift
     * @return
     */
    String updateGift(Gift gift);

    /**
     * 更新礼物上架状态
     * @param giftId
     * @param showStatus
     * @return
     */
    String updateGiftIsShown(Integer giftId, Integer showStatus);

    GiftDetail getGiftDetail(Integer giftId);
}
