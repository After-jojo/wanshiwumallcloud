package com.wangc.stock.dao;

import com.wangc.fmmall.entity.ShoppingCart;
import com.wangc.fmmall.entity.ShoppingCartVO;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * @author After拂晓
 */
public interface ShopCartMapper extends Mapper<ShoppingCart>, MySqlMapper<ShoppingCart> {
    List<ShoppingCartVO> selectShopCartByCids(List<Integer> cids);
}
