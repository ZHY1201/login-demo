package com.zhy.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Zhu HongYi
 * @version 1.0
 * @Date: 2022/08/15/22:15
 */
@Controller
public class PageController {
    @GetMapping("/")
    public String home(){
        return "index";
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
