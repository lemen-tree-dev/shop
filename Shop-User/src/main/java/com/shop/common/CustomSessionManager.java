package com.shop.common;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;


/**
 * @author HeXiaoH
 * @date 2019/10/11 17:52
 */
public class CustomSessionManager extends DefaultWebSessionManager {
    private static final String TOKEN = "token";

    public CustomSessionManager() {
        super();
    }

    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {

        String sessionId = WebUtils.toHttp(request).getHeader(TOKEN);
        if(null != sessionId){
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, "cookie");
            //让shiro去判断sessionId是否过期 是否存在
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, sessionId);
            //标记sessionId是有效的，如果是false则会抛异常
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);

            return sessionId;
        } else {
            return super.getSessionId(request, response);
        }

    }
}
