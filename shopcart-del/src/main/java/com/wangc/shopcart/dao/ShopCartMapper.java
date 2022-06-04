package com.wangc.shopcart.dao;

import com.wangc.fmmall.entity.ShoppingCart;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author After拂晓
 */
public interface ShopCartMapper extends Mapper<ShoppingCart>, MySqlMapper<ShoppingCart> {
}
