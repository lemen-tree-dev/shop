package com.shop.service;

import com.shop.domain.MenuFoot;
import com.shop.domain.MenuTop;

import java.util.List;

/**
 * @Description:
 * @Company: 小米科技
 * @author： 小宝
 * @date： 2019/11/11 9:19
 */
public interface MenuService {

    //一级目录查询(MenuTop 表)
    public List<MenuTop> selectTopMenu();

    //二级目录查询(MenuFoot 表)
    public List<MenuFoot> selectFootMenu(String menuTopName);
}
