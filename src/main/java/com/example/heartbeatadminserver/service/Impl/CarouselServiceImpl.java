package com.example.heartbeatadminserver.service.Impl;

import com.example.heartbeatadminserver.common.ServiceResultEnum;
import com.example.heartbeatadminserver.dao.CarouselDao;
import com.example.heartbeatadminserver.entity.Carousel;
import com.example.heartbeatadminserver.entity.Vendor;
import com.example.heartbeatadminserver.service.ICarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CarouselServiceImpl implements ICarouselService {

    @Autowired
    private CarouselDao carouselDao;

    @Override
    public String addCarousel(Carousel carousel) {
        if (this.carouselDao.insertCarousel(carousel) > 0){
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public List<Carousel> getCarouselList() {
        List<Carousel> list = this.carouselDao.getCarouselList();
        return list;
    }

    @Override
    public Carousel getCarouselById(Integer carouselId) {
        Carousel carousel = this.carouselDao.getCarouselById(carouselId);
        return carousel;
    }

    @Override
    public String updateCarousel(Carousel carousel) {
        Carousel temp = this.carouselDao.getCarouselById(carousel.getCarouselId());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        carousel.setUpdateTime(new Date());
        if (this.carouselDao.updateCarousel(carousel) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String deleteCarouselById(Integer carouselId) {
        Carousel carousel = this.carouselDao.getCarouselById(carouselId);
        if (carousel == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        if (this.carouselDao.deleteCarouselById(carouselId) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }
}
