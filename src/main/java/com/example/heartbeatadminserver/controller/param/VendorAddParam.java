package com.example.heartbeatadminserver.controller.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("新增商家接口参数类")
public class VendorAddParam {
    @ApiModelProperty(name = "nameCn", value = "商家中文名称", required = true, dataType = "String")
    private String nameCn;
    @ApiModelProperty(name = "nameEn", value = "商家英文名称", required = true, dataType = "String")
    private String nameEn;
    @ApiModelProperty(name = "logoUrl", value = "商家logo图片url", required = true, dataType = "String")
    private String logoUrl;
    @ApiModelProperty(name = "intro", value = "商家简介", required = true, dataType = "String")
    private String intro;
    @ApiModelProperty(name = "showRank", value = "排序", required = true, dataType = "Integer")
    private Integer showRank;
    @ApiModelProperty(name = "isShown", value = "是否显示，0：不显示，1：显示", required = true, dataType = "Integer")
    private Integer isShown;
}
