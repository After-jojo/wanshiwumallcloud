package com.wangc.api.service.feign;

/**
 * @author After拂晓
 */
import com.wangc.api.service.feign.fallback.OrderAddClientFallback;
import com.wangc.fmmall.entity.Orders;
import com.wangc.fmmall.entity.ShoppingCartVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "order-add",fallback = OrderAddClientFallback.class)
public interface OrderAddClient {

    @PostMapping("/order/save")
    List<ShoppingCartVO> saveOrder(Orders order, @RequestParam("cids") String cids);

}
