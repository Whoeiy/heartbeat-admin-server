package com.example.heartbeatadminserver.dao;

import com.example.heartbeatadminserver.entity.LabelNew;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* @author lihanbin
* @description 针对表【label_new】的数据库操作Mapper
* @createDate 2022-06-06 13:25:12
* @Entity com.example.heartbeatadminserver.entity.LabelNew
*/
@Mapper
@Repository
public interface LabelNewDao extends BaseMapper<LabelNew> {

}




