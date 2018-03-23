package com.yang.study.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        applicationContext.start();
        System.out.println( "service start......" );
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
