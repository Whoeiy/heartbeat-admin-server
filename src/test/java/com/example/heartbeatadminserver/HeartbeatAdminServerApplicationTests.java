package com.example.heartbeatadminserver;

import com.example.heartbeatadminserver.dao.AdminDao;
import com.example.heartbeatadminserver.entity.AdminToken;
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

}
