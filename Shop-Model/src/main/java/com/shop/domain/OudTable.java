package com.shop.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class OudTable  implements Serializable {
    private Integer orderId;

    private Integer userDeliveryId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserDeliveryId() {
        return userDeliveryId;
    }

    public void setUserDeliveryId(Integer userDeliveryId) {
        this.userDeliveryId = userDeliveryId;
    }
}