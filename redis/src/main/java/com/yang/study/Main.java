/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yang.study;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yang.study.redis.RedisService;

/**
 * @author fuyang
 * @version $Id: Main.java, v 0.1 2018年08月30日 下午5:20 fuyang Exp $
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RedisService redisService = context.getBean(RedisService.class);
        redisService.lSet("aaa", "aaa");
        redisService.lSet("aaa", "bbb");
        redisService.lSet("aaa", "ccc");
        System.out.println(redisService.lGet("aaa"));
        System.out.println(redisService.lGetIndex("aaa",-1));
        System.out.println(redisService.lsize("aaa"));
    }
}