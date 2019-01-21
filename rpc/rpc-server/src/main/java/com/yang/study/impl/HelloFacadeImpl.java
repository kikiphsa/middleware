/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study.impl;

import com.yang.study.domain.RpcService;
import com.yang.study.facade.HelloFacade;

/**
 * @author fuyang
 * @version $Id: HelloFacadeImpl.java, v 0.1 2019年01月21日 1:57 PM fuyang Exp $
 */
@RpcService
public class HelloFacadeImpl implements HelloFacade {
    @Override
    public String hello(String str) {
        return "hello," + str;
    }

    @Override
    public String world(String str) {
        return str + ",world";
    }
}