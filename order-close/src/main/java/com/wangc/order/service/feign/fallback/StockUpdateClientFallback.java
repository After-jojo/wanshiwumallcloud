package com.wangc.order.service.feign.fallback;
import com.wangc.fmmall.entity.ProductSku;
import com.wangc.order.service.feign.StockUpdateClient;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @author After拂晓
 */


@Component
public class StockUpdateClientFallback implements StockUpdateClient {

    @Override
    public int update(List<ProductSku> skus) {
        System.out.println("stock-update ~~~~~ 服务降级");
        return 0;
    }
}
