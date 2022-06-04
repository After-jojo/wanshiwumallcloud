package com.wangc.order.feign.fallback;

/**
 * @author After拂晓
 */
import com.wangc.order.feign.OrderCloseClient;
import org.springframework.stereotype.Component;

@Component
public class OrderCloseClientFallback implements OrderCloseClient {
    @Override
    public int close(String orderId, int closeType) {
        System.out.println("order-close ~~~~~~~~~~ 服务降级");
        return 0;
    }
}
