package com.wangc.order.feign.fallback;

/**
 * @author After拂晓
 */
import com.wangc.fmmall.entity.Orders;
import com.wangc.order.feign.OrderStatusUpdateClient;
import org.springframework.stereotype.Component;

@Component
public class OrderStatusUpdateClientFallback implements OrderStatusUpdateClient {
    @Override
    public int update(Orders order) {
        System.out.println("order-status-update  ~~~~~~  服务降级");
        return 0;
    }
}
