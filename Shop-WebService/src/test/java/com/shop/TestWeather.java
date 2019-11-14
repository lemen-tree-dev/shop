package com.shop;

import com.shop.domain.Weather;
import com.shop.service.WeatherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author HeXiaoH
 * @date 2019/11/13 10:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestWeather {
    @Resource
    private WeatherService weatherService;
    @Test
    public void test1(){
        Weather weather = weatherService.getWeather("西安");
        System.err.println(weather);
    }
}
