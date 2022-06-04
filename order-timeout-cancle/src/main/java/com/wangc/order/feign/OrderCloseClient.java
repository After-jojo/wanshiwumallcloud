package com.wangc.order.feign;
import com.wangc.order.feign.fallback.OrderCloseClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * @author After拂晓
 */

@FeignClient(value = "order-close",fallback = OrderCloseClientFallback.class)
public interface OrderCloseClient {

    @GetMapping("/order/close")
    int close(@RequestParam("orderId") String orderId,
                     @RequestParam("closeType") int closeType);
}
