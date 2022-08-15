package com.zhy.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Zhu HongYi
 * @version 1.0
 * @Date: 2022/08/15/22:06
 */
@Controller
public class LoginController {
    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestParam String name, @RequestParam String password, HttpServletRequest request){
        if("Alice".equals(name)&&"123".equals(password)){
            HttpSession session=request.getSession();
            session.setAttribute("user",name);//登录的第一种方式：在服务器本地session中保存登录状态,默认保持30分钟,过期或关闭服务器会使得会话消失需要重新登录
            return "登录成功";
        }else{
            return "用户名或密码错误，登录失败";//响应正文
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.removeAttribute("user");
        return "/index";//跳转页面
    }
}
