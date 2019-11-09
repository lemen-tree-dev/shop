package com.shop.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class ApTable implements Serializable {
    private Integer adminId;

    private Integer permissionId;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}