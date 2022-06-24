package com.example.heartbeatadminserver.dao;

import com.example.heartbeatadminserver.entity.CustomService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* @author lihanbin
* @description 针对表【gift_custom_service】的数据库操作Mapper
* @createDate 2022-06-22 17:44:42
* @Entity com.example.heartbeatadminserver.entity.CustomService
*/
@Mapper
@Repository
public interface CustomServiceMapper extends BaseMapper<CustomService> {

}




