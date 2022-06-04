package com.wangc.orderitem.service;

import com.wangc.fmmall.entity.OrderItem;
import com.wangc.fmmall.entity.ShoppingCartVO;
import com.wangc.orderitem.dao.OrderItemMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author After拂晓
 */
@Service
public class OrderItemAddService {
    @Resource
    private OrderItemMapper orderItemMapper;
    public int save(List<ShoppingCartVO> carts, String orderId){
        int result = 1;
        for(ShoppingCartVO vo : carts){
            int cartNum = Integer.parseInt(vo.getCartNum());
            String itemId = System.currentTimeMillis() + "" + (new Random().nextInt(8999) + 1000);
            OrderItem orderItem = new OrderItem(itemId, orderId, vo.getProductId(), vo.getProductName(), vo.getProductImg()
                    , vo.getSkuId(), vo.getSkuName(), vo.getSellPrice(), cartNum, vo.getSellPrice() * cartNum, new Date(), new Date(), 0);
            int insert = orderItemMapper.insert(orderItem);
            result *= insert;
        }
        return result;
    }
}
