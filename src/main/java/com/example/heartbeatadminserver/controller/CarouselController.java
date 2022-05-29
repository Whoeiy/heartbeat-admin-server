package com.example.heartbeatadminserver.controller;

import com.example.heartbeatadminserver.common.ServiceResultEnum;
import com.example.heartbeatadminserver.controller.param.CarouselAddParam;
import com.example.heartbeatadminserver.entity.Carousel;
import com.example.heartbeatadminserver.service.Impl.CarouselServiceImpl;
import com.example.heartbeatadminserver.util.Result;
import com.example.heartbeatadminserver.util.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin")
public class CarouselController {

    @Autowired
    private CarouselServiceImpl carouselService;

    @PostMapping("/carousel")
    @ApiOperation("/新增轮播图")
    public Result<String> addCarousel(@RequestBody CarouselAddParam param, int adminId) {
        Carousel carousel = new Carousel();
        carousel.setImgUrl(param.getImgUrl());
        carousel.setJumpUrl(param.getJumpUrl());
        carousel.setShowRank(param.getShowRank());
        carousel.setCreateTime(new Date());

        String res = this.carouselService.addCarousel(carousel);
        if( res.equals(ServiceResultEnum.SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(res);
        }
        return ResultGenerator.genFailResult(res);
    }

    @GetMapping("/carousels")
    @ApiOperation("/查询轮播图列表")
    public Result<List> getCarouselList(int adminId) {
        List<Carousel> list = this.carouselService.getCarouselList();
        return ResultGenerator.genSuccessResultData(list);
    }

    @GetMapping("/carousel/{carouselId}")
    @ApiOperation("/查询轮播图详情")
    public Result<Carousel> getCarouselById(@PathVariable int carouselId, int adminId) {
        Carousel carousel = this.carouselService.getCarouselById(carouselId);
        if (carousel != null) {
            return ResultGenerator.genSuccessResultData(carousel);
        }
        return ResultGenerator.genFailResult("未查询到记录");
    }

    @PutMapping("/carousel")
    @ApiOperation("/更新轮播图信息")
    public Result<String> updateCarousel(@RequestBody Carousel carousel, int adminId) {
        String res = this.carouselService.updateCarousel(carousel);
        if (res.equals(ServiceResultEnum.SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(res);
        }
        return ResultGenerator.genFailResult(res);
    }

    @DeleteMapping("/carousel/{carouselId}")
    @ApiOperation("/根据id删除轮播图")
    public Result<String> deleteCarousel(@PathVariable int carouselId, int adminId) {
        String res = this.carouselService.deleteCarouselById(carouselId);
        if (res.equals(ServiceResultEnum.SUCCESS.getResult())){
            return ResultGenerator.genSuccessResult(res);
        }
        return ResultGenerator.genFailResult(res);
    }

}
