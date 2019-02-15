/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yang.study.netty.ChatClient;

/**
 *
 * @author fuyang
 * @version $Id: Main.java, v 0.1 2019年01月30日 5:45 PM fuyang Exp $
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ChatClient chatClient = applicationContext.getBean(ChatClient.class);
        chatClient.connect();
    }
}