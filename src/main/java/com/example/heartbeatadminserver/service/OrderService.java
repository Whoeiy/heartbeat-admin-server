package com.example.heartbeatadminserver.service;

import com.example.heartbeatadminserver.controller.vo.OrderVo;
import com.example.heartbeatadminserver.util.PageParam;
import com.example.heartbeatadminserver.util.PageResult;

import java.util.List;

public interface OrderService {
    // 查询订单列表
    PageResult<List> getOrderList(String orderNo, Integer orderStatus, PageParam param);

    // 查询订单详情
    OrderVo getOrderDetail(String orderNo);

    // 开始定制
    String startCustomService(List<String> orderNos);

    // 定制完成
    String finishCustomService(List<String> orderNos);

    // 出库
    String checkout(List<String> orderNos);

    // 关闭订单
    String closeOrder(List<String> orderNos);
}
