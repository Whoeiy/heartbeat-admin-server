package com.example.heartbeatadminserver.service.Impl;

import com.example.heartbeatadminserver.common.ServiceResultEnum;
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

import java.util.Date;
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

    @Override
    public Vendor queryVendorById(Integer vendorId) {
        return this.vendorDao.getVendorById(vendorId);
    }

    @Override
    public String updateVendor(Vendor vendor) {
        Vendor temp = this.vendorDao.getVendorById(vendor.getVendorId());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        vendor.setUpdateTime(new Date());
        if (this.vendorDao.updateByVendorId(vendor) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String deleteVendor(int vendorId) {
        Vendor vendor = this.vendorDao.getVendorById(vendorId);
        if (vendor == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        if (this.vendorDao.deleteVendorById(vendorId) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String updateIsShown(int vendorId) {
        Vendor vendor = this.vendorDao.getVendorById(vendorId);
        if (vendor == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        if (this.vendorDao.updateVendorIsShownById(vendorId) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }
}
