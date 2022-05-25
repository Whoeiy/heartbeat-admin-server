package com.example.heartbeatadminserver.service;

import com.example.heartbeatadminserver.dao.AdminDao;
import com.example.heartbeatadminserver.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminDao adminDao;

    @Override
    public String adminlogin(String name, String password) {
        Admin admin = this.adminDao.getAdminByName(name);
        if (admin == null) {
            return "NOT FOUND";
        } else if (admin.getPassword().equals(password)) {

            return "登录成功";

        } else {
            return "密码错误";
        }
    }
}
