/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yang.study.network.TransPortService;

/**
 * @author fuyang
 * @version $Id: Main.java, v 0.1 2019年01月21日 10:44 AM fuyang Exp $
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TransPortService transPortService = context.getBean(TransPortService.class);
        transPortService.transport();
        ((ClassPathXmlApplicationContext) context).close();
    }
}