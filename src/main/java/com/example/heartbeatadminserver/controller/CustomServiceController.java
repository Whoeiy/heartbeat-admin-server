package com.example.heartbeatadminserver.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.heartbeatadminserver.entity.CustomService;
import com.example.heartbeatadminserver.entity.LabelNew;
import com.example.heartbeatadminserver.entity.Vendor;
import com.example.heartbeatadminserver.service.CustomServiceService;
import com.example.heartbeatadminserver.service.Impl.AdminServiceImpl;
import com.example.heartbeatadminserver.service.Impl.VendorServiceImpl;
import com.example.heartbeatadminserver.util.PageResult;
import com.example.heartbeatadminserver.util.Result;
import com.example.heartbeatadminserver.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/admin/custom-service")
public class CustomServiceController {
    @Autowired
    private CustomServiceService customServiceService;

    @Autowired
    private VendorServiceImpl vendorService;

    @Autowired
    private AdminServiceImpl adminService;

    @GetMapping
    public Result<PageResult> getAll(@RequestParam int vendorId, @RequestParam int currentPage, @RequestParam int pageSize){
        QueryWrapper<CustomService> queryWrapper = new QueryWrapper<>();
        if(vendorId == 1) {
            queryWrapper.eq("vendorId", 1)
                    .eq("isDeleted", 0)
                    .orderByDesc("showRank")
                    .orderByAsc("serviceId");
            List<CustomService> res1 = customServiceService.list(queryWrapper);
            IPage page = new Page(currentPage, pageSize);
            IPage page1 = customServiceService.page(page, queryWrapper);

            PageResult pageResult = new PageResult(page1.getRecords(), (int) page1.getPages(), pageSize, currentPage);
            return ResultGenerator.genSuccessResultData(pageResult);
        }else if(vendorService.queryVendorById(vendorId) !=null
                || adminService.getAdminById(vendorId) != null){
            queryWrapper.eq("vendorId", vendorId)
                    .eq("isDeleted", 0)
                    .orderByDesc("showRank")
                    .orderByAsc("serviceId");
            List<CustomService> res1 = customServiceService.list(queryWrapper);
            PageResult pageResult = new PageResult(res1, res1.size(), pageSize, currentPage);
            return ResultGenerator.genSuccessResultData(pageResult);
        }
        return ResultGenerator.genFailResult("未查询到该商家");

    }

    @PutMapping("/showStatus")
    public Result updateStatus(@RequestParam int serviceId,@RequestParam int showStatus){
        CustomService customService = customServiceService.getById(serviceId);
        customService.setIsshown(showStatus);
        java.util.Date date = new Date();
        Timestamp t = new Timestamp(date.getTime());
        customService.setUpdatetime(t);
        boolean flag = customServiceService.updateById(customService);
        Result result;
        if (flag) {
            result = ResultGenerator.genSuccessResult();
        } else {
            result = ResultGenerator.genFailResult("不能更新状态");
        }
        return result;
    }

    @PostMapping
    public Result addNewCustomService(@RequestBody CustomService customService) {
        Result result;
        int id = customService.getVendorid();

        if(adminService.getAdminById(id) == null && vendorService.queryVendorById(id) == null){
            result = ResultGenerator.genFailResult("未查询到该商家");
            return result;
        }
        java.util.Date date = new Date();
        Timestamp t = new Timestamp(date.getTime());
        customService.setCreatetime(t);
        boolean flag = customServiceService.save(customService);
        if (flag) {
            result = ResultGenerator.genSuccessResult();
        } else {
            result = ResultGenerator.genFailResult("不能新增服务");
        }
        return result;
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        CustomService customService = customServiceService.getById(id);
        Result res;
        if(customService == null){
            res = ResultGenerator.genFailResult("未查询到该服务");
        }else{
            res = ResultGenerator.genSuccessResultData(customService);
        }
        return res;
    }

    @PutMapping
    public Result updateInfo(@RequestBody CustomService customService) {
        java.util.Date date = new Date();
        Timestamp t = new Timestamp(date.getTime());
        customService.setUpdatetime(t);
        boolean flag = customServiceService.updateById(customService);
        Result result;
        if (flag) {
            result = ResultGenerator.genSuccessResult();
        } else {
            result = ResultGenerator.genFailResult("不能更新服务");
        }
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleteService(@PathVariable Integer id) {
        CustomService customService = customServiceService.getById(id);
        customService.setIsdeleted(1);
        java.util.Date date = new Date();
        Timestamp t = new Timestamp(date.getTime());
        customService.setUpdatetime(t);
        Result result;
        boolean flag = customServiceService.updateById(customService);
        if(flag){
            result = ResultGenerator.genSuccessResult();
        }
        else {
            result = ResultGenerator.genFailResult("不能删除该服务");
        }
        return result;
    }
}
