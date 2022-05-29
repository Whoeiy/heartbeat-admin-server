package com.example.heartbeatadminserver.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.heartbeatadminserver.entity.Category;
import com.example.heartbeatadminserver.service.ICategoryService;
import com.example.heartbeatadminserver.util.PageResult;
import com.example.heartbeatadminserver.util.Result;
import com.example.heartbeatadminserver.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/admin/categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;



    @GetMapping
    public PageResult getAll(int adminId, @RequestParam int currentPage, @RequestParam int pageSize){
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("categoryLevel", 1)
                .orderByDesc("categoryRank")
                .orderByAsc("categoryID");
        List<Category> res1 = categoryService.list(queryWrapper);
        // 排序： 排序值 rank 值 倒叙， 创建时间倒叙
        PageResult pageResult = new PageResult(res1,res1.size(),currentPage,pageSize);
        return pageResult;
    }

    @GetMapping("/level")
    public PageResult getLevel(int adminId, @RequestParam int categoryLevel, @RequestParam int parentId,
                               @RequestParam int currentPage, @RequestParam int pageSize) {
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("categoryLevel", categoryLevel)
                .eq("parentId", parentId)
                .orderByAsc("categoryID");

        List<Category> result = categoryService.list(queryWrapper);
        PageResult pageResult = new PageResult(result,result.size(),currentPage,pageSize);

        return pageResult;
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Category category = categoryService.getById(id);
        Result res;
        if(category == null){
            res = ResultGenerator.genFailResult("This id is not exist");
        }else{
            res = ResultGenerator.genSuccessResultData(category);
        }
        return res;
    }

//    @GetMapping("/page")
//    public IPage<Category> getPage(int adminId, @RequestParam int currentPage, @RequestParam int pageSize) {
//        return categoryService.getPage(currentPage, pageSize);
//    }

    //更新category
    @PutMapping
    public Result updateCategoryInfo(int adminId, @RequestBody Category category) {
        java.util.Date date = new Date();
        Timestamp t = new Timestamp(date.getTime());
        category.setUpdatetime(t);
        boolean flag = categoryService.updateById(category);
        Result result;
        if (flag) {
            result = ResultGenerator.genSuccessResult();
        } else {
            result = ResultGenerator.genFailResult("Can not update category");
        }
        return result;
    }

    // 增加category
    @PostMapping
    public Result insertCategory(int adminId, @RequestBody Category category) {
        java.util.Date date = new Date();
        Timestamp t = new Timestamp(date.getTime());
        category.setCreatetime(t);
        boolean flag = categoryService.save(category);
        Result result;
        if (flag) {
            result = ResultGenerator.genSuccessResult();
        } else {
            result = ResultGenerator.genFailResult("Can not insert category");
        }
        return result;
    }

    // 删除category
    @DeleteMapping("/{id}")
    public Result deleteCategory(int adminId, @PathVariable Integer id) {
        Category category = categoryService.getById(id);
        category.setIsdeleted(1);
        java.util.Date date = new Date();
        Timestamp t = new Timestamp(date.getTime());
        category.setUpdatetime(t);
        Result result;
        boolean flag = categoryService.updateById(category);
        if(flag){
            result = ResultGenerator.genSuccessResult();

        }
        else {
            result = ResultGenerator.genFailResult("Can not change the category");
        }
        return result;
    }


}
