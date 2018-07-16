package com.yang.study;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yang.study.service.HelloService;

/**
 * Created by yang on 2018/3/22.
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        HelloService helloService = (HelloService) applicationContext.getBean("dubboService");
        System.out.println(helloService.sayHello("world!"));
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
