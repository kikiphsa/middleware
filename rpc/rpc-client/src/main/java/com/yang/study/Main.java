/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yang.study.facade.HelloFacade;
import com.yang.study.proxy.ProxyService;

/**
 * @author fuyang
 * @version $Id: Main.java, v 0.1 2019年01月18日 4:08 PM fuyang Exp $
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProxyService proxyService = context.getBean(ProxyService.class);
        HelloFacade helloFacade = proxyService.createProxy(HelloFacade.class);
        System.out.println(helloFacade.hello("hello"));
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(helloFacade.world("world"));
        ((ClassPathXmlApplicationContext) context).close();
    }
}