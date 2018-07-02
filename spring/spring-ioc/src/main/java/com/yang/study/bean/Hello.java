package com.yang.study.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;

/**
 * Created by fuyang on 2018/6/30.
 */
public class Hello implements InitializingBean,BeanFactoryAware,BeanNameAware{

    private String name;
    private World world;

    public Hello() {
        System.out.println("Construct.......");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setter......");
        this.name = name;
    }

    public void init(){
        System.out.println("init......");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("postConstruct......");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("beanFactory="+beanFactory);
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("beanName="+s);
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
