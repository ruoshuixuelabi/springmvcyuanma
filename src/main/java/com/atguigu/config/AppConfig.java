package com.atguigu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;
import com.atguigu.controller.MyFirstInterceptor;

/**
 * Spring MVC只扫描Controller子容器,必须设置useDefaultFilters=false 禁用默认的过滤规则
 * Spring 5之前是继承WebMvcConfigurerAdapter来扩展功能
 * 但是从Spring 5之后只需要实现WebMvcConfigurer接口就可以了，因为Spring 5是基于Java8写的，
 * Java8的接口里面可以写默认方法，因此WebMvcConfigurerAdapter类就被废弃了
 *
 * @author Administrator
 */
@ComponentScan(value = "com.atguigu", includeFilters = {
        @Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
}, useDefaultFilters = false)
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {
    /**
     * 定制视图解析器
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //默认所有的页面都从 /WEB-INF/ xxx .jsp
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    /**
     * 定制静态资源访问
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 定制拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyFirstInterceptor()).addPathPatterns("/**");
    }
}
