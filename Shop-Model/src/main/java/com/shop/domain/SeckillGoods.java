package com.shop.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class SeckillGoods  implements Serializable {
    private Integer seckillGoodsId;

    private String seckillGoodsName;

    private BigDecimal seckillGoodsPrice;

    private Integer seckillGoodsCount;

    private Date seckillGoodsCreatetime;

    private Date seckillGoodsStarttime;

    private Date seckillGoodsEndtime;

    public Integer getSeckillGoodsId() {
        return seckillGoodsId;
    }

    public void setSeckillGoodsId(Integer seckillGoodsId) {
        this.seckillGoodsId = seckillGoodsId;
    }

    public String getSeckillGoodsName() {
        return seckillGoodsName;
    }

    public void setSeckillGoodsName(String seckillGoodsName) {
        this.seckillGoodsName = seckillGoodsName == null ? null : seckillGoodsName.trim();
    }

    public BigDecimal getSeckillGoodsPrice() {
        return seckillGoodsPrice;
    }

    public void setSeckillGoodsPrice(BigDecimal seckillGoodsPrice) {
        this.seckillGoodsPrice = seckillGoodsPrice;
    }

    public Integer getSeckillGoodsCount() {
        return seckillGoodsCount;
    }

    public void setSeckillGoodsCount(Integer seckillGoodsCount) {
        this.seckillGoodsCount = seckillGoodsCount;
    }

    public Date getSeckillGoodsCreatetime() {
        return seckillGoodsCreatetime;
    }

    public void setSeckillGoodsCreatetime(Date seckillGoodsCreatetime) {
        this.seckillGoodsCreatetime = seckillGoodsCreatetime;
    }

    public Date getSeckillGoodsStarttime() {
        return seckillGoodsStarttime;
    }

    public void setSeckillGoodsStarttime(Date seckillGoodsStarttime) {
        this.seckillGoodsStarttime = seckillGoodsStarttime;
    }

    public Date getSeckillGoodsEndtime() {
        return seckillGoodsEndtime;
    }

    public void setSeckillGoodsEndtime(Date seckillGoodsEndtime) {
        this.seckillGoodsEndtime = seckillGoodsEndtime;
    }
}