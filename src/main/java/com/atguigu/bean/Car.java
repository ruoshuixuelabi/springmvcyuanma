package com.atguigu.bean;

import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Component
public class Car {
    public Car() {
        System.out.println("car constructor...");
    }

    /**
     * 自定义一个初始化方法
     */
    public void init() {
        System.out.println("car ... init...");
    }

    /**
     * 自定义一个销毁方法
     */
    public void detory() {
        System.out.println("car ... detory...");
    }
}