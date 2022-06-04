package com.wangc.stock.dao;

import com.wangc.fmmall.entity.ProductSku;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author After拂晓
 */
public interface StockUpdateMapper extends Mapper<ProductSku>, MySqlMapper<ProductSku> {
}
