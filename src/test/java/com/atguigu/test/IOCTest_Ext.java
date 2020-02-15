package com.atguigu.test;

import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.ext.atguigu.ExtConfig;

public class IOCTest_Ext {
    @SuppressWarnings("serial")
    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);
        // 我们自己也可以发布时间发布事件
        applicationContext.publishEvent(new ApplicationEvent(new String("我发布的时间")) {
        });
        applicationContext.close();
    }
}