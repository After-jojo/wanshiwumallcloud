package com.wangc.stock.service;

import com.wangc.fmmall.entity.ShoppingCartVO;

import java.util.List;

/**
 * @author After拂晓
 */
public interface StockQueryService {
    List<ShoppingCartVO> selectShopCartByCids(String cids);
}
