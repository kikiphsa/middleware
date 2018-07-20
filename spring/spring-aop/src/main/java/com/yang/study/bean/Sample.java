/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yang.study.bean;

/**
 *
 * @author fuyang
 * @version $Id: Sample.java, v 0.1 2018年07月20日 下午7:47 fuyang Exp $
 */
public class Sample {
    private String name;

    public String getName() {
        return name + 1/0;
    }

    public void setName(String name) {
        this.name = name;
    }
}