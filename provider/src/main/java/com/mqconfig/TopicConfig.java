package com.mqconfig;

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

    private static final String FIRST = "topic.first";

    private static final String EXCHANGE = "topicExchange";

    @Bean
    public org.springframework.amqp.core.Queue firstQueue() {
        return new Queue(FIRST);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(EXCHANGE);
    }

    //绑定topic.first队列到routingKey为topic.first，只有topic.first的routingKey消息才发送到此队列
    @Bean
    public Binding bindingExchange(){
        return BindingBuilder.bind(firstQueue()).to(topicExchange()).with(FIRST);
    }
}