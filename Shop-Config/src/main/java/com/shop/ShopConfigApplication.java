package com.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author HeXiaoH
 * @date 2019/11/9 10:15
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ShopConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopConfigApplication.class);
    }
}
