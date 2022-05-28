package com.example.heartbeatadminserver;

import com.example.heartbeatadminserver.dao.AdminDao;
import com.example.heartbeatadminserver.dao.CategoryDao;
import com.example.heartbeatadminserver.dao.VendorDao;
import com.example.heartbeatadminserver.entity.Admin;
import com.example.heartbeatadminserver.entity.AdminToken;
import com.example.heartbeatadminserver.entity.Category;
import com.example.heartbeatadminserver.entity.Vendor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class HeartbeatAdminServerApplicationTests {

    // category dao test
    // 数据层测试
    @Autowired
    private CategoryDao categoryDao;

    @Test
    void testGetById(){
        System.out.println(categoryDao.selectById(1));
    }

//    @Test
//    void testSave(){
//        Category category = new Category();
//        category.setCategoryname("test2");
//        category.setCategorylevel(2);
//        category.setCategoryname("test2");
//        category.setCategoryrank(2);
//        category.setParentid(2);
//        category.setCreateuser(2);
//        System.out.println(category);
//        categoryDao.insert(category);
//    }

//
//    @Test
//    void testUpdate(){
//        System.out.println(categoryDao.selectById());
//    }
//
//    @Test
//    void testDelete(){
//        System.out.println(categoryDao.selectById());
//    }
//
//    @Test
//    void testGetAll(){
//        System.out.println(categoryDao.selectById());
//    }
//
//    @Test
//    void testGetPage(){
//        System.out.println(categoryDao.selectById());
//    }
//
//    @Test
//    void testGetBy(){
//        System.out.println(categoryDao.selectById());
//    }







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
