package com.example.heartbeatadminserver.service.Impl;

import com.example.heartbeatadminserver.common.ServiceResultEnum;
import com.example.heartbeatadminserver.dao.IndexConfigDao;
import com.example.heartbeatadminserver.entity.IndexConfig;
import com.example.heartbeatadminserver.service.IIndexConfigService;
import com.example.heartbeatadminserver.util.PageParam;
import com.example.heartbeatadminserver.util.PageResult;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexConfigImpl implements IIndexConfigService {

    @Autowired
    private IndexConfigDao indexConfigDao;

    @Override
    public String addIndexConfig(IndexConfig indexConfig) {
        if (this.indexConfigDao.insertIndexConfig(indexConfig) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public PageResult<IndexConfig> getIndexConfigListByType(Integer type, PageParam pageParam) {
        List<IndexConfig> list = null;
        int count = 0;

        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
        list = this.indexConfigDao.gitIndexConfigListByType(type);
        count = this.indexConfigDao.countTotalIndexConfig(type);

        int totalPage = 1;
        if (count >= pageParam.getPageSize()){
            totalPage = count / pageParam.getPageSize() + 1;
        }

        PageResult pageResult = new PageResult();
        pageResult.setList(list);
        pageResult.setCurrPage(pageParam.getPageNum());
        pageResult.setPageSize(pageParam.getPageSize());
        pageResult.setTotalCount(count);
        pageResult.setTotalPage(totalPage);

        return pageResult;
    }

    @Override
    public String updateIndexConfig(IndexConfig indexConfig) {
        IndexConfig temp = this.indexConfigDao.getIndexConfigById(indexConfig.getConfigId());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        if (this.indexConfigDao.updateIndexConfig(indexConfig) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String deleteIndexConfig(Integer configId) {
        IndexConfig temp = this.indexConfigDao.getIndexConfigById(configId);
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        if (this.indexConfigDao.deleteIndexConfig(configId) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public IndexConfig getIndexConfigById(Integer configId) {
        return this.indexConfigDao.getIndexConfigById(configId);
    }
}
