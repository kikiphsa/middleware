/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study.proxy;

import java.lang.reflect.Proxy;

/**
 * @author fuyang
 * @version $Id: ProxyServiceImpl.java, v 0.1 2019年01月18日 4:23 PM fuyang Exp $
 */
public class ProxyServiceImpl implements ProxyService {

    private RpcInvocationHandler rpcInvocationHandler;

    public <T> T createProxy(Class<T> clazz) {
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), rpcInvocationHandler);
    }

    /**
     * Setter method for property <tt>rpcInvocationHandler</tt>.
     *
     * @param rpcInvocationHandler value to be assigned to property rpcInvocationHandler
     */
    public void setRpcInvocationHandler(RpcInvocationHandler rpcInvocationHandler) {
        this.rpcInvocationHandler = rpcInvocationHandler;
    }
}