package com.wangc.api.service.feign.fallback;

/**
 * @author After拂晓
 */
import com.wangc.api.service.feign.StockUpdateClient;
import com.wangc.fmmall.entity.ProductSku;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StockUpdateClientFallback implements StockUpdateClient {
    @Override
    public int update(List<ProductSku> skus) {
//        System.out.println("stock-update ------ 服务降级");
        return 0;
    }
}

