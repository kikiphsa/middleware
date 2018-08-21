/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yang.study.bean;

import org.springframework.beans.factory.annotation.Autowired;

import com.yang.study.interfaces.Happy;

/**
 *
 * @author fuyang
 * @version $Id: AopBean.java, v 0.1 2018年07月31日 下午8:07 fuyang Exp $
 */
public class AopBean {

    @Autowired
    private Happy happy;

    /**
     * Getter method for property <tt>happy</tt>.
     *
     * @return property value of happy
     */
    public Happy getHappy() {
        return happy;
    }

    /**
     * Setter method for property <tt>happy</tt>.
     *
     * @param happy value to be assigned to property happy
     */
    public void setHappy(Happy happy) {
        this.happy = happy;
    }
}