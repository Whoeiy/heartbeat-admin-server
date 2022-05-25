package com.example.heartbeatadminserver.service;

import com.example.heartbeatadminserver.dao.AdminDao;
import com.example.heartbeatadminserver.entity.Admin;
import com.example.heartbeatadminserver.entity.AdminToken;
import com.example.heartbeatadminserver.util.JwtUtil;
import com.example.heartbeatadminserver.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public String adminlogin(String name, String password) {
        Admin admin = this.adminDao.getAdminByName(name);
        if (admin == null) {
            return "NOT FOUND";
        } else if (admin.getName().equals(name) && admin.getPassword().equals(password)) {
            String token = jwtUtil.createToken(admin);
            AdminToken adminToken = this.adminDao.getTokenById(admin.getAdminID());
            if (adminToken == null) {
                adminToken = new AdminToken();
                adminToken.setAdminId(admin.getAdminID());
                adminToken.setToken(token);
                if (this.adminDao.insertToken(adminToken) > 0) {
                    return token;
                }
            } else {
                adminToken.setToken(token);
                if (this.adminDao.updateToken(adminToken) > 0) {
                    return token;
                }
            }
            return token;
        } else {
            return "ERROR";
        }
    }
}
