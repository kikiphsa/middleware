/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yang.study;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author fuyang
 * @version $Id: Main.java, v 0.1 2018年09月04日 下午3:10 fuyang Exp $
 */
public class Main {

    public static final String TOPIC = "fuyang";

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Producer producer = context.getBean(Producer.class);
        producer.sendMessage(TOPIC,"hello!");
    }
}