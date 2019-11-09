package com.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author HeXiaoH
 * @date 2019/11/9 10:24
 */
@SpringBootApplication
@EnableZuulProxy
public class ShopZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopZuulApplication.class);
    }
}
