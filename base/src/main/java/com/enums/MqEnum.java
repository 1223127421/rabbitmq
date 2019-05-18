package com.enums;

/**
 * @Author: wangzhuyi
 * @Date: 2019/5/18 17:21
 * @Version 1.0
 * @Describe
 */
public enum MqEnum {

    PROVIDER1("topicExchange", "topic.first");

    private String exchange;
    private String queue;

    MqEnum(String exchange, String queue) {
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
    }}
