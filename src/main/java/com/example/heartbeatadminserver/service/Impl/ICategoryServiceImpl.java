package com.example.heartbeatadminserver.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.heartbeatadminserver.entity.Category;
import com.example.heartbeatadminserver.service.ICategoryService;
import com.example.heartbeatadminserver.dao.CategoryDao;
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

    @Override
    public List<Category> categoryx(Integer CLevel, Integer PId) {
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("categoryLevel",CLevel)
                .eq("parentId",PId);
        return list(queryWrapper);
    }
}




