package com.example.heartbeatadminserver.controller.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("新增轮播图接口参数类")
public class CarouselAddParam implements Serializable {
    @ApiModelProperty("轮播图url")
    private String imgUrl;
    @ApiModelProperty("跳转url")
    private String jumpUrl;
    @ApiModelProperty("排序")
    private int showRank;
}
