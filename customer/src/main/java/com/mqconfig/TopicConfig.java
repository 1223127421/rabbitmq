package com.mqconfig;

import com.enums.MqParamEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: wangzhuyi
 * @Date: 2019/4/26 14:04
 * @Version 1.0
 * @Describe
 */
@Configuration
public class TopicConfig {

    @Bean
    Queue getQueue1() {
        return new Queue(MqParamEnum.ORDER.getQueue());
    }

    @Bean
    TopicExchange getTopicExchange1() {
        return new TopicExchange(MqParamEnum.ORDER.getExchange());
    }


    //绑定队列getQueue1到交换机getTopicExchange1，并使用匹配规则匹配队列
    //匹配规则可以是.# ,.*
    @Bean
    Binding bind1() {
//        return BindingBuilder.bind(getQueue1()).to(getTopicExchange1()).with(".#");
        return BindingBuilder.bind(getQueue1()).to(getTopicExchange1()).with(MqParamEnum.ORDER.getQueue());
    }
}
