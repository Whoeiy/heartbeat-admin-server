package com.example.heartbeatadminserver.service.Impl;

import com.alibaba.fastjson.JSON;
import com.example.heartbeatadminserver.common.ServiceResultEnum;
import com.example.heartbeatadminserver.controller.vo.OrderItemVo;
import com.example.heartbeatadminserver.controller.vo.OrderVo;
import com.example.heartbeatadminserver.dao.OrderDao;
import com.example.heartbeatadminserver.entity.Order;
import com.example.heartbeatadminserver.entity.OrderItem;
import com.example.heartbeatadminserver.service.OrderService;
import com.example.heartbeatadminserver.util.BeanUtil;
import com.example.heartbeatadminserver.util.PageParam;
import com.example.heartbeatadminserver.util.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    private Map<Integer, String> getOrderStatusNameMap() {
        Map<Integer, String> serviceMap = new HashMap<>();
        serviceMap.put(0, "待支付");
        serviceMap.put(1, "已支付");
        serviceMap.put(2, "定制中");
        serviceMap.put(3, "定制完成");
        serviceMap.put(4, "出库成功");
        serviceMap.put(5, "交易完成");
        serviceMap.put(6, "手动关闭");
        serviceMap.put(7, "用户取消");
        return serviceMap;
    }

    @Override
    public PageResult<List> getOrderList(String orderNo, Integer orderStatus, PageParam param) {

        // 开始分页
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<Order> orderList = this.orderDao.getOrderList(orderNo, orderStatus);
        PageInfo<Order> info = new PageInfo<>(orderList);

        PageResult pageResult = new PageResult();

        pageResult.setCurrPage(info.getPageNum());
        pageResult.setPageSize(info.getPageSize());
        pageResult.setTotalCount((int)info.getTotal());
        pageResult.setTotalPage(info.getPages());

        if (orderList == null) {
            return null;
        }

        pageResult.setList(orderList);
        return pageResult;
    }

    @Override
    public OrderVo getOrderDetail(String orderNo) {
        Order order = this.orderDao.getOrder(orderNo);
        if (order == null) {
            return null;
        }

        OrderVo orderVo = new OrderVo();
        BeanUtil.copyProperties(order, orderVo);
        // 订单状态名称
        orderVo.setOrderStatusName(this.getOrderStatusNameMap().get(order.getOrderStatus()));
        // 订单Item列表
        List<OrderItem> orderItemList = this.orderDao.getOrderItemList(orderNo);

        List<OrderItemVo> orderItemVos = new ArrayList<>();
        for (OrderItem orderItem : orderItemList) {
            OrderItemVo orderItemVo = new OrderItemVo();
            BeanUtil.copyProperties(orderItem, orderItemVo);
            // 转换定制服务信息
            orderItemVo.setService(JSON.parseObject(orderItem.getService()));
            orderItemVos.add(orderItemVo);
        }
        orderVo.setOrderItemVos(orderItemVos);

        return orderVo;

    }

    @Override
    public String startCustomService(List<String> orderNos) {
        // 订单状态：已支付 -> 定制中
        if (this.orderDao.updateOrderStatus(orderNos, 2) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String finishCustomService(List<String> orderNos) {
        // 订单状态：定制中 -> 定制完成
        if (this.orderDao.updateOrderStatus(orderNos, 3) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String checkout(List<String> orderNos) {
        // 订单状态：定制完成 -> 出库成功
        if (this.orderDao.updateOrderStatus(orderNos, 4) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String closeOrder(List<String> orderNos) {
        if (this.orderDao.updateOrderStatus(orderNos, 6) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }
}
