package com.shop.controller;

import com.shop.domain.Weather;
import com.shop.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HeXiaoH
 * @date 2019/11/13 10:39
 */
@RestController
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    /**
     * 获取天气
     * @param localcity
     * @return
     */
    @RequestMapping("/getWeather")
    public Weather getWeather(@RequestParam("localcity")String localcity){
        System.err.println(localcity);
        String substring = localcity.substring(0,2);
        System.err.println(substring);
        Weather weather = weatherService.getWeather(substring);
        System.err.println(weather);
        return weather;
    }
}
