package com.example.heartbeatadminserver.service;

public interface AdminService {

    /**
     * 管理员登录
     * @param name
     * @param password
     * @return
     */
    public String adminlogin(String name, String password);

}
