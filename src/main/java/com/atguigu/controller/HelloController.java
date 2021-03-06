package com.atguigu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.service.HelloService;

/**
 * @author Administrator
 */
@Controller
public class HelloController {

    final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return helloService.sayHello("tomcat..");
    }

    /**
     * /WEB-INF/views/success.jsp
     */
    @RequestMapping("/suc")
    public String success() {
        return "success";
    }
}
