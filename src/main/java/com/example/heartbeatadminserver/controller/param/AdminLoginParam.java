package com.example.heartbeatadminserver.controller.param;

import lombok.Data;

import java.io.Serializable;

/**
 * 管理员登录参数类
 * @author yy
 */
@Data
public class AdminLoginParam implements Serializable {
    private String name;
    private String password;
}
