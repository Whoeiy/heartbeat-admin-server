package com.example.heartbeatadminserver.controller;

import com.example.heartbeatadminserver.controller.param.VendorAddParam;
import com.example.heartbeatadminserver.entity.Vendor;
import com.example.heartbeatadminserver.service.Impl.VendorServiceImpl;
import com.example.heartbeatadminserver.util.*;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/vendor")
    @ApiOperation("/查询商家列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页数", required = true, paramType = "query", dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, paramType = "query", dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "keyword", value = "模糊查询关键字, 空值默认查询所有数据", paramType = "query", dataType = "String", dataTypeClass = String.class)
    })
    public Result<PageResult> getVendorList(@RequestParam int pageNum, @RequestParam int pageSize, String keyword, int adminId){
        PageParam pageParam = new PageParam();
        pageParam.setPageNum(pageNum);
        pageParam.setPageSize(pageSize);
        String key = keyword;

        PageResult pageResult = this.vendorService.queryVendorListPaged(key, pageParam);
        Result<PageResult> result = ResultGenerator.genSuccessResult(pageResult);

        return result;
    }
}
