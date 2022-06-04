package com.wangc.api.controller;

import com.github.wxpay.sdk.WXPay;
import com.wangc.api.config.MyPayConfig;
import com.wangc.api.service.OrderSubmitService;
import com.wangc.api.service.SendMsgToMQService;
import com.wangc.fmmall.entity.Orders;
import com.wangc.fmmall.vo.ResStatus;
import com.wangc.fmmall.vo.ResultVO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author After拂晓
 */
@RestController
@CrossOrigin
public class OrderSubmitController {
    @Resource
    private OrderSubmitService orderSubmitService;
    @Resource
    private SendMsgToMQService sendMsgToMQService;
    @PostMapping("/add")
    public ResultVO add(String cids, @RequestBody Orders order){
        ResultVO resultVO = null;
        try {
            Map<String, String> orderInfo = orderSubmitService.addOrder(cids, order);
            if(null == orderInfo.get("orderId")){
                resultVO = new ResultVO(ResStatus.OK, "提交订单失败！", null);
            }

            // 申请支付连接
            WXPay wxPay = new WXPay(new MyPayConfig());
            //设置当前订单信息
            HashMap<String, String> map = new HashMap<>();
            map.put("body", orderInfo.get("productNames"));
            map.put("out_trade_no", orderInfo.get("orderId"));   //当前⽀付交易交易号
            map.put("fee_type", "CNY");
            map.put("total_fee", order.getActualAmount() * 100 + "");          //⽀付⾦额
            map.put("trade_type", "NATIVE");    //交易类型
//            map.put("notify_url", "/pay/success");    //设置⽀付完成时的回调⽅法接⼝

            map.put("notify_url", "http://wangc.free.idcfengye.com/pay/success");   // 使用ngrok完成内网穿透，让微信支付平台得以访问
            Map<String, String> resp = wxPay.unifiedOrder(map);
            orderInfo.put("payUrl", resp.get("code_url"));
            resultVO = new ResultVO(ResStatus.OK, "提交订单成功！", orderInfo);
            //当订单保存成功之后将订单编号写入到 死信队列 q1(ex6---key1)
            sendMsgToMQService.sendMsg(orderInfo.get("orderId"));
        } catch (SQLException e) {
            resultVO = new ResultVO(ResStatus.NO, "提交订单失败！", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultVO;
    }
}
