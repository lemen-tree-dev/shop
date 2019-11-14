package com.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author HeXiaoH
 * @date 2019/11/9 11:11
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableRedisHttpSession
public class ShopUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopUserApplication.class);
    }
}
