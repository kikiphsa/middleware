package com.yang.study;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yang.study.bean.AopBean;
import com.yang.study.bean.Scu;

public class App {

    public static void aopTest(ApplicationContext context) {
        Scu scu = context.getBean("scu", Scu.class);
        System.out.println(scu.getClass());
        System.out.println(scu.happy());
        System.out.println(scu.getRank());
    }

    public static void testAopBeanRefer(ApplicationContext context) {
        AopBean aopBean = context.getBean(AopBean.class);
        System.out.println(aopBean.getScu().getRank());
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
         testAopBeanRefer(context);
    }
}
