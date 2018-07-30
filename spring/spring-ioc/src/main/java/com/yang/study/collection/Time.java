/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yang.study.collection;

/**
 *
 * @author fuyang
 * @version $Id: Time.java, v 0.1 2018年07月30日 下午12:13 fuyang Exp $
 */
public enum Time {
    DAY("DAY"),
    SECOND("second");


    private String day;

    private Time(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}