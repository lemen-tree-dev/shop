package com.shop.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class AdminPermission implements Serializable {
    private Integer permissionId;

    private String permissionName;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }
}