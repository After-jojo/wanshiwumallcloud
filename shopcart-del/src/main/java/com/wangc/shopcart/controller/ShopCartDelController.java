package com.wangc.shopcart.controller;

import com.wangc.shopcart.service.ShopCartDelService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author After拂晓
 */
@RestController
public class ShopCartDelController {
    @Resource
    private ShopCartDelService shopCartDelService;
    @DeleteMapping("/shopcart/del")
    public int delete(String cids){
        return shopCartDelService.deleteShop(cids);
    }
}
