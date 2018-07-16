package com.yang.study;

import com.yang.study.bean.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Hello hello = context.getBean("hello", Hello.class);
        System.out.println(hello.getName());
        ((ClassPathXmlApplicationContext) context).close();
    }
}
