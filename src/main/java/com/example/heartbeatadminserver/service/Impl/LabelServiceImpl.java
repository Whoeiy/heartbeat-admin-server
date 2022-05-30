package com.example.heartbeatadminserver.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.heartbeatadminserver.entity.Label;
import com.example.heartbeatadminserver.service.LabelService;
import com.example.heartbeatadminserver.dao.LabelMapper;
import org.springframework.stereotype.Service;

/**
* @author lihanbin
* @description 针对表【label】的数据库操作Service实现
* @createDate 2022-05-29 23:37:20
*/
@Service
public class LabelServiceImpl extends ServiceImpl<LabelMapper, Label>
    implements LabelService{

}




