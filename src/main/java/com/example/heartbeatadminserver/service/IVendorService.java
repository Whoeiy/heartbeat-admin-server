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

    PageResult queryVendorListPaged(String keywords, PageParam pageParam);
}
