package com.atguigu.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

/**
 * 自己定义过滤规则,必须实现TypeFilter接口
 *
 * @author Administrator
 */
public class MyTypeFilter implements TypeFilter {
    /**
     * metadataReader:读取到的当前正在扫描的类的信息
     * metadataReaderFactory:可以获取到其他任何类信息的
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) {
        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描的类的类信息,比如它的类型是什么,实现了什么接口等
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类资源(比如类的路径)
        Resource resource = metadataReader.getResource();
        //获取到当前类的类名
        String className = classMetadata.getClassName();
        //打印一下当前类的类名
        System.out.println("--->" + className);
        return className.contains("er");
    }
}