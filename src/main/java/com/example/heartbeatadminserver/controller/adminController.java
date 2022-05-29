package com.example.heartbeatadminserver.controller;


import com.example.heartbeatadminserver.controller.param.AdminLoginParam;
import com.example.heartbeatadminserver.entity.Admin;
import com.example.heartbeatadminserver.service.Impl.AdminServiceImpl;
import com.example.heartbeatadminserver.util.Result;
import com.example.heartbeatadminserver.util.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 管理员Controller类
 * @author yy
 */
@Slf4j
@RestController
@RequestMapping("/admin")
@Api("Admin")
public class adminController {

    @Autowired
    AdminServiceImpl adminService;

    @PostMapping ("/login")
    @ApiOperation("/Admin登录")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "name", value = "Admin英文登录名", required = true, paramType = "body", dataType = "String"),
//            @ApiImplicitParam(name = "password", value = "Admin登录密码", required = true, paramType = "body", dataType = "String")
//    })
    public Result<String> login(@RequestBody AdminLoginParam adminLoginParam){
        String res = this.adminService.adminlogin(adminLoginParam.getName(), adminLoginParam.getPassword());
        Result result = new Result();
        if(res.equals("NOT FOUND")){
            result = ResultGenerator.genFailResult("用户名不存在");
        } else if (res.equals("ERROR")) {
            result = ResultGenerator.genFailResult("用户名或密码错误");
        } else {
            result = ResultGenerator.genSuccessResultData(res);
        }
        return result;
    }

//    public Result profile()
    @GetMapping("/profile")
    @ApiOperation("/获取Admin信息")
    @ApiImplicitParam(name = "adminId", value = "从管理员的token中获得，在header中添加token", required = true, paramType = "header", dataType = "Integer", dataTypeClass = Integer.class)
    public Result<Admin> profile(int adminId) {
        Admin admin = this.adminService.getAdminById(adminId);
        admin.setPassword("******");
        return ResultGenerator.genSuccessResultData(admin);
    }

    @GetMapping("/getUserByFilter")
    public Result<Admin> getUserByFilter(String name, int adminId) {
        Admin admin = new Admin();
        admin.setName(name);
        admin.setAdminID(adminId);
        return ResultGenerator.genSuccessResultData(admin);
    }

}
