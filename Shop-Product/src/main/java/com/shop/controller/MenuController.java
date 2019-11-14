package com.shop.controller;

import com.shop.domain.MenuFoot;
import com.shop.domain.MenuTop;
import com.shop.service.MenuService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Company: 小米科技
 * @author： 小宝
 * @date： 2019/11/11 9:18
 */
@RestController
public class MenuController {


    @Resource
    private MenuService menuService;

    /**
     * 获得一级菜单
     * @return
     */
    @RequestMapping("/getTopMenu")
    public List<MenuTop> getTopMenu(){
        return menuService.selectTopMenu();
    }

    /**
     * 获得二级菜单
     * @param menuTopName
     * @return
     */
    @RequestMapping("/getFootMenu")
    public List<MenuFoot> getFootMenu(@RequestParam("menuTopName")String menuTopName){
        return menuService.selectFootMenu(menuTopName);
    }
}
