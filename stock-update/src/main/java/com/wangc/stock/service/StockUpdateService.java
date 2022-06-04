package com.wangc.stock.service;

import com.wangc.fmmall.entity.ProductSku;
import com.wangc.stock.dao.StockUpdateMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author After拂晓
 */
@Service
public class StockUpdateService {
    @Resource
    private StockUpdateMapper stockUpdateMapper;
    public int update(List<ProductSku> skus){
        int res = 1;
        for (ProductSku sku: skus) {
            int i = stockUpdateMapper.updateByPrimaryKeySelective(sku);
            res *= i;
        }
        return res;
    }
}
