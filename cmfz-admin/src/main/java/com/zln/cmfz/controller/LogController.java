package com.zln.cmfz.controller;

import com.zln.cmfz.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by zhanglijiao on 2018/7/9.
 */
@Aspect
public class LogController {

    @Autowired
    private LogService logService;

    //声明切入点表达式
    @Pointcut("execution(* com.zln.cmfz.service.impl.*.*(..))")
    public void pc(){

    }


    @Around("pc()")
    public Object log(ProceedingJoinPoint pjp) throws Throwable{
        //获取参数
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
        }

        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        //获取方法对象
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());
        //获取方法所在类 及 类型
        System.out.println(methodSignature.getDeclaringType());
        //获取方法所在类
        System.out.println(methodSignature.getDeclaringTypeName());
        //获取方法的注解
        Annotation[] annotations = method.getAnnotations();
        System.out.println("-------开始-------");
        Object obj = pjp.proceed();
        System.out.println("-------结束-------");
        return obj;


    }

}
