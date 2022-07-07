package com.example.heartbeatadminserver.dao;

import com.example.heartbeatadminserver.entity.Coupon;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* @author lihanbin
* @description 针对表【coupon】的数据库操作Mapper
* @createDate 2022-07-07 11:46:06
* @Entity com.example.heartbeatadminserver.entity.Coupon
*/
@Mapper
@Repository
public interface CouponMapper extends BaseMapper<Coupon> {

}




