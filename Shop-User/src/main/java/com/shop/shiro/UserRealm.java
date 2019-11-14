package com.shop.shiro;

import com.shop.dao.UserDao;
import com.shop.domain.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

/**
 * @author HeXiaoH
 * @date 2019/10/17 19:10
 */
public class UserRealm extends AuthorizingRealm {
    @Resource
    private UserDao userDao;

    /**权限*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**登陆*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //得到用户输入的username
        String username = (String) token.getPrincipal();
        User user = userDao.findUserByName(username);
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(username,user.getUserPassword(),ByteSource.Util.bytes(username),getName());
        return simpleAuthenticationInfo;
    }

}