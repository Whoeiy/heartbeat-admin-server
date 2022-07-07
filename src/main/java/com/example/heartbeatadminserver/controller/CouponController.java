package com.example.heartbeatadminserver.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.heartbeatadminserver.entity.Category;
import com.example.heartbeatadminserver.entity.Coupon;
import com.example.heartbeatadminserver.service.CouponService;
import com.example.heartbeatadminserver.service.IAdminService;
import com.example.heartbeatadminserver.service.ICategoryService;
import com.example.heartbeatadminserver.service.IVendorService;
import com.example.heartbeatadminserver.util.PageResult;
import com.example.heartbeatadminserver.util.Result;
import com.example.heartbeatadminserver.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/admin/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @Autowired
    private IAdminService iAdminService;

    @Autowired
    private IVendorService iVendorService;

    @PostMapping
    public Result insertCategory(int adminId, @RequestBody Coupon coupon) {

        coupon.setCreatetime(new Date());
        coupon.setCreateuser(adminId);
        boolean flag = couponService.save(coupon);
        Result result;
        if (flag) {
            result = ResultGenerator.genSuccessResult();
        } else {
            result = ResultGenerator.genFailResult("不能新增优惠");
        }
        return result;
    }

    @GetMapping
    public Result<PageResult> getAll(int adminId, @RequestBody int id, @RequestParam int currentPage, @RequestParam int pageSize) {
        if (iAdminService.getAdminById(id) == null || iVendorService.queryVendorById(id) == null) {
            return ResultGenerator.genFailResult("未查询到该商家");
        }
        IPage page = new Page(currentPage, pageSize);
        QueryWrapper<Coupon> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("isDeleted", 0)
                .eq("isShow", 1)
                .orderByDesc("showRank")
                .orderByAsc("couponId");
        IPage page1 = couponService.page(page, queryWrapper);

        PageResult pageResult = new PageResult(page1.getRecords(), (int) page1.getSize(), pageSize, currentPage);
        return ResultGenerator.genSuccessResultData(pageResult);
    }

    @PutMapping
    public Result updateCouponInfo(int adminId, @RequestBody Coupon coupon) {
        coupon.setUpdatetime(new Date());
        boolean flag = couponService.updateById(coupon);
        Result result;
        if (flag) {
            result = ResultGenerator.genSuccessResult();
        } else {
            result = ResultGenerator.genFailResult("不能更新优惠");
        }
        return result;
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Coupon coupon = couponService.getById(id);
        Result res;
        if (coupon == null) {
            res = ResultGenerator.genFailResult("未能查询到次优惠");
        } else {
            res = ResultGenerator.genSuccessResultData(coupon);
        }
        return res;
    }

    @DeleteMapping("/{id}")
    public Result deleteById(int adminId, @PathVariable Integer id) {
        Coupon coupon = couponService.getById(id);
        coupon.setIsdeleted(1);
        coupon.setUpdatetime(new Date());

        Result result;
        boolean flag = couponService.updateById(coupon);
        if (flag) {
            result = ResultGenerator.genSuccessResult();

        } else {
            result = ResultGenerator.genFailResult("不能删除此优惠");
        }
        return result;
    }

    @PutMapping("/showStatus")
    public Result putStatus(int adminId, @RequestParam int couponId, @RequestParam int showStatus) {
        Coupon coupon = couponService.getById(couponId);
        Integer isshown = coupon.getIsshown();
        if (isshown == 0) {
            isshown = 1;
        }else{
            isshown = 0;
        }
        coupon.setIsshown(isshown);
        boolean b = couponService.updateById(coupon);
        if(b){
            return ResultGenerator.genSuccessResult();
        }else{
            return ResultGenerator.genFailResult("不能更新此优惠");
        }

    }


}
