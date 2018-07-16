package com.yang.study.service;

/**
 * Created by yang on 2018/3/22.
 */
public class HelloServiceImpl implements HelloService {

    public String sayHello(String data) {
        return "Hello," + data + "!";
    }
}
