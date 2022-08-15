package com.zhy.login.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Zhu HongYi
 * @version 1.0
 * @Date: 2022/08/15/22:13
 */
@Configuration
public class LoginFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("经过权限过滤器");
        String uri=request.getRequestURI();
        if(uri.startsWith("/hello")||uri.startsWith("/logout")){//拦截，需要登录权限
            HttpSession session=request.getSession();
            String user= (String) session.getAttribute("user");
            if(user==null){
                response.setStatus(HttpStatus.UNAUTHORIZED.value());//401
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().write("无权访问");
                return;//无权访问
            }
        }
        filterChain.doFilter(request,response);
    }
}
