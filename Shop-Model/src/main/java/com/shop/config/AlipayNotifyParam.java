package com.shop.config;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author 杨小柒丶
 * @Date 2019/10/11
 * @Time 11:38
 */
@Data
public class AlipayNotifyParam implements Serializable {
    /**
     * 商户appid
     */
    private String app_id;
    /**
     * 支付金额
     */
    private Float total_amount;
    /**
     * 原支付请求的商户订单号
     */
    private String out_trade_no;
}
