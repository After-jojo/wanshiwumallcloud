package com.wangc.orderitem.controller;

import com.wangc.fmmall.entity.ShoppingCartVO;
import com.wangc.orderitem.service.OrderItemAddService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author After拂晓
 */
@RestController
@CrossOrigin
public class OrderItemAddController {
    @Resource
    private OrderItemAddService orderItemAddService;
    @PostMapping("/item/save")
    public int addOrderItem(@RequestBody List<ShoppingCartVO> carts, String orderId){
        return orderItemAddService.save(carts, orderId);
    }
}
