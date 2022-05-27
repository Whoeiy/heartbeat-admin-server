package com.example.heartbeatadminserver.dao;

import com.example.heartbeatadminserver.entity.Vendor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VendorDao {

    int insertVendor(Vendor vendor);

    Vendor getVendorByNameEn(String nameEn);
}
