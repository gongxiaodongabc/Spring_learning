package com.qmh.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * 用于记录日志的工具类 ，提供了公共的代码
 */
@EnableAspectJAutoProxy
@Component("logger")
@Aspect //表示当前类是一个切面类
public class Logger {
    @Pointcut("execution( * com.qmh.service.impl.*.*(..))")
    private  void pt1(){

    }
    /**
     * 前置通知
     */
//    @Before("pt1()")
    public void beforePrintLog(){
        System.out.println("前置通知 Logger类中的beforePrintLog方法开始记录日志");
    }

    /**
     * 后置通知
     */
//    @AfterReturning("pt1()")
    public void afterReturningPrintLog(){
        System.out.println("后置通知 Logger类中的afterReturningPrintLog方法开始记录日志");
    }


    /**
     * 异常通知
     */
//    @AfterThrowing("pt1()")
    public void afterThrowingPrintLog(){
        System.out.println("异常通知 Logger类中的afterThrowingPrintLog方法开始记录日志");
    }

    /**
     * 最终通知
     */
//    @After("pt1()")
    public void afterPrintLog(){
        System.out.println("最终通知 Logger类中的afterPrintLog方法开始记录日志");
    }

    /**
     * 环绕通知
     * 问题：
     *      配置了环绕通知之后，切入点方法没有执行，而通知方法执行了
     *  分析：
     *      动态代理中的环绕通知有明确的切入点方法调用，而代码中没有
     *   解决：
     *      接口ProceedingJoinPoint 该接口有一个方法proceed,此方法就相当于明确调用切入点方法
     *   Spring中的环绕通知：
     *      它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式
     */
    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try{
            Object[] args = pjp.getArgs();//得到方法执行所需的参数
            System.out.println(" Logger类中的aroundPrintLog方法开始记录日志 前置");
            pjp.proceed();//明确调用切入点方法
            System.out.println(" Logger类中的aroundPrintLog方法开始记录日志 后置");
            return rtValue;
        }catch (Throwable t){
            System.out.println(" Logger类中的aroundPrintLog方法开始记录日志 异常");
            throw new RuntimeException(t);
        }finally {
            System.out.println(" Logger类中的aroundPrintLog方法开始记录日志 最终");
        }


    }
}
