package com.wangc.stock.service.impl;

import com.wangc.fmmall.entity.ShoppingCartVO;
import com.wangc.stock.dao.ShopCartMapper;
import com.wangc.stock.service.StockQueryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author After拂晓
 */
@Service
public class StockQueryServiceImpl implements StockQueryService {
    @Resource
    private ShopCartMapper shopCartMapper;
    @Override
    public List<ShoppingCartVO> selectShopCartByCids(String cids) {
        String[] split = cids.split(",");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        return shopCartMapper.selectShopCartByCids(list);
    }
}
