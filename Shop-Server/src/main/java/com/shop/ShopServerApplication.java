package com.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author HeXiaoH
 * @date 2019/11/9 10:03
 */
@SpringBootApplication
@EnableEurekaServer
public class ShopServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopServerApplication.class);
    }
}
