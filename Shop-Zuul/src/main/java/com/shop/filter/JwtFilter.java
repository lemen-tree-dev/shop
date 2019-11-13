package com.shop.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author HeXiaoH
 * @date 2019/10/29 14:17
 */
@Configuration
public class JwtFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);
    @Autowired
    HttpServletRequest httpServletRequest;

    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 返回一个值来指定过滤器的执行顺序，不同过滤器允许返回相同的数字，数字越小顺序越靠前
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 返回一个boolean值来判断该过滤器是否要执行，true：执行，false：不执行
     */

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
        String requestUri = request.getRequestURI();
        if(requestUri.startsWith("/Oxford")){
            return true;
        }
        return false;
    }


//    /**
//     * 过滤器的具体逻辑
//     */
//    @Override
//    public Object run() {
//        RequestContext ctx = RequestContext.getCurrentContext();
//        String sessionId = httpServletRequest.getSession().getId();
//        logger.info("--------------------------------------------------");
//        logger.info("sessionId: " + sessionId);
//        logger.info("--------------------------------------------------");
//        ctx.addZuulRequestHeader("Cloud-Cookie", "SESSION=" + sessionId);
//        ctx.setSendZuulResponse(true);  // 对该请求进行路由
//        ctx.setResponseStatusCode(200); // 返回200正确响应
//        return null;
//    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();
        Cookie[] cookies = request.getCookies();
        Cookie jwtTokenCokie = null;
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equalsIgnoreCase("")){
                    jwtTokenCokie = cookie;
                    break;
                }
            }
        }

        return null;
    }

    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer defaultCookieSerializer = new DefaultCookieSerializer();
        defaultCookieSerializer.setCookieName("oxfordSessionId");
        defaultCookieSerializer.setCookiePath("/Oxford");
        return defaultCookieSerializer;
    }
}
