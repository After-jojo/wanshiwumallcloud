package com.wangc.order.controller;

import com.wangc.fmmall.entity.Orders;
import com.wangc.fmmall.entity.ShoppingCartVO;
import com.wangc.order.service.OrderAddService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author After拂晓
 */
@RestController
public class OrderAddController {
    @Resource
    private OrderAddService orderAddService;
    @PostMapping("/order/save")
    public List<ShoppingCartVO> saveOrder(@RequestBody Orders orders, String cids){
        return orderAddService.saveOrder(orders, cids);
    }
}
