package com.example.heartbeatadminserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.heartbeatadminserver.entity.Category;
import com.example.heartbeatadminserver.entity.Label;
import com.example.heartbeatadminserver.entity.LabelNew;
import com.example.heartbeatadminserver.service.ICategoryService;
import com.example.heartbeatadminserver.service.LabelNewService;
import com.example.heartbeatadminserver.service.LabelService;
import com.example.heartbeatadminserver.util.PageResult;
import com.example.heartbeatadminserver.util.Result;
import com.example.heartbeatadminserver.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/admin/label")
public class LabelController {
    @Autowired
    private LabelNewService labelNewService;



    @GetMapping
    public Result<PageResult> getAll(int adminId, @RequestParam int currentPage, @RequestParam int pageSize){
        QueryWrapper<LabelNew> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("labelLevel", 1)
                .eq("isDeleted", 0)
                .orderByDesc("labelRank")
                .orderByAsc("labelID");
        List<LabelNew> res1 = labelNewService.list(queryWrapper);
        IPage page = new Page(currentPage, pageSize);
        IPage page1 = labelNewService.page(page, queryWrapper);
        PageResult pageResult = new PageResult(page1.getRecords(), (int) page1.getTotal(),
                (int)page1.getSize(),currentPage);
        return ResultGenerator.genSuccessResultData(pageResult);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        LabelNew label = labelNewService.getById(id);
        Result res;
        if(label == null){
            res = ResultGenerator.genFailResult("This id is not exist");
        }else{
            res = ResultGenerator.genSuccessResultData(label);
        }
        return res;
    }

    //??????label
    @PutMapping
    public Result updateLabelInfo(int adminId, @RequestBody LabelNew label) {
        java.util.Date date = new Date();
        Timestamp t = new Timestamp(date.getTime());
        label.setUpdatetime(t);
        boolean flag = labelNewService.updateById(label);
        Result result;
        if (flag) {
            result = ResultGenerator.genSuccessResult();
        } else {
            result = ResultGenerator.genFailResult("Can not update category");
        }
        return result;
    }

    @GetMapping("/labelLevel")
    public Result<PageResult> getLevel(int adminId, @RequestParam int labelLevel, @RequestParam int parentId,
                                       @RequestParam int currentPage, @RequestParam int pageSize) {
        QueryWrapper<LabelNew> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("labelLevel", labelLevel)
                .eq("parentId", parentId)
                .eq("isDeleted", 0)
                .orderByDesc("labelRank")
                .orderByAsc("labelID");

        IPage page = new Page(currentPage, pageSize);
        IPage page1 = labelNewService.page(page, queryWrapper);
        PageResult pageResult = new PageResult(page1.getRecords(), (int) page1.getTotal(),
                (int)page1.getSize(),currentPage);
        Result<PageResult> result1 = ResultGenerator.genSuccessResultData(pageResult);
        return result1;
    }

    // ??????label
    @PostMapping
    public Result insertLabel(int adminId, @RequestBody LabelNew label) {
        java.util.Date date = new Date();
        Timestamp t = new Timestamp(date.getTime());
        label.setCreatetime(t);
        boolean flag = labelNewService.save(label);
        Result result;
        if (flag) {
            result = ResultGenerator.genSuccessResult();
        } else {
            result = ResultGenerator.genFailResult("Can not insert category");
        }
        return result;
    }

    // ??????label
    @DeleteMapping("/{id}")
    public Result deleteCategory(int adminId, @PathVariable Integer id) {
        LabelNew label = labelNewService.getById(id);
        label.setIsdeleted(1);
        java.util.Date date = new Date();
        Timestamp t = new Timestamp(date.getTime());
        label.setUpdatetime(t);
        Result result;
        boolean flag = labelNewService.updateById(label);
        if(flag){
            result = ResultGenerator.genSuccessResult();

        }
        else {
            result = ResultGenerator.genFailResult("Can not change the category");
        }
        return result;
    }

}
