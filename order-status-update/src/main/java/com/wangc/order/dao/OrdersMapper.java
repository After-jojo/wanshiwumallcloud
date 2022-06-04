package com.wangc.order.dao;

import com.wangc.fmmall.entity.Orders;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author After拂晓
 */
public interface OrdersMapper extends Mapper<Orders>, MySqlMapper<Orders> {
}
