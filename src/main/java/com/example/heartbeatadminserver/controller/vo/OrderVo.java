package com.example.heartbeatadminserver.controller.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderVo {

    private String orderNo;

    private Integer customerId;

    private String address;

    private Integer orderType;

    private Integer orderStatus;

    private String orderStatusName;

    private Integer payStatus;

    private Integer payType;

    private Date payTime;

    private Double totalPrice;

    private Date createTime;

    private Date updateTime;

    private List<OrderItemVo> orderItemVos;
}
