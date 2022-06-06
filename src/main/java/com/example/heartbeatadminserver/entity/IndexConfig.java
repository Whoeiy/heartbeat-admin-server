package com.example.heartbeatadminserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
@ApiModel("礼物配置类")
public class IndexConfig {

    private Integer configId;

    private String configName;

    private Integer configType;

    private Integer giftId;

    private String redirectUrl;

    private Integer configRank;

    private Integer isDeleted;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private Integer createUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

}
