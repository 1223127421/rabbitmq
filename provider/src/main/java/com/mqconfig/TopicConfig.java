package com.mqconfig;

import com.enums.MqEnum;
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

    //绑定topic.first队列到routingKey为topic.first，只有topic.first的routingKey消息才发送到此队列
    @Bean
    public Binding bindingExchangeBase(){
        Queue queue=new Queue(MqEnum.PROVIDER1.getQueue());
        TopicExchange topicExchange=new TopicExchange(MqEnum.PROVIDER1.getExchange());
        return BindingBuilder.bind(queue).to(topicExchange).with(MqEnum.PROVIDER1.getQueue());
    }
}
