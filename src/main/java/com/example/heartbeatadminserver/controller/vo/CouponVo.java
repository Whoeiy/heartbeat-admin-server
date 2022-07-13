package com.example.heartbeatadminserver.controller.vo;


import com.example.heartbeatadminserver.entity.Activity;
import com.example.heartbeatadminserver.entity.Coupon;
import lombok.Data;

@Data
public class CouponVo {
    private Activity activity;
    private Coupon coupon;
}
