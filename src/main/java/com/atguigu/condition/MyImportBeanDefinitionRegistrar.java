package com.atguigu.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import com.atguigu.bean.RainBow;

/**
 * @author Administrator
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * AnnotationMetadata参数:当前类的注解信息
     * BeanDefinitionRegistry参数:BeanDefinition注册类
     * 把所有需要添加到容器中的bean,调用BeanDefinitionRegistry.registerBeanDefinition方法手工注册进来
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //首先判断IOC容器里面是否有如下的两个Bean
        boolean readDefinition = registry.containsBeanDefinition("com.atguigu.bean.Red");
        boolean blueDefinition2 = registry.containsBeanDefinition("com.atguigu.bean.Blue");
        //如果两个Bean都在容器存在,我们给容易注册一个新的Bean(RainBow)
        if (readDefinition && blueDefinition2) {
            //指定Bean定义信息(Bean的类型,作用域)
            RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            //注册一个Bean并且指定bean名
            registry.registerBeanDefinition("rainBow", beanDefinition);
        }
    }
}
