package com.shop.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDelivery implements Serializable {
    private Integer userDeliveryId;

    private String userDeliveryName;

    private String userDeliveryTelephone;

    private String userDeliveryAddress;

    public Integer getUserDeliveryId() {
        return userDeliveryId;
    }

    public void setUserDeliveryId(Integer userDeliveryId) {
        this.userDeliveryId = userDeliveryId;
    }

    public String getUserDeliveryName() {
        return userDeliveryName;
    }

    public void setUserDeliveryName(String userDeliveryName) {
        this.userDeliveryName = userDeliveryName == null ? null : userDeliveryName.trim();
    }

    public String getUserDeliveryTelephone() {
        return userDeliveryTelephone;
    }

    public void setUserDeliveryTelephone(String userDeliveryTelephone) {
        this.userDeliveryTelephone = userDeliveryTelephone == null ? null : userDeliveryTelephone.trim();
    }

    public String getUserDeliveryAddress() {
        return userDeliveryAddress;
    }

    public void setUserDeliveryAddress(String userDeliveryAddress) {
        this.userDeliveryAddress = userDeliveryAddress == null ? null : userDeliveryAddress.trim();
    }
}