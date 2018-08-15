/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yang.study.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.yang.study.bean.Users;
import com.yang.study.dao.UserDao;

/**
 * @author fuyang
 * @version $Id: SampleService.java, v 0.1 2018年08月14日 下午7:26 fuyang Exp $
 */
public class SampleService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @Transactional(noRollbackFor = ArithmeticException.class)
    public int hello() {
        String userName = "alibaba" + new Random().nextInt();
        System.out.println("sampleService-userName=" + userName);
        Users users = new Users(userName, 25);
        userDao.insert(users);
        userService.transaction();
        return 0;
    }
}