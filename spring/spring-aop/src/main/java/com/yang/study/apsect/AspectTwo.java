/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yang.study.apsect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author fuyang
 * @version $Id: AspectTwo.java, v 0.1 2018年07月20日 下午8:07 fuyang Exp $
 */
@Aspect
public class AspectTwo {
    @Pointcut("execution(* com.yang.study.bean.*.*(..))")
    public void pointCut() {}

    @Before("pointCut()")
    public void before() {
        System.out.println("before two......");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("after two......");
    }

    @AfterReturning("pointCut()")
    public void atferReturn() {
        System.out.println("afterReturning");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around...");
        return joinPoint.proceed();
    }

    @AfterThrowing("pointCut()")
    public void throwss() {
        System.out.println("throws...");
    }
}