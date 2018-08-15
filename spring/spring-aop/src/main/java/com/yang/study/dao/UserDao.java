/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yang.study.dao;

import com.yang.study.bean.Users;

/**
 *
 * @author fuyang
 * @version $Id: UserDao.java, v 0.1 2018年08月14日 下午3:50 fuyang Exp $
 */
public interface UserDao {

    Users getUserByName(String userName);

    int insert(Users users);
}