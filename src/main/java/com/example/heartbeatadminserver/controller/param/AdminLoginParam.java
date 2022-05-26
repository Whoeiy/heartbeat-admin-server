package com.example.heartbeatadminserver.controller.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 管理员登录参数类
 * @author yy
 */
@Data
@ApiModel("Admin登录信息类")
public class AdminLoginParam implements Serializable {
    @ApiModelProperty(name = "name", value = "Admin英文登录名", required = true, dataType = "String")
    private String name;
    @ApiModelProperty(name = "password", value = "Admin登录密码", required = true, dataType = "String")
    private String password;
}
