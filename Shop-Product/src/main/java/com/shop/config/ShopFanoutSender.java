package com.shop.config;

import com.shop.domain.Pictrue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author HeXiaoH
 * @date 2019/11/14 18:43
 */
@Component
public class ShopFanoutSender {
    /**
     * spring自动创建
     */
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Pictrue pictrue){
        rabbitTemplate.convertAndSend("Shop.Fanout.Exchange","",pictrue);
    }
}
