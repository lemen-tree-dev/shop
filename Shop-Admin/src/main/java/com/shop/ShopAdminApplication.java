package com.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @Author: 孙树豪
 * @Description:
 * @Date: Create in 14:35 2019/11/9
 */
@SpringBootApplication
@EnableDiscoveryClient//表明该工程注册到ureka注册中心
@EnableFeignClients//使用feign网关
@EnableCircuitBreaker//开启熔断机制
@EnableRedisHttpSession
public class ShopAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopAdminApplication.class,args);
    }
}
