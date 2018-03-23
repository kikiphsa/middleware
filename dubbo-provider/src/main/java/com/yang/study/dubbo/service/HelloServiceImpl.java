package com.yang.study.dubbo.service;

/**
 * Created by yang on 2018/3/22.
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String data) {
        return "Hello," + data + "!";
    }
}
