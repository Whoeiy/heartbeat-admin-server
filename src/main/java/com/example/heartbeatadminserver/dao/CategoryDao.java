package com.example.heartbeatadminserver.dao;

import com.example.heartbeatadminserver.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
* @author lihanbin
* @description 针对表【category】的数据库操作Mapper
* @createDate 2022-05-28 10:50:43
* @Entity com.example.heartbeatadminserver.entity.Category
*/
@Mapper
@Repository
public interface CategoryDao extends BaseMapper<Category> {

}




