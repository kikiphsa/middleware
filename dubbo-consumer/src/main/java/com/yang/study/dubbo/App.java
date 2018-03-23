package com.yang.study.dubbo;

import com.yang.study.dubbo.service.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by yang on 2018/3/22.
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        applicationContext.start();
        HelloService helloService = (HelloService) applicationContext.getBean("dubboService");
        System.out.println(helloService.sayHello("world!"));
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
