package com.wangc.order.controller;

import com.wangc.order.service.OrderCloseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author After拂晓
 */
@RestController
public class OrderCloseController {
    @Resource
    private OrderCloseService orderCloseService;

    @GetMapping("/order/close")
    public int close(String orderId,int closeType){
        int i = orderCloseService.closeOrder(orderId,closeType);
        return i;
    }
}
