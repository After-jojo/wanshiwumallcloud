package com.wangc.api.service.feign.fallback;

/**
 * @author After拂晓
 */
import com.wangc.api.service.feign.OrderAddClient;
import com.wangc.fmmall.entity.Orders;
import com.wangc.fmmall.entity.ShoppingCartVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderAddClientFallback implements OrderAddClient {
    @Override
    public List<ShoppingCartVO> saveOrder(Orders order, String cids) {
//        System.out.println("order-add-------服务降级");
        return null;
    }
}
