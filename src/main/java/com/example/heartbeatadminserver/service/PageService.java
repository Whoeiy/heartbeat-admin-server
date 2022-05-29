//package com.example.heartbeatadminserver.service;
//
//import com.example.heartbeatadminserver.util.PageParam;
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//
//import java.util.List;
//
//public interface PageService<Param, Res> {
//
//    default PageInfo<Res> page(PageParam<Param> param){
//        return PageHelper.startPage(param).doSelectPageInfo(() -> list(param.getParam()));
//    }
//
//    List<Res> list(Param param);
//
//}
