package com.shop.shiro;

import com.shop.dao.AdminMapper;
import com.shop.domain.Admin;
import com.shop.domain.AdminPermission;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: 孙树豪
 * @Description:
 * @Date: Create in 16:21 2019/11/9
 */
public class AdminRealm extends AuthorizingRealm {
    @Resource
    private AdminMapper adminMapper;
    /**权限*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Subject subject = SecurityUtils.getSubject();//获取主体对象
        String  adminname =(String ) subject.getPrincipal();//获取用户身份信息
        List<AdminPermission> permissions = adminMapper.queryPermissionsByLoginName(adminname);//根据用户名获取用户的权限信息
//       权限去重
        Collection<String > perms = new HashSet<>();
        for (AdminPermission perm: permissions ) {
            perms.add(perm.getPermissionName());
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(perms);//授权
        return simpleAuthorizationInfo;
    }

    /**登陆*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //得到用户输入的userTelephone
        String adminName = (String) token.getPrincipal();
        Admin admin = adminMapper.selectByName(adminName);
        if (admin!=null) {
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo
                    (adminName,admin.getAdminPassword(), ByteSource.Util.bytes(adminName),getName());
            return simpleAuthenticationInfo;

        }
        return null;
    }
}
