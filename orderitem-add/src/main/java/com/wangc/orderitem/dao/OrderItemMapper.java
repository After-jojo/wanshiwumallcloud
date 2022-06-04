package com.wangc.orderitem.dao;

import com.wangc.fmmall.entity.OrderItem;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author After拂晓
 */
public interface OrderItemMapper extends Mapper<OrderItem>, MySqlMapper<OrderItem> {
}
