package com.shop.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class MenuFoot  implements Serializable {

    private Integer menuFootId;

    private String menuFootName;

    private String menuFootPic;

    private String menuTopName;

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

    public String getMenuTopName() {
        return menuTopName;
    }

    public void setMenuTopName(String menuTopName) {
        this.menuTopName = menuTopName == null ? null : menuTopName.trim();
    }

    public String getMenuFootPic() {
        return menuFootPic;
    }

    public void setMenuFootPic(String menuFootPic) {
        this.menuFootPic = menuFootPic;
    }
}