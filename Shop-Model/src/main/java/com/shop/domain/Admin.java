package com.shop.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Admin implements Serializable {
    private Integer adminId;

    private String adminName;

    private String adminPassword;

    private Date adminCreatetime;
}