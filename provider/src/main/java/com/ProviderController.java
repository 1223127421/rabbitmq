package com;

import com.enums.MqEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: wangzhuyi
 * @Date: 2019/4/26 13:57
 * @Version 1.0
 * @Describe
 */
@Api(value = "生产者controller", tags = "生产者controller")
@RestController
public class ProviderController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @ApiOperation(value = "发送消息", notes = "发送消息")
    @GetMapping("/send")
    public String sendFirst() {
        String msg = "生产者发送消息:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date());
        //交换机exchange，队列queue，消息
        rabbitTemplate.convertAndSend(MqEnum.PROVIDER1.getExchange(), MqEnum.PROVIDER1.getQueue(), msg);
        return msg;
    }
}
