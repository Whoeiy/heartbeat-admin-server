package com.example.heartbeatadminserver.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel("商家类")
public class Vendor {
    @ApiModelProperty("商家ID")
    private int vendorId;
    @ApiModelProperty("商家英文名称")
    private String nameEn;
    @ApiModelProperty("商家中文名称")
    private String nameCn;
    @ApiModelProperty("商家密码")
    private String passwordMd5;
    @ApiModelProperty("商家logo图片url")
    private String logoUrl;
    @ApiModelProperty("商家简介")
    private String store;   // 商家简介
    @ApiModelProperty("排序")
    private int showRank;
    @ApiModelProperty("是否显示")
    private int isShown;
    @ApiModelProperty("是否已删除")
    private int isDeleted;
    @ApiModelProperty("添加日期")
    private Date holdTime;
    @ApiModelProperty("更新日期")
    private Date updateTime;
}
