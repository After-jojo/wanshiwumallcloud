package com.wangc.order.service;

import com.wangc.fmmall.entity.Orders;
import com.wangc.order.dao.OrdersMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author After拂晓
 */
@Service
public class OrderStatusUpdateService {
    @Resource
    private OrdersMapper ordersMapper;

    public int updateStatus(Orders order) {
        int i = ordersMapper.updateByPrimaryKeySelective(order);
        return i;
    }
}
