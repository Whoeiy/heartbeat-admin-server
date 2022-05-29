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
 * @TableName label
 */
@TableName(value ="label")
@Data
public class Label implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer labelid;

    /**
     * 
     */
    private String labelname;

    /**
     * 
     */
    private Integer categoryrank;

    /**
     * 
     */
    private Date createtime;

    /**
     * adminID
     */
    private Integer createuser;

    /**
     * 0 - 未删除, 1 - 已删除
     */
    private Integer isdeleted;

    /**
     * 
     */
    private Date updatetime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}