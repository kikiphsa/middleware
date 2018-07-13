/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yang.study.apsect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 *
 * @author fuyang
 * @version $Id: MyAspect.java, v 0.1 2018年07月13日 下午5:34 fuyang Exp $
 */
@Aspect
public class MyAspect {

    @Pointcut("execution(* com.yang.study.bean.*.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void before(){
        System.out.println("before......");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("after......");
    }
}