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
 * @TableName label_new
 */
@TableName(value ="label_new")
@Data
public class LabelNew implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer labelid;

    /**
     * 标签等级
     */
    private Integer labellevel;

    /**
     * 
     */
    private String labelname;
    private String labelicon;

    /**
     * 
     */
    private Integer labelrank;

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
     * 一级分类默认为0
     */
    private Integer parentid;

    /**
     * 
     */
    private Date updatetime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}