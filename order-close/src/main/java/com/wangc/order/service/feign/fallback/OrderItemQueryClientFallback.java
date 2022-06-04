package com.wangc.order.service.feign.fallback;
import com.wangc.fmmall.entity.OrderItem;
import com.wangc.order.service.feign.OrderItemQueryClient;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @author After拂晓
 */


@Component
public class OrderItemQueryClientFallback implements OrderItemQueryClient {

    @Override
    public List<OrderItem> query(String orderId) {
        System.out.println("orderitem-query-----------服务降级");
        return null;
    }
}
