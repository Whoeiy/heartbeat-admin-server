package com.example.heartbeatadminserver.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Vendor {
    private int vendorId;
    private String nameEn;
    private String nameCn;
    private String passwordMd5;
    private String logoUrl;
    private String store;   // 商家简介
    private int showRank;
    private int isShown;
    private int isDeleted;
    private Date holdTime;
}
