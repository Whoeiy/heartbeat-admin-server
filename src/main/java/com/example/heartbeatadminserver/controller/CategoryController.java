package com.example.heartbeatadminserver.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.heartbeatadminserver.entity.Category;
import com.example.heartbeatadminserver.service.ICategoryService;
import com.example.heartbeatadminserver.util.Result;
import com.example.heartbeatadminserver.util.ResultGenerator;
import org.apache.catalina.mbeans.SparseUserDatabaseMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/{CLevel}/{PId}")
    public List<Category> getLevel(int adminId, @PathVariable int CLevel, @PathVariable int PId){
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("categoryLevel",CLevel)
                        .eq("parentId",PId);

        List<Category> result = categoryService.list(queryWrapper);

        return result;
    }

    @GetMapping
    public List<Category> getAll(){
        return categoryService.list();
    }

    @PutMapping
    public Boolean updateCategoryInfo(@RequestBody Category category){
        return categoryService.updateById(category);
    }

    @PostMapping
    public Boolean insertCategory(@RequestBody Category category){

        return categoryService.save(category);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteCategory(@PathVariable Integer id){
        return categoryService.removeById(id);
    }


}
