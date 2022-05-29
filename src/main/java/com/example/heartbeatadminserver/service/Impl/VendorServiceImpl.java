package com.example.heartbeatadminserver.service.Impl;

import com.example.heartbeatadminserver.dao.VendorDao;
import com.example.heartbeatadminserver.entity.Vendor;
import com.example.heartbeatadminserver.service.IVendorService;
import com.example.heartbeatadminserver.util.PageParam;
import com.example.heartbeatadminserver.util.PageResult;
import com.example.heartbeatadminserver.util.Result;
import com.example.heartbeatadminserver.util.ResultGenerator;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements IVendorService{

    @Autowired
    private VendorDao vendorDao;

    @Override
    public Result addVendor(Vendor vendor) {
        Vendor old = this.vendorDao.getVendorByNameEn(vendor.getNameEn());
        if (old != null){
            return ResultGenerator.genFailResult("该商家已存在！");
        } else if (this.vendorDao.insertVendor(vendor) > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(null);
        }
    }

    @Override
    public PageResult queryVendorListPaged(String keywords, PageParam pageParam) {
        List<Vendor> list = null;
        int count = 0;

        // 开始分页
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
        if (keywords != null){
            list = this.vendorDao.getVendorListByKey(keywords);
            count = this.vendorDao.countSearchVendor(keywords);
        } else {
            list = this.vendorDao.getVendorList();
            count = this.vendorDao.countTotalVendor();
        }

        int totalPage = 1;
        if (count >= pageParam.getPageSize()){
            totalPage = count / pageParam.getPageSize();
        }

        PageResult pageResult = new PageResult();
        pageResult.setList(list);
        pageResult.setCurrPage(pageParam.getPageNum());
        pageResult.setPageSize(pageParam.getPageSize());
        pageResult.setTotalCount(count);
        pageResult.setTotalPage(totalPage);

        return pageResult;
    }
}
