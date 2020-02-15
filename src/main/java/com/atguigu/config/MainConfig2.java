package com.atguigu.config;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import com.atguigu.bean.Color;
import com.atguigu.bean.ColorFactoryBean;
import com.atguigu.bean.Person;
import com.atguigu.bean.Red;
import com.atguigu.condition.LinuxCondition;
import com.atguigu.condition.MyImportBeanDefinitionRegistrar;
import com.atguigu.condition.MyImportSelector;
import com.atguigu.condition.WindowsCondition;
/**
* @author 作者: 马振坤 
* @version 
* @email 524991368@qq.com
* @date 创建时间：2018年3月24日 下午4:58:23
* @desc 类说明:
*  @Conditional 注解可以放在类上面,来对类中组件统一设置,满足当前条件,这个类中配置的所有bean注册才能生效
*  @Import 这个注解可以快速的导入组件,组件的id默认是组件的全类名
 */
@Conditional({WindowsCondition.class})
@Configuration
@Import({Color.class,Red.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {
	//默认是单实例的
	/**
	 * ConfigurableBeanFactory#SCOPE_PROTOTYPE    
	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON  
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST  request
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION	 sesssion
	 * @return
	 * @Scope:调整作用域
	 * prototype:多实例的: IOC容器启动并不会去调用方法创建对象放在容器中。
	 * 					多实例的情况下每次获取的时候才会调用方法创建对象
	 * singleton:单实例的(默认值),单实例的情况下IOC容器启动时就会调用方法创建对象放到IOC容器中。
	 * 					以后每次获取就是直接从容器(map.get())中拿
	 * request:同一次请求创建一个实例
	 * session:同一个session创建一个实例
	 * 懒加载(针对单实例的Bean):
	 * 		刚才我们知道了单实例bean:默认在容器启动的时候创建对象。
	 * 		可能我们需要懒加载:容器启动不创建对象,第一次使用(获取)Bean创建对象,并初始化
	 */
//	@Scope("prototype")
	@Lazy
	@Bean("person")
	public Person person(){
		System.out.println("给容器中添加Person....");
		return new Person("张三", 25);
	}
	/**
	 * @Conditional({Condition}) :按照一定的条件进行判断,满足条件给容器中注册bean
	 * 如果系统是windows,给容器中注册("bill")
	 * 如果是Linux系统,给容器中注册("linux")
	 */
	@Bean("bill")
	public Person person01(){
		return new Person("Bill Gates",62);
	}
	@Conditional(LinuxCondition.class)
	@Bean("linus")
	public Person person02(){
		return new Person("linus", 48);
	}
	/**
	 * 给容器中注册组件的几种方式
	 * 1)、包扫描+组件标注注解(@Controller/@Service/@Repository/@Component),该方式局限于自己写的类
	 * 2)、使用 @Bean 注解导入的第三方包里面的组件
	 * 3)、使用 @Import 注解快速给容器中导入一个组件
	 * 		1)、@Import(要导入到容器中的组件),容器中就会自动注册这个组件,id默认是全类名
	 * 		2)、ImportSelector:返回需要导入的组件的全类名数组
	 * 		3)、ImportBeanDefinitionRegistrar:手动注册bean到容器中
	 * 4)、使用Spring提供的FactoryBean(工厂Bean);
	 * 		1)、默认获取到的是工厂bean调用getObject创建的对象
	 * 		2)、要获取工厂Bean本身,我们需要给id前面加一个&,例如&colorFactoryBean
	 */
	@Bean
	public ColorFactoryBean colorFactoryBean(){
		//这里看起来我们像是注册了一个ColorFactoryBean的Bean,但是实际上获取到的是Color的Bean
		return new ColorFactoryBean();
	}
}