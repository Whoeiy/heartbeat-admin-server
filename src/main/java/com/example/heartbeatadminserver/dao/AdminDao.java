package com.example.heartbeatadminserver.dao;

import com.example.heartbeatadminserver.entity.Admin;
import com.example.heartbeatadminserver.entity.AdminToken;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminDao {
    public Admin getAdminByName(String name);

    public AdminToken getTokenById(Integer adminId);

    public int insertToken(AdminToken adminToken);

    public int updateToken(AdminToken adminToken);
}
