package com.shop.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class GiTable  implements Serializable {
    private Integer goodsId;

    private Integer goodsInfoId;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsInfoId() {
        return goodsInfoId;
    }

    public void setGoodsInfoId(Integer goodsInfoId) {
        this.goodsInfoId = goodsInfoId;
    }
}