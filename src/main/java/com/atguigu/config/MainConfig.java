package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import com.atguigu.bean.Person;

/**
 * 配置类就等于以前配置文件
 *
 * @author Administrator
 * @Configuration :告诉Spring这是一个配置类
 * @ComponentScan 是一个重复注解, 在JDK 8里面可以写多个,如果是JDK8以下的版本需要些多个的时候
 * 可以采用 @ComponentScans 注解的方式来实现
 * @ComponentScan value:指定要扫描的包
 * excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除哪些组件
 * includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
 * FilterType.ANNOTATION：按照注解
 * FilterType.ASSIGNABLE_TYPE：按照给定的类型
 * FilterType.ASPECTJ：使用ASPECTJ表达式
 * FilterType.REGEX：使用正则指定
 * FilterType.CUSTOM：使用自定义规则
 */
@Configuration
@ComponentScans(
        value = {
                @ComponentScan(value = "com.atguigu", includeFilters = {
/*						@Filter(type=FilterType.ANNOTATION,classes={Controller.class}),
						@Filter(type=FilterType.ASSIGNABLE_TYPE,classes={BookService.class}),*/
                        @Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
                }, useDefaultFilters = false)
        }
)
public class MainConfig {
    /**
     * 给容器中注册一个Bean;
     * 注册的Bean的类型为方法返回值的类型
	 * id默认是用方法名作为id
     */
    @Bean("person")
    public Person person01() {
        return new Person("lisi", 20);
    }
}