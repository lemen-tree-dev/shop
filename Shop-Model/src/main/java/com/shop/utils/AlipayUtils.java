package com.shop.utils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.shop.config.AlipayConfig;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Author
 * @Date 2019/10/9
 * @Time 19:49
 */
@Component
public class AlipayUtils {
    public String trade_no;
    public String pay(int limits,String pname) throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl,AlipayConfig.app_id,AlipayConfig.merchant_private_key,"json","utf-8",AlipayConfig.alipay_public_key,"RSA2");
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
        trade_no=tradeno();
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\""+trade_no+"\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":"+limits+"," +
                "    \"subject\":\""+pname+"\"," +
                "    \"body\":\""+pname+"\"," +
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\"2088511833207846\"" +
                "    }"+
                "  }");
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        String form="";

        form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单        System.out.println(response.getBody());
        return form;
    }

    private   String tradeno() {
        StringBuffer stringBuffer=new StringBuffer();
        Random random=new Random();
        for(int i=0;i<16;i++){
            int s=random.nextInt(9);
            stringBuffer.append(s);
        }
        return stringBuffer.toString();
    }
}