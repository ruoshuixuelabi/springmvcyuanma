package com.ext.atguigu;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanFactoryPostProcessor...postProcessBeanFactory...");
        //我们可以拿到有几个Bean定义了,也就是容器里面Bean的个数,仅仅是定义信息,此时Bean还没有创建实例
        int count = beanFactory.getBeanDefinitionCount();
        //可以获取当前所有的Bean的名字
        String[] names = beanFactory.getBeanDefinitionNames();
        System.out.println("MyBeanFactoryPostProcessor当前BeanFactory中有" + count + " 个Bean");
        System.out.println(Arrays.asList(names));
    }
}
