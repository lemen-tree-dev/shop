package com.shop.service.impl;

import com.shop.dao.MenuMapper;
import com.shop.domain.MenuFoot;
import com.shop.domain.MenuTop;
import com.shop.service.MenuService;
import com.shop.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private RedisUtils redisUtils;
    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<MenuTop> selectTopMenu() {
        List<MenuTop> list=(List<MenuTop>)redisUtils.get("menutop");
        if(list!=null && list.size()!=0){
            return list;
        }

        //从数据库查询
        List<MenuTop> list1 = menuMapper.selectTopMenu();

        if(list1!=null && list1.size()!=0){
            redisUtils.set("menutop",list1);
        }else {
            //设置空值,防止缓存穿透
            redisUtils.set("menutop","null");
            redisUtils.expire("menutop",60*1000);
        }
        return list1;
    }

    @Override
    public List<MenuFoot> selectFootMenu(String menuTopName) {
        List<MenuFoot> list = (List<MenuFoot>)redisUtils.get("menufoot");
        if(list!=null && list.size()!=0){
            return list;
        }

        List<MenuFoot> list1 = menuMapper.selectFootMenu(menuTopName);
        if(list1!=null && list1.size()!=0){
            redisUtils.set("menufoot",list1);
        }else {
            //设置空值,防止缓存穿透
            redisUtils.set("menufoot","null");
            redisUtils.expire("menufoot",60*1000);
        }
        return list1;
    }
}
