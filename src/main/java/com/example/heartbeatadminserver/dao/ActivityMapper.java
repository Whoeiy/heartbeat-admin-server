package com.example.heartbeatadminserver.dao;

import com.example.heartbeatadminserver.entity.Activity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author lihanbin
* @description 针对表【activity】的数据库操作Mapper
* @createDate 2022-07-11 11:57:45
* @Entity com.example.heartbeatadminserver.entity.Activity
*/
@Mapper
public interface ActivityMapper extends BaseMapper<Activity> {

}




