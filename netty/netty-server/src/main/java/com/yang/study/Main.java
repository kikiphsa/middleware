/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yang.study.netty.ChatServer;

/**
 * @author fuyang
 * @version $Id: Main.java, v 0.1 2019年01月30日 5:46 PM fuyang Exp $
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ChatServer chatServer = applicationContext.getBean(ChatServer.class);
        chatServer.bind();
    }
}