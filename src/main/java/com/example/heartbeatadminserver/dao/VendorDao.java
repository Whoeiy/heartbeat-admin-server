package com.example.heartbeatadminserver.dao;

import com.example.heartbeatadminserver.entity.Vendor;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface VendorDao {

    /**
     * 插入商家
     * @param vendor
     * @return
     */
    int insertVendor(Vendor vendor);

    /**
     * 根据英文名精确查询商家
     * @param nameEn
     * @return
     */
    Vendor getVendorByNameEn(String nameEn);

    /**
     * 根据id获取商家信息
     * @param vendorId
     * @return
     */
    Vendor getVendorById(int vendorId);

    /**
     * 查询商家列表
     * @return
     */
    List<Vendor> getVendorList();

    /**
     * 根据英文名模糊查询商家
     * @param keywords
     * @return
     */
    List<Vendor> getVendorListByKey(String keywords);

    /**
     * 统计商家总数
     * @return
     */
    Integer countTotalVendor();

    /**
     * 统计模糊查询结果的商家总数
     * @param keywords
     * @return
     */
    Integer countSearchVendor(String keywords);

    Integer updateByVendorId(Vendor vendor);

    Integer deleteVendorById(Integer vendorId);

    Integer updateVendorIsShownById(Integer vendorId, Integer showStatus);
}
