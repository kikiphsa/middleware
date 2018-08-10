package com.yang.study;

import java.util.Arrays;

import com.yang.study.bean.Hello;
import com.yang.study.bean.World;
import com.yang.study.collection.CollectionBean;
import com.yang.study.collection.Time;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {

    public static void testBeanInit(ApplicationContext context){
        Hello hello = context.getBean("hello", Hello.class);
        System.out.println(hello.getName());
        ((ClassPathXmlApplicationContext) context).close();
    }

    public static void testCollenction(ApplicationContext context){
        CollectionBean collectionBean=context.getBean(CollectionBean.class);
        Time time=collectionBean.getTime();
        System.out.println(time.getDay());
        System.out.println(Arrays.toString(collectionBean.getArrays()));
        System.out.println(collectionBean.getList());
        System.out.println(collectionBean.getSet());
        System.out.println(collectionBean.getMap());
        System.out.println(collectionBean.getProperties());
        World world=context.getBean("world",World.class);
        System.out.println(world.getWord());
        System.out.println(world.getHello());
    }

    public static void testAutowire(ApplicationContext context){
        CollectionBean collectionBean=context.getBean(CollectionBean.class);
        System.out.println(collectionBean.getWorld().getWord());
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        testAutowire(context);
    }
}
