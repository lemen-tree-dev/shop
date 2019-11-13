package com.shop.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class MenuTop  implements Serializable {
    private Integer menuTopId;

    private String menuTopName;

    public Integer getMenuTopId() {
        return menuTopId;
    }

    public void setMenuTopId(Integer menuTopId) {
        this.menuTopId = menuTopId;
    }

    public String getMenuTopName() {
        return menuTopName;
    }

    public void setMenuTopName(String menuTopName) {
        this.menuTopName = menuTopName == null ? null : menuTopName.trim();
    }
}