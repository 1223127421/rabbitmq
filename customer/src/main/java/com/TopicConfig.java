package com;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Queue firstQueue() {
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

    @Autowired
    private CachingConnectionFactory connectionFactory;
    @Autowired
    private DirectAckReceiver directAckReceiver;//消息接收处理类

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setConcurrentConsumers(1);
        container.setMaxConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); // RabbitMQ默认是自动确认，这里改为手动确认消息

        container.setQueues(firstQueue());
        container.setMessageListener(directAckReceiver);
        return container;

    }
}
