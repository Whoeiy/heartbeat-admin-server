package com.example.heartbeatadminserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @TableName coupon
 */
@TableName(value ="coupon")
@Data
public class Coupon implements Serializable {
    /**
     * 优惠券Id
     */
    @TableId(type = IdType.AUTO)
    private Integer couponid;

    /**
     * 优惠券名称
     */
    private String couponname;

    /**
     * 优惠券类型：1 - 活动优惠券，2 - 普通优惠券
     */
    private Integer coupontype;

    /**
     * 优惠券金额
     */
    private Double couponprice;

    /**
     * 优惠券生效时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date starttime;

    /**
     * 优惠券失效时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endtime;

    /**
     * 排序值
     */
    private Integer showrank;

    /**
     * 是否显示：0 - 不显示，1 - 显示
     */
    private Integer isshown;

    /**
     * 创建用户Id
     */
    private Integer createuser;

    /**
     * 是否删除：0 - 未删除，1 - 已删除
     */
    private Integer isdeleted;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}