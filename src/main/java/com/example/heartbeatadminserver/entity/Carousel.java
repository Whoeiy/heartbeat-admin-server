package com.example.heartbeatadminserver.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("轮播图类")
public class Carousel {
    @ApiModelProperty("轮播图id")
    private int carouselId;
    @ApiModelProperty("轮播图url")
    private String imgUrl;
    @ApiModelProperty("跳转url")
    private String jumpUrl;
    @ApiModelProperty("排序")
    private int showRank;
    @ApiModelProperty("是否已删除")
    private int isDeleted;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;
}
