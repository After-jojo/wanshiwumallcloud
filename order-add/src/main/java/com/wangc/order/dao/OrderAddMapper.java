package com.wangc.order.dao;

import com.wangc.fmmall.entity.Orders;
import com.wangc.fmmall.entity.ProductSku;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author After拂晓
 */
public interface OrderAddMapper extends Mapper<Orders>, MySqlMapper<Orders> {
}
