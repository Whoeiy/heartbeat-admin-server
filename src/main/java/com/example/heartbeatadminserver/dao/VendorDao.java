package com.example.heartbeatadminserver.dao;

import com.example.heartbeatadminserver.entity.Vendor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VendorDao {

    int insertVendor(Vendor vendor);

    Vendor getVendorByNameEn(String nameEn);

    List<Vendor> getVendorList();

    List<Vendor> getVendorListByKey(String keywords);

    Integer countTotalVendor();

    Integer countSearchVendor(String keywords);
}
