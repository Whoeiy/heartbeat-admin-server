package com.example.heartbeatadminserver.controller;


import com.example.heartbeatadminserver.controller.param.AdminLoginParam;
import com.example.heartbeatadminserver.service.AdminServiceImpl;
import com.example.heartbeatadminserver.util.Result;
import com.example.heartbeatadminserver.util.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 管理员类
 * @author yy
 */
@Slf4j
@Controller
@RequestMapping("/admin")
public class adminController {

    @Autowired
    AdminServiceImpl adminService;

    @ResponseBody
    @PostMapping ("/login")
    public String login(@RequestBody AdminLoginParam adminLoginParam){
        String res = this.adminService.adminlogin(adminLoginParam.getName(), adminLoginParam.getPassword());
        if(res.equals("登录成功")){
            Result result = ResultGenerator.genSuccessResult();
        }

        return "test";
    }
}