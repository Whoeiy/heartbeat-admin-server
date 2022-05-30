package com.example.heartbeatadminserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.heartbeatadminserver.entity.Category;
import com.example.heartbeatadminserver.entity.Label;
import com.example.heartbeatadminserver.service.ICategoryService;
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
    private LabelService labelService;



    @GetMapping
    public Result<PageResult> getAll(int adminId, @RequestParam int currentPage, @RequestParam int pageSize){
        QueryWrapper<Label> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("isDeleted", 0)
                .orderByDesc("labelRank")
                .orderByAsc("labelID");
        List<Label> res1 = labelService.list(queryWrapper);
        PageResult pageResult = new PageResult(res1,res1.size(),pageSize,currentPage);
        return ResultGenerator.genSuccessResultData(pageResult);
    }
//
//    @GetMapping("/level")
//    public PageResult getLevel(int adminId, @RequestParam int categoryLevel, @RequestParam int parentId,
//                               @RequestParam int currentPage, @RequestParam int pageSize) {
//        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("categoryLevel", categoryLevel)
//                .eq("parentId", parentId)
//                .orderByAsc("categoryID");
//
//        List<Category> result = categoryService.list(queryWrapper);
//        PageResult pageResult = new PageResult(result,result.size(),currentPage,pageSize);
//
//        return pageResult;
//    }
//
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Label label = labelService.getById(id);
        Result res;
        if(label == null){
            res = ResultGenerator.genFailResult("This id is not exist");
        }else{
            res = ResultGenerator.genSuccessResultData(label);
        }
        return res;
    }
//
////    @GetMapping("/page")
////    public IPage<Category> getPage(int adminId, @RequestParam int currentPage, @RequestParam int pageSize) {
////        return categoryService.getPage(currentPage, pageSize);
////    }
//
    //更新label
    @PutMapping
    public Result updateLabelInfo(int adminId, @RequestBody Label label) {
        java.util.Date date = new Date();
        Timestamp t = new Timestamp(date.getTime());
        label.setUpdatetime(t);
        boolean flag = labelService.updateById(label);
        Result result;
        if (flag) {
            result = ResultGenerator.genSuccessResult();
        } else {
            result = ResultGenerator.genFailResult("Can not update category");
        }
        return result;
    }

    // 增加label
    @PostMapping
    public Result insertLabel(int adminId, @RequestBody Label label) {
        java.util.Date date = new Date();
        Timestamp t = new Timestamp(date.getTime());
        label.setCreatetime(t);
        boolean flag = labelService.save(label);
        Result result;
        if (flag) {
            result = ResultGenerator.genSuccessResult();
        } else {
            result = ResultGenerator.genFailResult("Can not insert category");
        }
        return result;
    }

    // 删除label
    @DeleteMapping("/{id}")
    public Result deleteCategory(int adminId, @PathVariable Integer id) {
        Label label = labelService.getById(id);
        label.setIsdeleted(1);
        java.util.Date date = new Date();
        Timestamp t = new Timestamp(date.getTime());
        label.setUpdatetime(t);
        Result result;
        boolean flag = labelService.updateById(label);
        if(flag){
            result = ResultGenerator.genSuccessResult();

        }
        else {
            result = ResultGenerator.genFailResult("Can not change the category");
        }
        return result;
    }

}
