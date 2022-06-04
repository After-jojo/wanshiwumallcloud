package com.wangc.order.service.feign.fallback;
import com.wangc.fmmall.entity.Orders;
import com.wangc.order.service.feign.OrderStatusUpdateClient;
import org.springframework.stereotype.Component;
/**
 * @author After拂晓
 */
@Component
public class OrderStatusUpdateClientFallback implements OrderStatusUpdateClient {

    @Override
    public int update(Orders order) {
        System.out.println("order-status-update ~~~~~ 服务降级");
        return 0;
    }
}