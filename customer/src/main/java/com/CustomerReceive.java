package com;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: wangzhuyi
 * @Date: 2019/4/26 14:15
 * @Version 1.0
 * @Describe
 */
@Component
public class CustomerReceive {

    @RabbitHandler
    @RabbitListener(queues = "topic.first")
    public void receive1(String msg){
        System.out.println("消费者接收到的消息："+msg);
    }
}
