package com.example.heartbeatadminserver.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.heartbeatadminserver.entity.Category;
import com.example.heartbeatadminserver.service.ICategoryService;
import com.example.heartbeatadminserver.dao.CategoryDao;
import com.example.heartbeatadminserver.util.PageResult;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author lihanbin
* @description 针对表【category】的数据库操作Service实现
* @createDate 2022-05-28 10:50:43
*/
@Service
public class ICategoryServiceImpl extends ServiceImpl<CategoryDao, Category>
    implements ICategoryService {
    @Autowired
    private CategoryDao categoryDao;

//    @Override
//    public List<Category> categoryx(Integer CLevel, Integer PId) {
//        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("categoryLevel",CLevel)
//                .eq("parentId",PId);
//        return list(queryWrapper);
//    }

    @Override
    public IPage<Category> getPage(Integer currentpage, Integer pageSize) {
        IPage page = new Page(currentpage,pageSize);

        categoryDao.selectPage(page,null);
        return page;
    }


//    public PageResult categoryListPaged(Integer pageNum,Integer pageSize){
//        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("categoryLevel",CLevel)
//                .eq("parentId",PId);
//
//    }
}




