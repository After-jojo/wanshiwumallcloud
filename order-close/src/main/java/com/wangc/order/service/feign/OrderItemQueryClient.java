package com.wangc.order.service.feign;
import com.wangc.fmmall.entity.OrderItem;
import com.wangc.order.service.feign.fallback.OrderItemQueryClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * @author After拂晓
 */
import java.util.List;
@FeignClient(value = "orderitem-query", fallback = OrderItemQueryClientFallback.class)
public interface OrderItemQueryClient {

    @GetMapping("/orderitem/query")
    List<OrderItem> query(@RequestParam("orderId") String orderId);

}
