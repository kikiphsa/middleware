package com.yang.study;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yang.study.bean.Scu;
import com.yang.study.interfaces.Happy;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Scu scu = context.getBean("scu", Scu.class);
        System.out.println(scu.getClass());
    }
}
