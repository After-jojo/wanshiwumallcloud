package com.wangc.api.service;

import com.wangc.api.service.feign.OrderAddClient;
import com.wangc.api.service.feign.OrderitemAddClient;
import com.wangc.api.service.feign.ShopcartDelClient;
import com.wangc.api.service.feign.StockUpdateClient;
import com.wangc.fmmall.entity.Orders;
import com.wangc.fmmall.entity.ProductSku;
import com.wangc.fmmall.entity.ShoppingCartVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author After拂晓
 */
@Service
public class OrderSubmitService {
    @Resource
    private OrderAddClient orderAddClient;
    @Resource
    private OrderitemAddClient orderitemAddClient;
    @Resource
    private StockUpdateClient stockUpdateClient;
    @Resource
    private ShopcartDelClient shopcartDelClient;
    public Map<String, String> addOrder(String cids, Orders order){
        Map<String, String> map = null;
        //1.保存订单（校验库存）  order-add
        //生成订单编号
        String orderId = UUID.randomUUID().toString().replace("-","");
        order.setOrderId(orderId);
        List<ShoppingCartVO> carts = orderAddClient.saveOrder(order, cids);

        if(carts != null){
            //2.保存订单快照   orderitem-add
            int i = orderitemAddClient.addOrderItem(carts, orderId);

            if(i > 0 ){
                //3.修改库存  stock-update
                // 将购物车中的商品 及要修改的库存 封装到 ProductSku中
                List<ProductSku> skus = new ArrayList<>();
                for (ShoppingCartVO sc : carts) {
                    String skuId = sc.getSkuId();
                    int newStock = sc.getSkuStock() - Integer.parseInt(sc.getCartNum());

                    ProductSku productSku = new ProductSku();
                    productSku.setSkuId(skuId);
                    productSku.setStock(newStock);
                    skus.add(productSku);
                }
                //调用服务
                int j = stockUpdateClient.update(skus);

                //4.删除购物车  shopcart-del
                if(j > 0){
                    int k = shopcartDelClient.delete(cids);
                    if (k > 0 ){
                        map = new HashMap<>();
                        map.put("orderId", orderId);
                        String str = "";
                        for (int index = 0; index < carts.size(); index++) {
                            str += carts.get(index).getSkuName();
                            str = index==carts.size()-1?str:str+",";
                        }
                        map.put("productNames", str);
                    }
                }
            }
        }
        return map;
    }
}
