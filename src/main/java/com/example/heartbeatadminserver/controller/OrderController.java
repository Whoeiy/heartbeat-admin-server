package com.example.heartbeatadminserver.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.heartbeatadminserver.common.ServiceResultEnum;
import com.example.heartbeatadminserver.controller.vo.OrderVo;
import com.example.heartbeatadminserver.service.Impl.OrderServiceImpl;
import com.example.heartbeatadminserver.util.PageParam;
import com.example.heartbeatadminserver.util.PageResult;
import com.example.heartbeatadminserver.util.Result;
import com.example.heartbeatadminserver.util.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Provider;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/order/list")
    @ApiOperation("/查询订单列表")
    public Result<PageResult> getOrderList(@RequestParam Integer pageNum, @RequestParam Integer pageSize,
                                           String orderNo, Integer orderStatus) {
        if (orderNo.equals("")) {
            orderNo = null;
        }
        PageParam param = new PageParam(pageNum, pageSize);
        PageResult pageResult = this.orderService.getOrderList(orderNo,orderStatus, param);
        if (pageResult != null) {
            return ResultGenerator.genSuccessResultData(pageResult);
        }
        return ResultGenerator.genFailResult(ServiceResultEnum.DB_ERROR.getResult());
    }

    @GetMapping("/order/{orderNo}")
    @ApiOperation("/查询订单详情")
    public Result getOrderDetail(@PathVariable String orderNo) {
        OrderVo orderVo = this.orderService.getOrderDetail(orderNo);
        if (orderVo == null) {
            return ResultGenerator.genFailResult(ServiceResultEnum.DATA_NOT_EXIST.getResult());
        }
        return ResultGenerator.genSuccessResultData(orderVo);
    }

    @PutMapping("/order/startCustomService")
    @ApiOperation("/开始定制")
    public Result startCustomService(@RequestBody String orderNos) {
        String nos = JSON.parseObject(orderNos).getString("orderNos");
        if (nos.equals("")) {
            return ResultGenerator.genFailResult("请输入要操作的订单号");
        }
        String[] input = nos.split(",");
        List<String> orderNoList = Arrays.asList(input);

        String res = this.orderService.startCustomService(orderNoList);
        if (res.equals(ServiceResultEnum.SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult(res);
    }

    @PutMapping("/order/endCustomService")
    @ApiOperation("/定制完成")
    public Result endCustomService(@RequestBody String orderNos) {
        String nos = JSON.parseObject(orderNos).getString("orderNos");
        if (nos.equals("")) {
            return ResultGenerator.genFailResult("请输入要操作的订单号");
        }
        String[] input = nos.split(",");
        List<String> orderNoList = Arrays.asList(input);

        String res = this.orderService.finishCustomService(orderNoList);
        if (res.equals(ServiceResultEnum.SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult(res);
    }

    @PutMapping("/order/checkout")
    @ApiOperation("/出库")
    public Result checkout(@RequestBody String orderNos) {
        String nos = JSON.parseObject(orderNos).getString("orderNos");
        if (nos.equals("")) {
            return ResultGenerator.genFailResult("请输入要操作的订单号");
        }
        String[] input = nos.split(",");
        List<String> orderNoList = Arrays.asList(input);

        String res = this.orderService.checkout(orderNoList);
        if (res.equals(ServiceResultEnum.SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult(res);
    }

    @PutMapping("/order/close")
    @ApiOperation("/关闭订单")
    public Result closeOrder(@RequestBody String orderNos) {
        String nos = JSON.parseObject(orderNos).getString("orderNos");
        if (nos.equals("")) {
            return ResultGenerator.genFailResult("请输入要操作的订单号");
        }
        String[] input = nos.split(",");
        List<String> orderNoList = Arrays.asList(input);

        String res = this.orderService.closeOrder(orderNoList);
        if (res.equals(ServiceResultEnum.SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult(res);
    }
}
