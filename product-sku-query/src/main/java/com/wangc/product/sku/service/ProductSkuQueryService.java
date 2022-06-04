package com.wangc.product.sku.service;

import com.wangc.fmmall.entity.ProductSku;
import com.wangc.product.sku.dao.ProductSkuMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author After拂晓
 */
@Service
public class ProductSkuQueryService {
    @Resource
    private ProductSkuMapper productSkuMapper;

    public ProductSku queryProductSku(String skuId) {
        return productSkuMapper.selectByPrimaryKey(skuId);
    }
}
