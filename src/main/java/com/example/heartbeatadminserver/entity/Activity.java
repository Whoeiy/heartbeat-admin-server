package com.example.heartbeatadminserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName activity
 */
@TableName(value ="activity")
@Data
public class Activity implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer activityid;

    /**
     * 活动名称
     */
    private String activityname;

    /**
     * 活动详情
     */
    private String activitydetail;

    /**
     * 活动类型: 1-有奖活动，2-主题活动
     */
    private Integer activitytype;

    /**
     * 活动状态：0-未开始，1-进行中，2-已结束
     */
    private Integer activitystatus;

    /**
     * 活动开始时间
     */
    private Date starttime;

    /**
     * 活动结束时间
     */
    private Date endtime;

    /**
     * 优惠券Id
     */
    private Integer couponid;

    /**
     * 排序值
     */
    private Integer showrank;

    /**
     * 是否显示
     */
    private Integer isshown;

    /**
     * 创建用户Id
     */
    private Integer createuser;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 是否删除
     */
    private Integer isdeleted;

    /**
     * 更新时间
     */
    private Date updatetime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}