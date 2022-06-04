package com.wangc.order.service;
import com.github.wxpay.sdk.WXPay;
import com.rabbitmq.client.Channel;
import com.wangc.fmmall.entity.Orders;
import com.wangc.order.config.MyPayConfig;
import com.wangc.order.feign.OrderCloseClient;
import com.wangc.order.feign.OrderQueryByIdClient;
import com.wangc.order.feign.OrderStatusUpdateClient;
import com.wangc.order.feign.OrderTimeoutQueryClient;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/**
 * @author After拂晓
 */

@Service
@RabbitListener(queues = "q2")
public class ReveiveMsgFromMQService {

    @Resource
    private OrderTimeoutQueryClient orderTimeoutQueryClient;

    private WXPay wxPay = new WXPay(new MyPayConfig());
    @Resource
    private OrderStatusUpdateClient orderStatusUpdateClient;
    @Resource
    private OrderCloseClient orderCloseClient;

    @Resource
    private OrderQueryByIdClient orderQueryByIdClient;

    @RabbitHandler
    public void checkAndCancleOrder(String orderId, Channel channel, Message message) throws IOException {
        try {
            //1.根据订单编号查询当前订单信息
            Orders order = orderQueryByIdClient.query(orderId);
            if( order != null && "1".equals( order.getStatus() )){
                HashMap<String, String> params = new HashMap<>();
                params.put("out_trade_no", order.getOrderId());
                Map<String, String> resp = wxPay.orderQuery(params);
                if("SUCCESS".equalsIgnoreCase(resp.get("trade_state"))){
                    //2.1 如果订单已经支付，则修改订单状态为"代发货/已支付"  status = 2
                    Orders updateOrder = new Orders();
                    updateOrder.setOrderId(order.getOrderId());
                    updateOrder.setStatus("2");
                    //调用 order-status-update 服务，修改订单状态为2
                    int j = orderStatusUpdateClient.update(updateOrder);
                }else if("NOTPAY".equalsIgnoreCase(resp.get("trade_state"))){
                    //2.2 如果确实未支付 则取消订单：
                    //  a.向微信支付平台发送请求，关闭当前订单的支付链接
                    Map<String, String> map = wxPay.closeOrder(params);
                    // b.关闭订单
                    int k = orderCloseClient.close(order.getOrderId(),1);
                }
            }
            channel.basicAck( message.getMessageProperties().getDeliveryTag(),false);
        } catch (Exception e) {
            e.printStackTrace();
            channel.basicNack( message.getMessageProperties().getDeliveryTag(),false,true);
        }
    }
}
