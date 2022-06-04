package com.wangc.order.service.feign;

/**
 * @author After拂晓
 */
import com.wangc.fmmall.entity.ProductSku;
import com.wangc.order.service.feign.fallback.ProductSkuQueryClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "product-sku-query",fallback = ProductSkuQueryClientFallback.class)
public interface ProductSkuQueryClient {

    @GetMapping("/product/sku/query")
    ProductSku query(@RequestParam("skuId") String skuId);

}
