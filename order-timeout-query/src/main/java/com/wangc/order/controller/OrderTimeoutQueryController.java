package com.wangc.order.controller;

/**
 * @author After拂晓
 */
import com.wangc.fmmall.entity.Orders;
import com.wangc.order.service.OrderTimeoutQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OrderTimeoutQueryController {
    @Resource
    private OrderTimeoutQueryService orderTimeoutQueryService;
    @GetMapping("/order/query/timeout")
    public List<Orders> query(){
        //查询并返回超时未支付的订单
        return orderTimeoutQueryService.listOrders();
    }
}
