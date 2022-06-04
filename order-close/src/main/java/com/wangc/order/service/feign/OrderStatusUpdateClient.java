package com.wangc.order.service.feign;
import com.wangc.fmmall.entity.Orders;
import com.wangc.order.service.feign.fallback.OrderStatusUpdateClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
/**
 * @author After拂晓
 */

@FeignClient(value = "order-status-update", fallback = OrderStatusUpdateClientFallback.class)
public interface OrderStatusUpdateClient {

    @PutMapping("/order/status/update")
    int update(Orders order);

}
