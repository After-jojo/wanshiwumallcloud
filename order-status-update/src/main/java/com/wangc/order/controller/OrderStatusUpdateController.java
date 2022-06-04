package com.wangc.order.controller;
import com.wangc.fmmall.entity.Orders;
import com.wangc.order.service.OrderStatusUpdateService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author After拂晓
 */

@RestController
public class OrderStatusUpdateController {
    @Resource
    private OrderStatusUpdateService orderStatusUpdateService;

    @PutMapping("/order/status/update")
    public int update(@RequestBody Orders order){
        return orderStatusUpdateService.updateStatus(order);
    }
}
