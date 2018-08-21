/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yang.study.interceper;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 *
 * @author fuyang
 * @version $Id: MyIntercept.java, v 0.1 2018年08月17日 下午5:24 fuyang Exp $
 */
public class MyIntercept implements MethodInterceptor {
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("interceptor...."+invocation.getMethod().getName());
        return invocation.proceed();
    }
}