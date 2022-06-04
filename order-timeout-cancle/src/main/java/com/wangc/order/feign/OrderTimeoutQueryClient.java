package com.wangc.order.feign;
import com.wangc.fmmall.entity.Orders;
import com.wangc.order.feign.fallback.OrderTimeoutQueryClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
/**
 * @author After拂晓
 */

@FeignClient(value = "order-timeout-query",fallback = OrderTimeoutQueryClientFallback.class)
public interface OrderTimeoutQueryClient {

    @GetMapping("/order/query/timeout")
    List<Orders> query();
}
