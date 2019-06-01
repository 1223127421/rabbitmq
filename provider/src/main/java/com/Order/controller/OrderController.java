package com.Order.controller;

import com.Order.entity.Order;
import com.enums.MqParamEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: wangzhuyi
 * @Date: 2019/4/26 13:57
 * @Version 1.0
 * @Describe
 */
@Api(value = "订单controller", tags = "订单controller")
@RestController
@RequestMapping("")
public class OrderController {

//    @Autowired
//    private MqParamUtil mqParamUtil;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @ApiOperation(value = "发送消息", notes = "发送消息")
    @GetMapping("/send")
    public String sendFirst() {
        Order order = new Order();

        String msg = "生产者发送消息:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date());
        //交换机exchange，队列queue，消息
        rabbitTemplate.convertAndSend(MqParamEnum.ORDER.getExchange(), MqParamEnum.ORDER.getQueue(), msg);
        return msg;
    }

}
