package com.example.heartbeatadminserver;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.heartbeatadminserver.dao.*;
import com.example.heartbeatadminserver.entity.*;
import com.example.heartbeatadminserver.service.ICategoryService;
import com.example.heartbeatadminserver.service.IGiftService;
import com.example.heartbeatadminserver.service.Impl.GiftServiceImpl;
import com.example.heartbeatadminserver.service.LabelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class HeartbeatAdminServerApplicationTests {

    @Autowired
    private LabelService labelService;
    @Test
    void testTest(){

    }
//    @Test
//    void testGetById3(){
//        System.out.println(labelService.getById(1));
//    }
//
//
//
//    // category service test
//    // 业务层测试
//    @Autowired
//    private ICategoryService categoryService;
//
//    @Test
//    void testGetById2(){
//        System.out.println(categoryService.getById(1));
//    }
//
//
//    // category dao test
//    // 数据层测试
//    @Autowired
//    private CategoryDao categoryDao;
//
//    @Test
//    void testGetById(){
//        System.out.println(categoryDao.selectById(1));
//    }
//
//    @Test
//    void testSave(){
//        Category category = new Category();
//        category.setCategoryname("testaaa");
//        category.setCategorylevel(2);
//        category.setCategoryname("testbbb");
//        category.setCategoryrank(2);
//        category.setParentid(2);
//        category.setCreateuser(1);
//        for (int i = 0; i < 5; i++) {
//            categoryDao.insert(category);
//        }
//
//    }
//
//
//    @Test
//    void testUpdate(){
//        Category category = new Category();
//        category.setCategoryid(1);
//        category.setCategoryname("test_new");
//        category.setCategorylevel(3);
//        category.setCategoryname("testnew22");
//        category.setCategoryrank(3);
//        category.setParentid(3);
//        category.setCreateuser(1);
//        System.out.println(categoryDao.updateById(category));
//    }
//
//    @Test
//    void testDelete(){
//        System.out.println(categoryDao.deleteById(5));
//    }
//
//    @Test
//    void testGetAll(){
//        System.out.println(categoryDao.selectList(null));
//    }
//
////    @Test
////    void testGetPage(){
////        IPage page = new Page(2,4);
////        categoryDao.selectPage(page,null);
////
////    }
//
//    @Test
//    void testGetBy(){
//        QueryWrapper<Category> qw = new QueryWrapper<>();
//        qw.like("categoryName","w2");
//        System.out.println(categoryDao.selectList(qw));
//    }
//
//    @Test
//    void testGetBy2(){
//        String name = "w2";
//        LambdaQueryWrapper<Category> qw = new LambdaQueryWrapper<Category>();
//        qw.like(name!=null,Category::getCategoryname,name);
//        System.out.println(categoryDao.selectList(qw));
//    }
//
//    // carousel
//    @Autowired
//    private CarouselDao carouselDao;
//
//    @Test
//    void testGetCarouselList(){
//        System.out.println(this.carouselDao.getCarouselList());
//    }
//
//    @Test
//    void testGetCarouselById(){
//        System.out.println(this.carouselDao.getCarouselById(3));
//    }
//
//    @Test
//    void testDeleteCarousel(){
//        System.out.println(this.carouselDao.deleteCarouselById(3));
//    }

//    @Autowired
//    private AdminDao adminDao;
//
//    @Test
//    void testInsertToken(){
//        AdminToken adminToken = new AdminToken(1,1,"test");
//        System.out.print(adminDao.insertToken(adminToken));
//    }
//
//    @Test
//    void testUpdateToken(){
//        AdminToken adminToken = new AdminToken(1,1,"testtt");
//        System.out.println(adminDao.updateToken(adminToken));
//    }
//    @Test
//    void testGetTokenById(){
//        AdminToken adminToken = adminDao.getTokenById(2);
//        System.out.println(adminToken);
//    }
//    @Test
//    void contextLoads() {
//    }
//
//    @Test
//    void testGetAdminById() {
//        Admin admin = adminDao.getAdminById((1));
//        System.out.println(admin);
//    }
//
//    // vendor
//    @Autowired
//    private VendorDao vendorDao;
//    @Test
//    void testGetVendorByNameEn(){
//        Vendor vendor = vendorDao.getVendorByNameEn("daoxc");
//        System.out.println(vendor);
//    }
//
//    @Test
//    void testGetVendorList(){
//        List<Vendor> vendorList = vendorDao.getVendorList();
//        System.out.println(vendorList);
//    }
//
//    @Test
//    void testGetVendorListByKey(){
//        List<Vendor> vendorList = vendorDao.getVendorListByKey("daoxczm");
//        System.out.println(vendorList);
//    }
//
//    @Test
//    void testGetVendorById(){
//        Vendor vendor = vendorDao.getVendorById(10);
//        System.out.println(vendor);
//    }
//
//    @Test
//    void testUpdateVendorById(){
//
//    }
//
//    @Test
//    void testDeleteVendorById(){
//        System.out.println(vendorDao.deleteVendorById(5));
//    }

//    @Autowired
//    private GiftServiceImpl giftService;
//    @Test
//    void testGetCategories(){
//        System.out.println(this.giftService.getCategoryIds(51));
//    }
//
//    @Test
//    void testGetCategoriesDetail(){
//        System.out.println(this.giftService.getGiftCategories(5));
//    }
//
//    @Test
//    void testGetLabelsDetail(){
//        System.out.println(this.giftService.getGiftLabels(6));
//    }

    @Autowired
    private IndexConfigDao indexConfigDao;

    @Autowired GiftDao giftDao;

    @Test
    void testGetList() {
        System.out.println(this.indexConfigDao.gitIndexConfigListByType(2));
    }

    @Test
    void testGetLabels() {
        List<Integer> ids = new ArrayList<>();
        ids.add(38);
        System.out.println(ids);
        List<Label> labels = this.giftDao.getGiftLabelsByIds(ids);
        System.out.println(labels);
    }


}
