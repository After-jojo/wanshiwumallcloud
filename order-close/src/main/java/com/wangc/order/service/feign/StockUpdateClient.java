package com.wangc.order.service.feign;
import com.wangc.fmmall.entity.ProductSku;
import com.wangc.order.service.feign.fallback.StockUpdateClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
/**
 * @author After拂晓
 */


@FeignClient(value = "stock-update",fallback = StockUpdateClientFallback.class)
public interface StockUpdateClient {

    @PutMapping("/stock/update")
    int update(List<ProductSku> skus);

}
