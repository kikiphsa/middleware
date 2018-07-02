package com.yang.study.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by fuyang on 2018/6/30.
 */
public class LogBeanPostProcess implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if (o instanceof Hello) {
            System.out.println("postProcessBeforeInitialization");
            System.out.println(s);
        }
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if (o instanceof Hello) {
            System.out.println("postProcessAfterInitialization");
            System.out.println(s);
        }
        return o;
    }
}

