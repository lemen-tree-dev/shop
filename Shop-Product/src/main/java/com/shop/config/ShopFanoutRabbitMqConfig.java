package com.shop.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author HeXiaoH
 * @date 2019/11/14 18:22
 */
@Configuration
public class ShopFanoutRabbitMqConfig {

    /**
     * 创建队列A
     * @return
     */
    @Bean
    public Queue queueA(){
        return new Queue("Shop.Queue.A");
    }

    /**
     * 创建队列B
     * @return
     */
    @Bean
    public Queue queueB(){
        return new Queue("Shop.Queue.B");
    }

    /**
     * 创建交换机
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("Shop.Fanout.Exchange");
    }

    /**
     * 将消息队列A与交换机绑定
     * @param queueA
     * @param fanoutExchange
     * @return
     */
    @Bean
    public Binding fanoutA(Queue queueA,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueA).to(fanoutExchange);
    }

    /**
     * 将消息队列B与交换机绑定
     * @param queueB
     * @param fanoutExchange
     * @return
     */
    @Bean
    public Binding fanoutB(Queue queueB,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueB).to(fanoutExchange);
    }
}
