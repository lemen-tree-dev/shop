package com.shop.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class OuTable  implements Serializable {
    private Integer orderId;

    private Integer userId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}