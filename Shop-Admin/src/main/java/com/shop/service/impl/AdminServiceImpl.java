package com.shop.service.impl;

import com.shop.dao.AdminMapper;
import com.shop.domain.Admin;
import com.shop.service.AdminService;
import com.shop.utils.MD5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author: 孙树豪
 * @Description:
 * @Date: Create in 15:11 2019/11/9
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;
    @Override
    public Integer addAdmin(Admin admin) {
        //调用MD5工具类，将用户的密码加密
        String str = MD5Utils.encryptPassword(admin.getAdminPassword(), admin.getAdminName());
        admin.setAdminPassword(str);
        //获取当前时间，设置为创建时间
        admin.setAdminCreatetime(new Date());
        return adminMapper.addAdmin(admin);
    }

    @Override
    public List<Admin> selectAll() {
        return adminMapper.selectAll();
    }
}
