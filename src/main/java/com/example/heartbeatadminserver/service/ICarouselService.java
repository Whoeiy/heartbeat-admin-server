package com.example.heartbeatadminserver.service;

import com.example.heartbeatadminserver.entity.Carousel;

import java.util.List;

public interface ICarouselService {

    /**
     * 新增轮播图
     * @param carousel
     * @return
     */
    String addCarousel(Carousel carousel);

    /**
     * 查询轮播图列表
     * @return
     */
    List<Carousel> getCarouselList();

    /**
     * 查询轮播图详情
     * @param carouselId
     * @return
     */
    Carousel getCarouselById(Integer carouselId);

    /**
     * 更新轮播图信息
     * @param carousel
     * @return
     */
    String updateCarousel(Carousel carousel);

    /**
     * 根据id删除轮播图
     * @param carouselId
     * @return
     */
    String deleteCarouselById(Integer carouselId);
}
