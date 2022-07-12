package com.example.heartbeatadminserver.entity;

import lombok.Data;

@Data
public class OrderItem {

    private Integer orderItemId;

    private Integer giftId;

    private String giftName;

    private Integer giftCount;

    private String giftImg;

    private Double giftPrice;

    private Double sellingPrice;

    private String service;
}
