package com.wangc.order.service.feign;

import com.wangc.fmmall.entity.ShoppingCartVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author After拂晓
 */
@FeignClient("stock-query")
public interface StockQueryClient {
    @GetMapping("/stock/query")
    List<ShoppingCartVO> query(@RequestParam String cids);
}
