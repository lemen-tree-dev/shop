package com.shop.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class GfTable implements Serializable {
    private Integer goodsId;

    private Integer menuFootId;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getMenuFootId() {
        return menuFootId;
    }

    public void setMenuFootId(Integer menuFootId) {
        this.menuFootId = menuFootId;
    }
}