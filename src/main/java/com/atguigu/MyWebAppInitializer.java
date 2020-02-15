package com.atguigu;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import com.atguigu.config.AppConfig;
import com.atguigu.config.RootConfig;
//web容器启动的时候创建对象；调用方法来初始化容器以前前端控制器
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	/**
	 * 获取根容器的配置类(Spring的配置文件),父容器
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{RootConfig.class};
	}
	/**
	 * 获取web容器的配置类(Spring MVC配置文件)子容器
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{AppConfig.class};
	}
	/**
	 * 获取DispatcherServlet的映射信息
	 * / 代表拦截所有请求,包括静态资源(xx.js,xx.png),但是不包括JSP页面
	 * 注意:如果是 /*也是表示拦截所有请求,但是连*.jsp页面都拦截,JSP页面是Tomcat的JSP引擎解析的,不能拦截
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
}
