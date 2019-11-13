package com.shop.utils;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: 孙树豪
 * @Description:MD5加密工具类，加密规则需于shiro安全框架中的加密规则一致
 * @Date: Create in 15:36 2019/11/9
 */
public class MD5Utils {
    @Autowired
    HashedCredentialsMatcher credentialsMatcher;
    /**
     * 对密码按照密码，盐进行加密
     * @param password 密码（明文）
     * @param salt 盐
     * @return
     */
    public static String encryptPassword(String password, String salt) {
        String hashAlgorithName="MD5";
        int hashIterations =1024;//定义加密次数
        ByteSource credentialsSalt = ByteSource.Util.bytes(salt);//使用登录名做为salt
        SimpleHash simpleHash = new SimpleHash(hashAlgorithName,password, credentialsSalt,hashIterations);
        return simpleHash.toString();

    }
}
