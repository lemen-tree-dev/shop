package com.shop.service.impl;

import com.shop.dao.MenuMapper;
import com.shop.domain.MenuFoot;
import com.shop.domain.MenuTop;
import com.shop.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Company: 小米科技
 * @author： 小宝
 * @date： 2019/11/11 9:21
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<MenuTop> selectTopMenu() {
        return menuMapper.selectTopMenu();
    }

    @Override
    public List<MenuFoot> selectFootMenu(String menuTopName) {
        return menuMapper.selectFootMenu(menuTopName);
    }
}
