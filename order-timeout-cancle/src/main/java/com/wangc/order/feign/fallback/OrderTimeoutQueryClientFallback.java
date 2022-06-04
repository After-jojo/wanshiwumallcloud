package com.wangc.order.feign.fallback;
import com.wangc.fmmall.entity.Orders;
import com.wangc.order.feign.OrderTimeoutQueryClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
/**
 * @author After拂晓
 */
@Component
public class OrderTimeoutQueryClientFallback implements OrderTimeoutQueryClient {
    @Override
    public List<Orders> query() {
        System.out.println("order-timeout-query ~~~~~~~~~~ 服务降级");
        return new ArrayList<>();
    }
}
