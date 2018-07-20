/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yang.study.apsect;

/**
 * @author fuyang
 * @version $Id: MyAspect.java, v 0.1 2018年07月13日 下午5:34 fuyang Exp $
 */
public class MyAspect {

    public void pointCut() {}

    public void before() {
        System.out.println("before one......");
    }

    public void after() {
        System.out.println("after one......");
    }
}