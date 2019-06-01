package com.Order.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: wangzhuyi
 * @Date: 2019/5/5 15:26
 * @Version 1.0
 * @Describe
 */
@Data
public class Order implements Serializable {

    //订单id
    private String orderId;
    //商品id
    private String productId;
    //下单数量
    private Integer number;

    public Order() {
    }

    public Order(String orderId, String productId, Integer number) {
        this.orderId = orderId;
        this.productId = productId;
        this.number = number;
    }
}
