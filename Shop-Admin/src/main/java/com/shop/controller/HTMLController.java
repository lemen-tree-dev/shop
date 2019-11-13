package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 孙树豪
 * @Description:
 * @Date: Create in 11:27 2019/11/12
 */
@Controller
public class HTMLController {
    @RequestMapping("/adminlogin")
    public String adminlogin(){
        return "adminlogin";
    }
    @RequestMapping("admingoods")
    public String admingoods(){
        return "admingoods";
    }
    @RequestMapping("main")
    public String main(){
        return "main";
    }
    @RequestMapping("admininfo")
    @ResponseBody
    public String adminInfo(){
        return "这他妈的是管理员页面";
    }
}
