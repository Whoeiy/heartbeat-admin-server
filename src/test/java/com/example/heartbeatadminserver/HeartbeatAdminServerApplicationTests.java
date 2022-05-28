package com.example.heartbeatadminserver;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

import java.lang.invoke.LambdaConversionException;
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

    @Test
    void testSave(){
        Category category = new Category();
        category.setCategoryname("testaaa");
        category.setCategorylevel(2);
        category.setCategoryname("testbbb");
        category.setCategoryrank(2);
        category.setParentid(2);
        category.setCreateuser(1);
        for (int i = 0; i < 5; i++) {
            categoryDao.insert(category);
        }

    }


    @Test
    void testUpdate(){
        Category category = new Category();
        category.setCategoryid(1);
        category.setCategoryname("test_new");
        category.setCategorylevel(3);
        category.setCategoryname("testnew22");
        category.setCategoryrank(3);
        category.setParentid(3);
        category.setCreateuser(1);
        System.out.println(categoryDao.updateById(category));
    }

    @Test
    void testDelete(){
        System.out.println(categoryDao.deleteById(5));
    }

    @Test
    void testGetAll(){
        System.out.println(categoryDao.selectList(null));
    }

    @Test
    void testGetPage(){
        IPage page = new Page(2,4);
        categoryDao.selectPage(page,null);

    }

    @Test
    void testGetBy(){
        QueryWrapper<Category> qw = new QueryWrapper<>();
        qw.like("categoryName","w2");
        System.out.println(categoryDao.selectList(qw));
    }

    @Test
    void testGetBy2(){
        String name = "w2";
        LambdaQueryWrapper<Category> qw = new LambdaQueryWrapper<Category>();
        qw.like(name!=null,Category::getCategoryname,name);
        System.out.println(categoryDao.selectList(qw));
    }







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
