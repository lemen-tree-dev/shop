package com.shop.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
public class Goods  implements Serializable {
    private Integer goodsId;

    private String goodsName;

    private BigDecimal goodsPrice;

    private String goodsPic;

    private String goodsDescr;

    private Long goodsDiscount;

    private Integer goodsStock;

    private Integer goodsCount;

    private Integer menuFootId;

    private String menuFootName;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsPic() {
        return goodsPic;
    }

    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic == null ? null : goodsPic.trim();
    }

    public String getGoodsDescr() {
        return goodsDescr;
    }

    public void setGoodsDescr(String goodsDescr) {
        this.goodsDescr = goodsDescr == null ? null : goodsDescr.trim();
    }

    public Long getGoodsDiscount() {
        return goodsDiscount;
    }

    public void setGoodsDiscount(Long goodsDiscount) {
        this.goodsDiscount = goodsDiscount;
    }

    public Integer getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(Integer goodsStock) {
        this.goodsStock = goodsStock;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }
}