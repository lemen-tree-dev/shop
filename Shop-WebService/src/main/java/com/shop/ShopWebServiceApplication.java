package com.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author HeXiaoH
 * @date 2019/11/13 10:31
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class ShopWebServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopWebServiceApplication.class);
    }
}