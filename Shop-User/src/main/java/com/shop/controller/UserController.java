package com.shop.controller;

import com.aliyuncs.utils.StringUtils;
import com.shop.domain.User;
import com.shop.service.UserService;
import com.shop.utils.RedisUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author HeXiaoH
 * @date 2019/11/9 14:03
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 用户登陆
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public String login(User user, HttpServletRequest request){
        String denglu = user.getUserName();
        String userPassword = user.getUserPassword();

        //判断是邮箱还是手机号的正则表达式
        String em = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        String ph = "^1(3|4|5|7|8)\\d{9}$";

        if(denglu.matches(em)){
            //邮箱登陆
            user.setUserName(null);
            user.setUserEmail(denglu);
        }else if(denglu.matches(ph)){
            //手机号登陆
            user.setUserName(null);
            user.setUserTelephone(denglu);
        }else {
            //用户名登陆
            user.setUserName(denglu);
        }

        User userByName = userService.findUser(user);
        System.err.println(user);
        if(userByName==null){
            //用户不存在
            return "0";
        }else {
            //调用shiro安全框架
            Subject subject = SecurityUtils.getSubject();
            //判断验证密码
            UsernamePasswordToken token = new UsernamePasswordToken(userByName.getUserName(),userPassword);
            //判断token
            try {
                subject.login(token);
                //登陆成功
                if(subject.isAuthenticated()){
                    //获取session
                    HttpSession session = request.getSession();
                    System.err.println(session.getId()+"==========================");
                    //将用户信息存在session中,用sessionId为key值
                    session.setAttribute(session.getId(),user);
                    //登陆成功
                    return "success";
                }else {
                    return "fail";
                }
            }catch (Exception e){
                return "fail";
            }
        }
    }

    /**
     * 发送验证码
     * @param utel
     * @param request
     * @return
     */
    @RequestMapping("/sendCode")
    @ResponseBody
    public String sendCode(@RequestParam("utel") String utel,HttpServletRequest request){
        HttpSession session = request.getSession();
        redisUtils.set(session.getId()+"utel",utel);
        System.err.println(session.getId()+"==========================");
        redisUtils.expire(session.getId()+"utel",30*60*1000);
        String message = userService.sendCode(utel);
        return message;
    }

    /**
     * 判断验证码
     * @param code
     * @param request
     * @return
     */
    @RequestMapping("/judgeCode")
    @ResponseBody
    public String judgeCode(@RequestParam("code") String code,HttpServletRequest request){
        if(!StringUtils.isEmpty(code)){
            HttpSession session = request.getSession();
            try {
                String utel = (String)redisUtils.get(session.getId()+"utel");
                String code1 = (String)redisUtils.get(utel);
                System.err.println(session.getId()+"==========================");
                if(code.equals(code1)){
                    //验证成功
                    return "success";
                }else {
                    //验证码错误
                    return "fail";
                }
            }catch (Exception e){
                return "超时";
            }
        }else {
            //不能为空
            return "fail";
        }
    }

    /**
     * 注册用户
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/registered")
    @ResponseBody
    public String registered(@RequestBody User user,HttpServletRequest request){
        try {
            HttpSession session = request.getSession();
            String utel = (String)redisUtils.get(session.getId() + "utel");
            user.setUserTelephone(utel);
            String message = userService.insertUser(user);
            return message;
        }catch (Exception e){
            return "超时";
        }
    }

    /**
     * 得到用户信息
     * @param request
     * @return
     */
    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(session.getId());
        return user;
    }


    /**
     * 用户退出
     * @param request
     * @return
     */
    @RequestMapping("/loginOut")
    @ResponseBody
    public String loginOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        //使session失效
        try {
            session.invalidate();
            return "success";
        }catch (Exception e){
            return "fail";
        }
    }

    /**
     * 查询全部用户
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public List<User> findAll(){
        return userService.findAll();
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @RequestMapping("/findById/{id}")
    @ResponseBody
    public User findById(@PathVariable("id") Integer id){
        if(id==null){
            return null;
        }else {
            return userService.findById(id);
        }
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @RequestMapping("/updateById")
    @ResponseBody
    public String updateById(@RequestBody User user){
        System.err.println(user);
        if(user!=null){
            int i = userService.updateById(user);
            if(i==1){
                return "success";
            }else {
                return "fail";
            }
        }else {
            return "fail";
        }
    }


    @RequestMapping("/userlogin")
    public String userlogin(){
        return "userlogin";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }
}
