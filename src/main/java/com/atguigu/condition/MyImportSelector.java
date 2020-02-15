package com.atguigu.condition;

import java.util.Set;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义逻辑返回需要导入的组件
 * @author Administrator
 */
public class MyImportSelector implements ImportSelector {
    /**
     * 返回值就是到导入到容器中的组件全类名
     * AnnotationMetadata importingClassMetadata:当前标注@Import注解的类的所有注解信息
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //importingClassMetadata的方法可以返回很多东西
        Set<String> annotationTypes = importingClassMetadata.getAnnotationTypes();
        annotationTypes.forEach((x) -> {
            System.out.println("注解信息:" + x);
        });
        //方法不要返回null值,自然了可以返回一个空数组,返回null会出现空指针异常,因为框架内部会调用返回数组的长度方法
        return new String[]{"com.atguigu.bean.Blue", "com.atguigu.bean.Yellow"};
    }
}
