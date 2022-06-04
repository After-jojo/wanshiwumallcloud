package com.wangc.order.service;

import com.wangc.fmmall.entity.Orders;
import com.wangc.fmmall.entity.ShoppingCartVO;
import com.wangc.order.dao.OrderAddMapper;
import com.wangc.order.service.feign.StockQueryClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author After拂晓
 */
@Service
public class OrderAddService {
    @Resource
    private StockQueryClient stockQueryClient;
    @Resource
    private OrderAddMapper orderAddMapper;
    public List<ShoppingCartVO> saveOrder(Orders order, String cids){
        //校验库存
        //调用stock-query
        List<ShoppingCartVO> list = stockQueryClient.query(cids);
        if (list == null || list.size() == 0){
            return null;
        }
        // 校验库存
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for(ShoppingCartVO vo : list){
            if(Integer.parseInt(vo.getCartNum()) > vo.getSkuStock()){
                flag = false;
                break;
            }
            sb.append(vo.getProductName());
            sb.append(',');
        }
        if (!flag){
            return null;
        }
        order.setUntitled(sb.toString());
        order.setCreateTime(new Date());
        order.setStatus("1");
//        String orderId = UUID.randomUUID().toString().replace("-", " ");
//        order.setOrderId(orderId);
        int insert = orderAddMapper.insert(order);
        if (insert > 0) {
            return list;
        }
        return null;
    }
}
