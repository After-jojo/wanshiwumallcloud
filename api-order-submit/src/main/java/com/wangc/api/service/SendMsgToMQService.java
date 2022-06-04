package com.wangc.api.service;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author After拂晓
 */
@Service
public class SendMsgToMQService {

    @Resource
    private AmqpTemplate amqpTemplate;

    public void sendMsg(String orderId){
        amqpTemplate.convertAndSend("ex6","key1",orderId);
    }

}
