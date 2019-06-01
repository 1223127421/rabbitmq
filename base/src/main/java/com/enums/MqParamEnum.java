package com.enums;

/**
 * @Author: wangzhuyi
 * @Date: 2019/5/20 22:24
 * @Version 1.0
 * @Describe
 */
public enum MqParamEnum {

    ORDER("exchange.order", "queue.order"),
    MQ_PARAM2("exchange.name2", "queue.name2");

    private String exchange;
    private String queue;

    MqParamEnum(String exchange, String queue) {
        this.exchange = exchange;
        this.queue = queue;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }
}
