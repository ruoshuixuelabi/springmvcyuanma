package com.atguigu.test;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import com.atguigu.bean.Person;
import com.atguigu.config.MainConfigOfPropertyValues;
public class IOCTest_PropertyValue {
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
			MainConfigOfPropertyValues.class);
	@Test
	public void test01() {
		printBeans(applicationContext);
		System.out.println("=============");
		Person person = (Person) applicationContext.getBean("person");
		System.out.println(person);
		//我们可以获取配置环境变量里面所有的值
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String property = environment.getProperty("person.nickName");
		System.out.println(property);
		applicationContext.close();
	}
	private void printBeans(AnnotationConfigApplicationContext applicationContext) {
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
	}
}
