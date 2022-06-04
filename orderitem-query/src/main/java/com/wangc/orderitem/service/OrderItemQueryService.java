package com.wangc.orderitem.service;

import com.wangc.fmmall.entity.OrderItem;
import com.wangc.orderitem.dao.OrderItemMapper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author After拂晓
 */
@Service
public class OrderItemQueryService {
    @Resource
    private OrderItemMapper orderItemMapper;

    public List<OrderItem> queryOrderItem(String orderId) {
        Example example1 = new Example(OrderItem.class);
        Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andEqualTo("orderId", orderId);
        List<OrderItem> orderItems = orderItemMapper.selectByExample(example1);
        return orderItems;
    }
}
