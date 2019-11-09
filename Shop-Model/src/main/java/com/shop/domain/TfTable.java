package com.shop.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class TfTable  implements Serializable {
    private Integer menuTopId;

    private Integer menuFootId;

    public Integer getMenuTopId() {
        return menuTopId;
    }

    public void setMenuTopId(Integer menuTopId) {
        this.menuTopId = menuTopId;
    }

    public Integer getMenuFootId() {
        return menuFootId;
    }

    public void setMenuFootId(Integer menuFootId) {
        this.menuFootId = menuFootId;
    }
}