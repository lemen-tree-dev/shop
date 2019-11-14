package com.shop.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.utils.StringUtils;
import com.shop.dao.UserDao;
import com.shop.domain.User;
import com.shop.service.UserService;
import com.shop.utils.AliyunSmsUtils;
import com.shop.utils.RedisUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author HeXiaoH
 * @date 2019/11/9 14:12
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Autowired
    private RedisUtils redisUtils;
    /**
     * 判断用户是否存在
     * @param user
     * @return
     */
    @Override
    public User findUser(User user) {
        if(!StringUtils.isEmpty(user.getUserName())){
            return userDao.findUserByName(user.getUserName());
        }else if(!StringUtils.isEmpty(user.getUserTelephone())){
            return userDao.findUserByTel(user.getUserTelephone());
        }else if(!StringUtils.isEmpty(user.getUserEmail())){
            return userDao.findUserByEmail(user.getUserEmail());
        }
        return null;
    }

    /**
     * 查看手机号是否被注册
     * @param userTelephone
     * @return
     */
    @Override
    public User findUserByTel(String userTelephone) {
        return userDao.findUserByTel(userTelephone);
    }


    /**
     * 发送验证码
     * @param userTelephone
     * @return
     */
    @Override
    public String sendCode(String userTelephone) {
        User userByTel = userDao.findUserByTel(userTelephone);
        if(userByTel!=null){
            //用户已存在
            return "exist";
        }else {
            try {
                //发送短信验证码
                String code= AliyunSmsUtils.sendCode(userTelephone);
                //将验证码存在redis中，并设置时间
                redisUtils.set(userTelephone,code);
                redisUtils.expire(userTelephone,30*60*1000);
                return "success";
            } catch (ClientException e) {
                e.printStackTrace();
            }
            return "fail";
        }
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public String insertUser(User user) {
        //密码加密
        String upassword = user.getUserPassword();
        //加密算法
        String hashAlgorithName = "MD5";
        //登陆时的密码
        String password = upassword;
        //加密次数
        int hashIterations =1024;
        //使用登录名做为salt
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUserName());
        SimpleHash simpleHash = new SimpleHash(hashAlgorithName, password, credentialsSalt, hashIterations);
        user.setUserPassword(simpleHash.toString());
        user.setUserCreatetime(new Date());

        int i = userDao.insertUser(user);
        if(i==1){
            return "success";
        }else {
            return "fail";
        }
    }

    /**
     * 查询全部
     * @return
     */
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @Override
    public int updateById(User user) {
        //密码加密
        String upassword = user.getUserPassword();
        //加密算法
        String hashAlgorithName = "MD5";
        //登陆时的密码
        String password = upassword;
        //加密次数
        int hashIterations =1024;
        //使用登录名做为salt
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUserName());
        SimpleHash simpleHash = new SimpleHash(hashAlgorithName, password, credentialsSalt, hashIterations);
        user.setUserPassword(simpleHash.toString());

        return userDao.updateById(user);
    }
}
