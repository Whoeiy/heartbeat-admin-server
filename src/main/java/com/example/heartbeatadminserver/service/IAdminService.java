package com.example.heartbeatadminserver.service;

import com.example.heartbeatadminserver.entity.Admin;

public interface IAdminService {

    /**
     * 管理员登录
     * @param name
     * @param password
     * @return
     */
    public String adminlogin(String name, String password);

    public Admin getAdminById(Integer adminId);

}
