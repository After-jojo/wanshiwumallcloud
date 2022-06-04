package com.wangc.product.sku.controller;
import com.wangc.fmmall.entity.ProductSku;
import com.wangc.product.sku.service.ProductSkuQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author After拂晓
 */
@RestController
public class ProductSkuQueryController {

    @Resource
    private ProductSkuQueryService productSkuQueryService;

    @GetMapping("/product/sku/query")
    public ProductSku query(String skuId){
        return productSkuQueryService.queryProductSku(skuId);
    }


}

