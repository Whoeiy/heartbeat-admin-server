package com.example.heartbeatadminserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.heartbeatadminserver.entity.Category;
import com.example.heartbeatadminserver.service.ICategoryService;
import com.example.heartbeatadminserver.dao.CategoryDao;
import org.springframework.stereotype.Service;

/**
* @author lihanbin
* @description 针对表【category】的数据库操作Service实现
* @createDate 2022-05-28 10:50:43
*/
@Service
public class ICategoryServiceImpl extends ServiceImpl<CategoryDao, Category>
    implements ICategoryService {

}




