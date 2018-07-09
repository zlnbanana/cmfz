package com.zln.cmfz.test;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by zhanglijiao on 2018/7/9.
 */

@Aspect
public class AdviceTest {

    /**
     * 声明切入点表达式
     */
    @Pointcut("execution(* com.zln.cmfz.test.*.*(..))")
    public void pc(){

    }

    /**
     *
     */


}
