package com.shop.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Pictrue  implements Serializable {
    private Integer pictrueId;

    private String pictrueInfo;

    private String pictrueUrl;

    public Integer getPictrueId() {
        return pictrueId;
    }

    public void setPictrueId(Integer pictrueId) {
        this.pictrueId = pictrueId;
    }

    public String getPictrueInfo() {
        return pictrueInfo;
    }

    public void setPictrueInfo(String pictrueInfo) {
        this.pictrueInfo = pictrueInfo == null ? null : pictrueInfo.trim();
    }

    public String getPictrueUrl() {
        return pictrueUrl;
    }

    public void setPictrueUrl(String pictrueUrl) {
        this.pictrueUrl = pictrueUrl == null ? null : pictrueUrl.trim();
    }
}