package com.wangc.stock.controller;

import com.wangc.fmmall.entity.ProductSku;
import com.wangc.stock.service.StockUpdateService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author After拂晓
 */
@RestController
public class StockUpdateController {
    @Resource
    private StockUpdateService stockUpdateService;
    @PutMapping("/stock/update")
    public int update(@RequestBody List<ProductSku> skus){
        return stockUpdateService.update(skus);
    }
}
