package com.example.heartbeatadminserver.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private String orderNo;

    private Integer customerId;

    private String address;

    private Integer orderType;

    private Integer orderStatus;

    private Integer payStatus;

    private Integer payType;

    private Date payTime;

    private Double totalPrice;

    private Date createTime;

    private Date updateTime;

}
