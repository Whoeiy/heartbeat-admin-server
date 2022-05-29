package com.example.heartbeatadminserver.dao;

import com.example.heartbeatadminserver.entity.Label;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* @author lihanbin
* @description 针对表【label】的数据库操作Mapper
* @createDate 2022-05-29 23:37:20
* @Entity com.example.heartbeatadminserver.entity.Label
*/
@Mapper
@Repository
public interface LabelMapper extends BaseMapper<Label> {

}




