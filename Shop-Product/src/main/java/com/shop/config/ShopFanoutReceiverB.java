package com.shop.config;

import com.shop.domain.Pictrue;
import com.shop.utils.RedisUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HeXiaoH
 * @date 2019/11/14 18:31
 */
@Component
public class ShopFanoutReceiverB {
    @Autowired
    private RedisUtils redisUtils;
    /**
     * 修改redis
     * @param pictrue
     */
    @RabbitListener(queues = "Shop.Queue.B")
    public void process(Pictrue pictrue){
        redisUtils.hset("picture",pictrue.getPictrueId()+"",pictrue.getPictrueUrl());
    }
}
