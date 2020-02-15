package com.atguigu.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Dog implements ApplicationContextAware {
    // @Autowired
    @SuppressWarnings("unused")
    private ApplicationContext applicationContext;

    public Dog() {
        System.out.println("dog constructor...");
    }

    /**
     * 对象创建并赋值之后调用,其实就是构造器执行之后调用
     * Post可以理解为什么什么之后
     */
    @PostConstruct
    public void init() {
        System.out.println("Dog....@PostConstruct...");
    }

    /**
     * 容器移除对象之前调用这个方法
     * 相当于一个删除前的通知
     */
    @PreDestroy
    public void detory() {
        System.out.println("Dog....@PreDestroy...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
