package com.wangc.stock.controller;

import com.wangc.fmmall.entity.ShoppingCartVO;
import com.wangc.stock.service.StockQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author After拂晓
 */
@RestController
public class StockQueryController {
    @Resource
    private StockQueryService stockQueryService;
    @GetMapping("/stock/query")
    public List<ShoppingCartVO> query(String cids){
        return stockQueryService.selectShopCartByCids(cids);
    }
}
