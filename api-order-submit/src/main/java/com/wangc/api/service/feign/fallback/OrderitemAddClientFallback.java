package com.wangc.api.service.feign.fallback;

/**
 * @author After拂晓
 */
import com.wangc.api.service.feign.OrderitemAddClient;
import com.wangc.fmmall.entity.ShoppingCartVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderitemAddClientFallback implements OrderitemAddClient {
    @Override
    public int addOrderItem(List<ShoppingCartVO> list, String orderId) {
        System.out.println("stock-update-------服务降级");
        return 0;
    }
}