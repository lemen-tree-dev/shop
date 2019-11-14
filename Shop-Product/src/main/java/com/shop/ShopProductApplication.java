package com.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Company: 小米科技
 * @author： 小宝
 * @date： 2019/11/9 14:56
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class ShopProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopProductApplication.class,args);
    }
}
