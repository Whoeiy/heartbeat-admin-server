package com.example.heartbeatadminserver;

import com.example.heartbeatadminserver.dao.AdminDao;
import com.example.heartbeatadminserver.dao.VendorDao;
import com.example.heartbeatadminserver.entity.Admin;
import com.example.heartbeatadminserver.entity.AdminToken;
import com.example.heartbeatadminserver.entity.Vendor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HeartbeatAdminServerApplicationTests {

    @Autowired
    private AdminDao adminDao;

    @Test
    void testInsertToken(){
        AdminToken adminToken = new AdminToken(1,1,"test");
        System.out.print(adminDao.insertToken(adminToken));
    }

    @Test
    void testUpdateToken(){
        AdminToken adminToken = new AdminToken(1,1,"testtt");
        System.out.println(adminDao.updateToken(adminToken));
    }
    @Test
    void testGetTokenById(){
        AdminToken adminToken = adminDao.getTokenById(2);
        System.out.println(adminToken);
    }
    @Test
    void contextLoads() {
    }

    @Test
    void testGetAdminById() {
        Admin admin = adminDao.getAdminById((1));
        System.out.println(admin);
    }

    // vendor
    @Autowired
    private VendorDao vendorDao;
    @Test
    void testGetVendorByNameEn(){
        Vendor vendor = vendorDao.getVendorByNameEn("daoxc");
        System.out.println(vendor);
    }

}
