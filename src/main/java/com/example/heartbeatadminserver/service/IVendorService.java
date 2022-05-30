package com.example.heartbeatadminserver.service;

import com.example.heartbeatadminserver.entity.Vendor;
import com.example.heartbeatadminserver.util.PageParam;
import com.example.heartbeatadminserver.util.PageResult;
import com.example.heartbeatadminserver.util.Result;

public interface IVendorService{
    /**
     * 添加商家
     * @param vendor
     * @return
     */
    Result addVendor(Vendor vendor);

//    PageResult queryVendorListPaged(PageParam pageParam);

    /**
     * 分页查询商家列表，支持模糊搜索
     * @param keywords
     * @param pageParam
     * @return
     */
    PageResult queryVendorListPaged(String keywords, PageParam pageParam);

    /**
     * 根据id查询商家信息
     * @param vendorId
     * @return
     */
    Vendor queryVendorById(Integer vendorId);


    /**
     * 更新Vendor信息
     * @param vendor
     * @return
     */
    String updateVendor(Vendor vendor);

    /**
     * 删除商家
     * @param vendorId
     * @return
     */
    String deleteVendor(int vendorId);

    String updateIsShown(int vendorId, int showStatus);
}
