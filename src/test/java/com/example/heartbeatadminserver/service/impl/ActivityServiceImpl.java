package com.example.heartbeatadminserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.heartbeatadminserver.entity.Activity;
import com.example.heartbeatadminserver.service.ActivityService;
import com.example.heartbeatadminserver.dao.ActivityMapper;
import org.springframework.stereotype.Service;

/**
* @author lihanbin
* @description 针对表【activity】的数据库操作Service实现
* @createDate 2022-07-11 11:57:45
*/
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity>
    implements ActivityService{

}




