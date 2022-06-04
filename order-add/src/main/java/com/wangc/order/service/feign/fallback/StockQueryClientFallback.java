package com.wangc.order.service.feign.fallback;

import com.wangc.fmmall.entity.ShoppingCartVO;
import com.wangc.order.service.feign.StockQueryClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author After拂晓
 */
@Component
public class StockQueryClientFallback implements StockQueryClient {
    @Override
    public List<ShoppingCartVO> query(String cids) {
        return null;
    }
}
