package com;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * @Author: wangzhuyi
 * @Date: 2019/4/26 14:49
 * @Version 1.0
 * @Describe 消费者消息监听类
 */
@Component
public class DirectAckReceiver implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            byte[] body = message.getBody();
            System.out.println("消费者消息监听类收到消息  : " + new String(body));
            //成功确认
            channel.basicAck(deliveryTag, true);
//			channel.basicReject(deliveryTag, true);//为true会重新放回队列
        } catch (Exception e) {
            //拒绝确认
            channel.basicReject(deliveryTag, false);
            e.printStackTrace();
        }
    }
}
