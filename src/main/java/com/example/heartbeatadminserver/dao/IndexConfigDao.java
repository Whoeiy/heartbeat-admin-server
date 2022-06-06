package com.example.heartbeatadminserver.dao;

import com.example.heartbeatadminserver.entity.IndexConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IndexConfigDao {

    // 新增礼物配置
    Integer insertIndexConfig(IndexConfig indexConfig);

    // 查询礼物配置列表
    List<IndexConfig> gitIndexConfigListByType(Integer type);

    // 统计礼物配置记录数
    Integer countTotalIndexConfig(Integer type);

    // 更新礼物配置
    Integer updateIndexConfig(IndexConfig indexConfig);

    // 删除礼物配置
    Integer deleteIndexConfig(Integer configId);

    // 根据configId查询礼物配置详情
    IndexConfig getIndexConfigById(Integer configId);


}
