package com.example.heartbeatadminserver.service;

import com.example.heartbeatadminserver.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author lihanbin
* @description 针对表【category】的数据库操作Service
* @createDate 2022-05-28 10:50:43
*/


public interface ICategoryService extends IService<Category> {
    public List<Category> categoryx(Integer CLevel,Integer PId);

}
