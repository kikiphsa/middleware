/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yang.study.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yang.study.bean.Users;
import com.yang.study.dao.UserDao;

/**
 * @author fuyang
 * @version $Id: UserService.java, v 0.1 2018年08月14日 下午3:55 fuyang Exp $
 */
public class UserService {

    @Autowired
    private UserDao userDao;

    public Users getUserName(String userName) {
        return userDao.getUserByName(userName);
    }

    @Transactional(propagation = Propagation.NESTED,noRollbackFor = ArithmeticException.class)
    public int transaction() {
        String userName = "alibaba" + new Random().nextInt();
        System.out.println("userService-userName=" + userName);
        Users users = new Users(userName, 26);
        insert(users);
        return 1/0;
    }

    @Transactional
    public int transactions() {
        return transaction();
    }

    public int insert(Users users) {
        return userDao.insert(users);
    }
}