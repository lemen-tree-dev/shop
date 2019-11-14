package com.shop.service.impl;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.WeatherWS;
import cn.com.webxml.WeatherWSSoap;
import com.shop.domain.Weather;
import com.shop.service.WeatherService;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * @author HeXiaoH
 * @date 2019/11/13 10:39
 */
@Service
public class WeatherServiceImpl implements WeatherService {
    @Override
    public Weather getWeather(String city) {
//        //从service的name属性获取
//        WeatherWS weatherWS = new WeatherWS();
//        //从portType的name属性获取
//        WeatherWSSoap port = weatherWS.getPort(WeatherWSSoap.class);
//        ArrayOfString weather = port.getWeather(city, "");
//        if("免费用户24小时内访问超过规定数量".equals(weather)){
//            return null;
//        }else {
//            String time=weather.getString().get(1);
//            String wendu=weather.getString().get(5);
//            String date=weather.getString().get(6);
//            String wind =weather.getString().get(7);
//            //封装到Weather对象  返回
//            Weather weather1=new Weather();
//            weather1.setLocalcity(city);
//            weather1.setTime(time);
//            weather1.setWendu(wendu);
//            weather1.setDate(date);
//            weather1.setWind(wind);
//            return weather1;
//        }
//    }
        Weather weather1 = new Weather();
        weather1.setLocalcity(city);
        weather1.setWendu("你发啥到你房里看到了发你看");
        weather1.setDate("的技术开发面对美国，。磨豆腐");
        weather1.setWind("雨");
        return weather1;
    }
}