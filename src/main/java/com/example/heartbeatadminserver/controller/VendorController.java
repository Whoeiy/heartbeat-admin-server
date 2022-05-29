package com.example.heartbeatadminserver.controller;

import com.example.heartbeatadminserver.common.ServiceResultEnum;
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
public class VendorController {

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
        Result<PageResult> result = ResultGenerator.genSuccessResultData(pageResult);

        return result;
    }

    @GetMapping("/vendor/{vendorId}")
    @ApiOperation("/根据vendorId查询商家信息")
    public Result<Vendor> getVendorById(@ApiParam(name = "vendorId", value = "商家Id", required = true) @PathVariable int vendorId, int adminId){

        Vendor vendor = this.vendorService.queryVendorById(vendorId);
        if (vendor == null){
            return ResultGenerator.genFailResult("未查询到该商家");
        }
        return ResultGenerator.genSuccessResultData(vendor);
    }

    @PutMapping("/vendor")
    @ApiOperation("/根据vendorId更新商家信息")
    public Result<String> updateVendorById(@RequestBody Vendor vendor, int adminId){
        String res = this.vendorService.updateVendor(vendor);
        if (res.equals(ServiceResultEnum.SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(res);
        }
        return ResultGenerator.genFailResult(res);
    }

    @DeleteMapping("/vendor/{vendorId}")
    @ApiOperation(("/根据vendorId删除商家信息"))
    public Result<String> deleteVendorById(@ApiParam(name = "vendorId", value = "商家Id", required = true) @PathVariable int vendorId) {
        String res = this.vendorService.deleteVendor(vendorId);
        if (res.equals(ServiceResultEnum.SUCCESS.getResult())){
            return ResultGenerator.genSuccessResult(res);
        }
        return ResultGenerator.genFailResult(res);
    }

    @PutMapping("/vendor/showStatus")
    @ApiOperation("/根据vendorId更新商家是否显示")
    public Result<String> showStatus(@ApiParam(name = "vendorId", value = "商家Id", required = true) @RequestParam int vendorId) {
        String res = this.vendorService.updateIsShown(vendorId);
        if (res.equals(ServiceResultEnum.SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(res);
        }
        return ResultGenerator.genFailResult(res);
    }

}
