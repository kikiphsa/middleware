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
//        System.out.println(hello.getWorld().getWord());
//        System.out.println("name="+hello.getName());
//        Class<?>clz=Hello.class;
//        try {
//            Hello h= (Hello) clz.newInstance();
//            Field field=clz.getDeclaredField("name");
//            field.setAccessible(true);
//            field.set(h,"jiangchneng");
//            System.out.println(h.getName());
//        }catch (Exception e){
//            e.printStackTrace();
//        }

    }
}
