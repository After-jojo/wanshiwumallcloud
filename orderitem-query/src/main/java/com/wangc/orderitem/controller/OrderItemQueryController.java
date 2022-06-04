package com.wangc.orderitem.controller;

import com.wangc.fmmall.entity.OrderItem;
import com.wangc.orderitem.service.OrderItemQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author After拂晓
 */
@RestController
public class OrderItemQueryController {
    @Resource
    private OrderItemQueryService orderItemQueryService;

    @GetMapping("/orderitem/query")
    public List<OrderItem> query(String orderId){
        List<OrderItem> orderItems = orderItemQueryService.queryOrderItem(orderId);
        return orderItems;
    }
}
