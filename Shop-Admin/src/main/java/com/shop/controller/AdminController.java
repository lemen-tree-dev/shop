package com.shop.controller;

import com.shop.domain.Admin;
import com.shop.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: 孙树豪
 * @Description:管理员表相关业务接口类
 * @Date: Create in 15:52 2019/11/9
 */
@RestController
@RequestMapping(value = "/admin")
public class AdminController extends BaseController{
    @Autowired
    private AdminService adminService;
    @RequestMapping(value = "/addAdmin",method = RequestMethod.POST)
    public Integer addAdmin(@RequestBody Admin admin){
        return adminService.addAdmin(admin);
    }
    @RequestMapping(value = "/selectByName",method = RequestMethod.POST)
    public Integer selectByName(Admin admin, HttpServletRequest httpServletRequest){
        try {
            Subject subject = SecurityUtils.getSubject();//从安全管理器中获取主体对象
            UsernamePasswordToken token = new UsernamePasswordToken();//构建令牌对象
            token.setUsername(admin.getAdminName());//赋身份信息
            token.setPassword(admin.getAdminPassword().toCharArray());//赋凭证信息
            try {
                subject.login(token);//使用主体的login方法判定用户的权限
            }catch (UnknownAccountException e){
                return 2;
            }catch (IncorrectCredentialsException e){
                return 3;
            }
            if(subject.isAuthenticated()){
                //将用户的信息查询出来并存储到session里
                HttpSession session = httpServletRequest.getSession();
                session.setAttribute(session.getId(),admin);
                return 1;
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return 0;
    }
    @RequiresPermissions(value={"admin"})
    @RequestMapping(value = "/selectAll")
    public List<Admin> selectAll() {
        return adminService.selectAll();
    }
    @RequiresPermissions(value={"admin"})
    @RequestMapping(value = "/test")
    public String test()
    {
        return "测试成功";
    }
    //    用户注销操作
    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();//登出
        return "注销成功";
    }
}
