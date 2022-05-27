package com.example.heartbeatadminserver.controller;

import com.example.heartbeatadminserver.controller.param.VendorAddParam;
import com.example.heartbeatadminserver.entity.Vendor;
import com.example.heartbeatadminserver.service.IVendorService;
import com.example.heartbeatadminserver.service.Impl.VendorServiceImpl;
import com.example.heartbeatadminserver.util.Md5Util;
import com.example.heartbeatadminserver.util.Result;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/admin")
public class vendorController {

    @Autowired
    private VendorServiceImpl vendorService;


    @PostMapping("/vendor")
    @ApiOperation("/新增商家")
    public Result<String> addVendor(@RequestBody VendorAddParam vendorAddParam, int adminId){
        Vendor vendor = new Vendor();
        vendor.setNameCn(vendorAddParam.getNameCn());
        vendor.setNameEn(vendorAddParam.getNameEn());
        vendor.setPasswordMd5(Md5Util.getDefaultVendorPswd());  // 设置默认密码000000
        vendor.setLogoUrl(vendorAddParam.getLogoUrl());
        vendor.setStore(vendorAddParam.getIntro());
        vendor.setShowRank(vendorAddParam.getShowRank());
        vendor.setIsShown(vendorAddParam.getIsShown());
        vendor.setIsDeleted(0); // 默认未删除
        vendor.setHoldTime(new Date()); // 创建时间
        Result<String> result = this.vendorService.addVendor(vendor);
        return result;
    }
}
