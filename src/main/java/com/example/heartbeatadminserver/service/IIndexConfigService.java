package com.example.heartbeatadminserver.service;

import com.example.heartbeatadminserver.entity.IndexConfig;
import com.example.heartbeatadminserver.util.PageParam;
import com.example.heartbeatadminserver.util.PageResult;
import net.sf.jsqlparser.statement.create.table.Index;

public interface IIndexConfigService {

    // 新增礼物配置
    String addIndexConfig(IndexConfig indexConfig);

    // 查询礼物配置列表
    PageResult<IndexConfig> getIndexConfigListByType(Integer type, PageParam pageParam);

    // 更新礼物配置
    String updateIndexConfig(IndexConfig indexConfig);

    // 删除礼物配置
    String deleteIndexConfig(Integer configId);

    // 查询礼物详情
    IndexConfig getIndexConfigById(Integer configId);
}
