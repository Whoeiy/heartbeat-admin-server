package com.example.heartbeatadminserver.dao;

import com.example.heartbeatadminserver.entity.Order;
import com.example.heartbeatadminserver.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {

    // 查询订单列表
    List<Order> getOrderList(String orderNo, Integer orderStatus);

    // 查询订单详情
    Order getOrder(String orderNo);

    // 查询订单Item列表
    List<OrderItem> getOrderItemList(String orderNo);

    // 更新订单的状态
    Integer updateOrderStatus(List<String> orderNos, Integer orderStatus);
}
