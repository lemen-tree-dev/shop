package com.shop.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class UudTable implements Serializable {
    private Integer userId;

    private Integer userDeliveryId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserDeliveryId() {
        return userDeliveryId;
    }

    public void setUserDeliveryId(Integer userDeliveryId) {
        this.userDeliveryId = userDeliveryId;
    }
}