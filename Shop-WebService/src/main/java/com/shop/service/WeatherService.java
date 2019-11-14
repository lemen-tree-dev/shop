package com.shop.service;

import com.shop.domain.Weather;


/**
 * @author HeXiaoH
 * @date 2019/11/13 10:37
 */

public interface WeatherService {
    /**
     * 获得当前的天气信息
     * @param city
     * @return
     */
    public Weather getWeather(String city);
}
