package com.shop.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsInfo  implements Serializable {
    private Integer goodsInfoId;

    private String goodsInfoPic1;

    private String goodsInfoPic2;

    private String goodsInfoPic3;

    private String goodsInfoVidio;

    private String goodsInfoDescr;

    public Integer getGoodsInfoId() {
        return goodsInfoId;
    }

    public void setGoodsInfoId(Integer goodsInfoId) {
        this.goodsInfoId = goodsInfoId;
    }

    public String getGoodsInfoPic1() {
        return goodsInfoPic1;
    }

    public void setGoodsInfoPic1(String goodsInfoPic1) {
        this.goodsInfoPic1 = goodsInfoPic1 == null ? null : goodsInfoPic1.trim();
    }

    public String getGoodsInfoPic2() {
        return goodsInfoPic2;
    }

    public void setGoodsInfoPic2(String goodsInfoPic2) {
        this.goodsInfoPic2 = goodsInfoPic2 == null ? null : goodsInfoPic2.trim();
    }

    public String getGoodsInfoPic3() {
        return goodsInfoPic3;
    }

    public void setGoodsInfoPic3(String goodsInfoPic3) {
        this.goodsInfoPic3 = goodsInfoPic3 == null ? null : goodsInfoPic3.trim();
    }

    public String getGoodsInfoVidio() {
        return goodsInfoVidio;
    }

    public void setGoodsInfoVidio(String goodsInfoVidio) {
        this.goodsInfoVidio = goodsInfoVidio == null ? null : goodsInfoVidio.trim();
    }

    public String getGoodsInfoDescr() {
        return goodsInfoDescr;
    }

    public void setGoodsInfoDescr(String goodsInfoDescr) {
        this.goodsInfoDescr = goodsInfoDescr == null ? null : goodsInfoDescr.trim();
    }
}