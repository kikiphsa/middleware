/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author fuyang
 * @version $Id: ProxyServiceImpl.java, v 0.1 2019年01月18日 4:23 PM fuyang Exp $
 */
public class ProxyServiceImpl implements ProxyService {

    private InvocationHandler invocationHandler;

    public <T> T createProxy(Class<T> clazz) {
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, invocationHandler);
    }

    /**
     * Setter method for property <tt>invocationHandler</tt>.
     *
     * @param invocationHandler value to be assigned to property invocationHandler
     */
    public void setInvocationHandler(InvocationHandler invocationHandler) {
        this.invocationHandler = invocationHandler;
    }
}