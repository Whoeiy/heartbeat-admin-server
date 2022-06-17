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
 * @TableName category
 */
@TableName(value ="category")
@Data
public class Category implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer categoryid;

    /**
     * 分类等级
     */
    private Integer categorylevel;

    /**
     * 
     */
    private String categoryname;
    private String categoryicon;

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