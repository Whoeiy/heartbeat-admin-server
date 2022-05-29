package com.example.heartbeatadminserver.dao;

import com.example.heartbeatadminserver.entity.Carousel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarouselDao {

    // 插入轮播图
    Integer insertCarousel(Carousel carousels);

    // 查询轮播图列表
    List<Carousel> getCarouselList();

    // 查询轮播图详情
    Carousel getCarouselById(Integer carouselId);

    // 更新轮播图信息
    Integer updateCarousel(Carousel carousel);

    // 删除轮播图
    Integer deleteCarouselById(Integer carouselId);
}
