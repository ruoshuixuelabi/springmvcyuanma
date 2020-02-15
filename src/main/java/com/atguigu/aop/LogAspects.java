package com.atguigu.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 切面类
 * 注解：@Aspect 注解告诉Spring当前类是一个切面类
 *
 * @author Administrator
 */
@Aspect
public class LogAspects {
    /**
     * 抽取公共的切入点表达式
     * 1、本类引用(只需要写方法的名字)
     * 2、其他的切面引用(需要使用全名)
     */
    @Pointcut("execution(public int com.atguigu.aop.MathCalculator.*(..))")
    public void pointCut() {
    }

    /**
     * 注解：@Before 在目标方法之前切入, 切入点表达式会指定在哪个方法切入
     */
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("" + joinPoint.getSignature().getName() + "运行。。。@Before:参数列表是：{" + Arrays.asList(args) + "}");
    }

    @After("com.atguigu.aop.LogAspects.pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println("" + joinPoint.getSignature().getName() + "结束。。。@After");
    }

    /**
     * 注意:JoinPoint一定要出现在参数表的第一位
     *
     * @param joinPoint
     * @param result    返回值
     */
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println("" + joinPoint.getSignature().getName() + "正常返回。。。@AfterReturning:运行结果：{" + result + "}");
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        System.out.println("" + joinPoint.getSignature().getName() + "异常。。。异常信息：{" + exception + "}");
    }
}
