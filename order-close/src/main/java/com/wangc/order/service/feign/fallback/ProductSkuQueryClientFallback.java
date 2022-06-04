package com.wangc.order.service.feign.fallback;
import com.wangc.fmmall.entity.ProductSku;
import com.wangc.order.service.feign.ProductSkuQueryClient;
import org.springframework.stereotype.Component;
/**
 * @author After拂晓
 */


@Component
public class ProductSkuQueryClientFallback implements ProductSkuQueryClient {

    @Override
    public ProductSku query(String skuId) {
        System.out.println("product-sku-query-----------服务降级");
        return null;
    }
}
