package com.wangc.api.service.feign;

/**
 * @author After拂晓
 */
import com.wangc.api.service.feign.fallback.StockUpdateClientFallback;
import com.wangc.fmmall.entity.ProductSku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "stock-update",fallback = StockUpdateClientFallback.class)
public interface StockUpdateClient {

    @PutMapping("/stock/update")
    int update(List<ProductSku> skus);

}

