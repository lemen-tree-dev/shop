package com.shop.config;

import com.shop.dao.PictrueMapper;
import com.shop.domain.Pictrue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author HeXiaoH
 * @date 2019/11/14 18:31
 */
@Component
public class ShopFanoutReceiverA {
    @Resource
    private PictrueMapper pictrueMapper;
    /**
     * 修改数据库
     * @param pictrue
     */
    @RabbitListener(queues = "Shop.Queue.A")
    public void process(Pictrue pictrue){
        int update = pictrueMapper.update(pictrue);
    }
}
