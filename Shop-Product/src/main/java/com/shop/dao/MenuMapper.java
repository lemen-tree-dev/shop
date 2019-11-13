package com.shop.dao;

import com.shop.domain.MenuFoot;
import com.shop.domain.MenuTop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description:
 * @Company: 小米科技
 * @author： 小宝
 * @date： 2019/11/9 15:28
 */
@Mapper
public interface MenuMapper {
    //一级目录查询(MenuTop 表)
    public List<MenuTop> selectTopMenu();

    //二级目录查询(MenuFoot 表)
    public List<MenuFoot> selectFootMenu(String menuTopName);

}
