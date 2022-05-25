package com.example.heartbeatadminserver.dao;

import com.example.heartbeatadminserver.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminDao {
    public Admin getAdminByName(String name);
}
