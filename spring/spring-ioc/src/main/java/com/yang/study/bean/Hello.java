package com.yang.study.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * Created by fuyang on 2018/6/30.
 */
public class Hello implements InitializingBean, BeanFactoryAware, BeanNameAware, DisposableBean {

    private String name;
    private World  world;

    public Hello(String name) {
        this.name = name;
        System.out.println("Construct args.......");
    }

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

    public void destorys() {
        System.out.println("destory......");
    }

    public void init() {
        System.out.println("init......");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct......");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("preDestroy......");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("beanFactory=" + beanFactory);
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("beanName=" + s);
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("disposableBean......");
    }
}
