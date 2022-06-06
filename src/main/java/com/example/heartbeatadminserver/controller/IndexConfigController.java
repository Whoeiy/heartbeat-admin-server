package com.example.heartbeatadminserver.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.heartbeatadminserver.common.ServiceResultEnum;
import com.example.heartbeatadminserver.entity.IndexConfig;
import com.example.heartbeatadminserver.service.Impl.IndexConfigImpl;
import com.example.heartbeatadminserver.util.PageParam;
import com.example.heartbeatadminserver.util.PageResult;
import com.example.heartbeatadminserver.util.Result;
import com.example.heartbeatadminserver.util.ResultGenerator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/admin")
public class IndexConfigController {

    @Autowired
    private IndexConfigImpl indexConfig;

    @PostMapping("/indexConfig")
    @ApiOperation("/新增礼物配置")
    public Result<String> addIndexConfig(@RequestBody IndexConfig indexConfig, int adminId) {
        indexConfig.setCreateTime(new Date());
        if (this.indexConfig.addIndexConfig(indexConfig).equals(ServiceResultEnum.SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult(null);
    }

    @GetMapping("/indexConfig")
    @ApiOperation("/查询礼物配置列表")
    public Result<PageResult> getIndexConfigListByType(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam Integer configType, int adminId) {
        PageParam pageParam = new PageParam();
        pageParam.setPageNum(pageNum);
        pageParam.setPageSize(pageSize);
        Integer type = configType;

        PageResult pageResult = this.indexConfig.getIndexConfigListByType(type, pageParam);
        Result<PageResult> result = ResultGenerator.genSuccessResultData(pageResult);

        return result;
    }

    @PutMapping("/indexConfig")
    @ApiOperation("/更新礼物配置信息")
    public Result<String> updateIndexConfig(@RequestBody IndexConfig indexConfig, int adminId) {
        String res = this.indexConfig.updateIndexConfig(indexConfig);
        if (res.equals(ServiceResultEnum.SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(res);
        }
        return ResultGenerator.genFailResult(res);
    }

    @DeleteMapping("/indexConfig")
    @ApiOperation("/删除礼物配置")
    public Result<String> deleteIndexConfig(@RequestParam Integer configId, int adminId) {
        String res = this.indexConfig.deleteIndexConfig(configId);
        if (res.equals(ServiceResultEnum.SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(res);
        }
        return ResultGenerator.genFailResult(res);
    }

    @GetMapping("/indexConfig/{configId}")
    @ApiOperation("查询礼物详情")
    public Result<IndexConfig> gitIndexConfigById(@PathVariable Integer configId, int adminId) {
        IndexConfig indexConfig = this.indexConfig.getIndexConfigById(configId);
        if (indexConfig != null) {
            return ResultGenerator.genSuccessResultData(indexConfig);
        }
        return ResultGenerator.genFailResult("未查询到该配置");
    }
}
