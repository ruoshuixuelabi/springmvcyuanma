package com.atguigu.controller;

import java.util.concurrent.Callable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Administrator
 */
public class AsyncController2 {
    @ResponseBody
    @RequestMapping(value = "/callable", produces = "text/plain; charset=UTF-8")
    public Callable<String> callable() {
        System.out.println("Callable处理器主线程进入");
        Callable<String> callable = () -> {
            Thread.sleep(5 * 1000L);
            System.out.println("Callable处理执行中。。。");
            return "久等了";
        };
        System.out.println("Callable处理器主线程退出");
        return callable;
    }
}
