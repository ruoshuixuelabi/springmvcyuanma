package com.atguigu.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 创建一个Spring定义的FactoryBean
 * 此处的泛型Color指定我们要创建什么类型的对象
 * @author Administrator
 */
public class ColorFactoryBean implements FactoryBean<Color> {
    /**
     * 该方法返回一个Color对象,这个对象会添加到容器中
     */
    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean...getObject...");
        return new Color();
    }

    /**
     * 该方法决定了返回值的类型
     */
    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * 该方法的返回值决定了创建的Bean是否是单例的
     * true:这个bean是单实例,在容器中保存一份
     * false:多实例,每次获取都会创建一个新的bean
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}