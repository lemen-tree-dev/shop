package com.shop.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class MenuFoot  implements Serializable {
    private Integer menuFootId;

    private String menuFootName;

    public Integer getMenuFootId() {
        return menuFootId;
    }

    public void setMenuFootId(Integer menuFootId) {
        this.menuFootId = menuFootId;
    }

    public String getMenuFootName() {
        return menuFootName;
    }

    public void setMenuFootName(String menuFootName) {
        this.menuFootName = menuFootName == null ? null : menuFootName.trim();
    }
}