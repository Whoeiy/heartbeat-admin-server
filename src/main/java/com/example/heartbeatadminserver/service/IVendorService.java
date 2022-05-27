package com.example.heartbeatadminserver.service;

import com.example.heartbeatadminserver.entity.Vendor;
import com.example.heartbeatadminserver.util.Result;

public interface IVendorService {
    /**
     * 添加商家
     * @param vendor
     * @return
     */
    Result addVendor(Vendor vendor);
}
