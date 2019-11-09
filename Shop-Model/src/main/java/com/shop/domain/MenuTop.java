package com.shop.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class MenuTop  implements Serializable {
    private Integer menuTopId;

    private String menuTopName;

    private String menuFootName;

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

    public String getMenuFootName() {
        return menuFootName;
    }

    public void setMenuFootName(String menuFootName) {
        this.menuFootName = menuFootName == null ? null : menuFootName.trim();
    }
}