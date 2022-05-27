package com.example.heartbeatadminserver.service.Impl;

import com.example.heartbeatadminserver.dao.VendorDao;
import com.example.heartbeatadminserver.entity.Vendor;
import com.example.heartbeatadminserver.service.IVendorService;
import com.example.heartbeatadminserver.util.Result;
import com.example.heartbeatadminserver.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImpl implements IVendorService {

    @Autowired
    private VendorDao vendorDao;

    @Override
    public Result addVendor(Vendor vendor) {
        Vendor old = this.vendorDao.getVendorByNameEn(vendor.getNameEn());
        if (old != null){
            return ResultGenerator.genFailResult("该商家已存在！");
        } else if (this.vendorDao.insertVendor(vendor) > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(null);
        }
    }
}
