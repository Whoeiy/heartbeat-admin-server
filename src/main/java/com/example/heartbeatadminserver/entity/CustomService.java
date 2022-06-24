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
 * @TableName gift_custom_service
 */
@TableName(value ="gift_custom_service")
@Data
public class CustomService implements Serializable {
    /**
     * 服务Id
     */
    @TableId(type = IdType.AUTO)
    private Integer serviceid;

    /**
     * 服务名称
     */
    private String servicename;

    /**
     * 服务样图url
     */
    private String sampleimg;

    /**
     * 服务类型: 1 - 定制卡片 2 - 定制包装 3 - 定制外观 4 - 商家特供
     */
    private Integer servicetype;

    /**
     * 排序值
     */
    private Integer showrank;

    /**
     * 是否显示: 0 - 不显示 1 - 显示
     */
    private Integer isshown;

    /**
     * 创建商家Id
     */
    private Integer vendorid;

    /**
     * 是否已删除: 0 - 未删除 1 - 已删除
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