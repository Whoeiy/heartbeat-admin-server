package com.example.heartbeatadminserver.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.heartbeatadminserver.entity.Activity;
import com.example.heartbeatadminserver.entity.Category;
import com.example.heartbeatadminserver.entity.Coupon;
import com.example.heartbeatadminserver.service.ActivityService;
import com.example.heartbeatadminserver.util.PageResult;
import com.example.heartbeatadminserver.util.Result;
import com.example.heartbeatadminserver.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/admin/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @GetMapping
    public Result<PageResult> getAll(int adminId, @RequestParam int currentPage, @RequestParam int pageSize) {
        QueryWrapper<Activity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("isDeleted", 0) // 过滤已删除的分类
                .orderByDesc("showRank")
                .orderByAsc("activityId");
        IPage page = new Page(currentPage, pageSize);
        IPage page1 = activityService.page(page, queryWrapper);


        PageResult pageResult = new PageResult(page1.getRecords(), (int) page1.getPages(), pageSize, currentPage);
        return ResultGenerator.genSuccessResultData(pageResult);
    }

    @PostMapping
    public Result insertActivity(int adminId, @RequestBody Activity activity) {

        activity.setCreatetime(new Date());
        activity.setCreateuser(adminId);
        activity.setActivitystatus(0);
        boolean flag = activityService.save(activity);
        Result result;
        Integer activitytype = activity.getActivitytype();
        Integer couponid = activity.getCouponid();
        if (activitytype == 1 && couponid == null) {
            return ResultGenerator.genFailResult("有奖活动缺少优惠");
        }
        if (flag) {
            result = ResultGenerator.genSuccessResult();
        } else {
            result = ResultGenerator.genFailResult("提供信息不完全");
        }
        return result;
    }

    @PutMapping
    public Result updateCouponInfo(int adminId, @RequestBody Activity activity) {
        activity.setUpdatetime(new Date());
        boolean flag = activityService.updateById(activity);
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
        Activity activity = activityService.getById(id);
        Result res;
        if (activity == null) {
            res = ResultGenerator.genFailResult("未能查询到次活动");
        } else {
            res = ResultGenerator.genSuccessResultData(activity);
        }
        return res;
    }


    @DeleteMapping("/{id}")
    public Result deleteById(int adminId, @PathVariable Integer id) {
        Activity activity = activityService.getById(id);
        activity.setIsdeleted(1);
        activity.setUpdatetime(new Date());

        Result result;
        boolean flag = activityService.updateById(activity);
        if (flag) {
            result = ResultGenerator.genSuccessResult();

        } else {
            result = ResultGenerator.genFailResult("不能删除此活动");
        }
        return result;
    }

    @PutMapping("/showStatus")
    public Result putStatus(int adminId, @RequestParam int activityId, @RequestParam int showstatus) {
        Activity activity = activityService.getById(activityId);
        Integer isshown = activity.getIsshown();
        if (isshown == 0) {
            isshown = 1;
        } else {
            isshown = 0;
        }
        activity.setIsshown(isshown);
        boolean b = activityService.updateById(activity);
        if (b) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("不能更新此活动");
        }
    }

    @PutMapping("/start")
    public Result startStatus(int adminId, @RequestParam int activityId) {
        Activity activity = activityService.getById(activityId);
        Integer activitystatus = activity.getActivitystatus();
        if (activitystatus != 0) {
            return ResultGenerator.genFailResult("活动不是未开始状态");
        }
        activity.setActivitystatus(1);
        activity.setUpdatetime(new Date());
        boolean b = activityService.updateById(activity);
        if (b) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("不能更新此活动");
        }
    }

    @PutMapping("/end")
    public Result endStatus(int adminId, @RequestParam int activityId) {
        Activity activity = activityService.getById(activityId);
        Integer activitystatus = activity.getActivitystatus();
        if (activitystatus != 1) {
            return ResultGenerator.genFailResult("活动不是开始状态");
        }
        activity.setActivitystatus(2);
        activity.setUpdatetime(new Date());
        boolean b = activityService.updateById(activity);
        if (b) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("不能更新此活动");
        }
    }


}
