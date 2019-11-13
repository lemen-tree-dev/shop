package com.shop.dao;

import com.shop.domain.Admin;
import com.shop.domain.AdminPermission;
import com.shop.domain.ApTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: 孙树豪
 * @Description:
 * @Date: Create in 14:57 2019/11/9
 */
@Mapper
public interface AdminMapper {
    Integer addAdmin(Admin admin);
    Admin selectByName(String adminName);
    List<AdminPermission> queryPermissionsByLoginName(String adminName);
    List<Admin> selectAll();
}
