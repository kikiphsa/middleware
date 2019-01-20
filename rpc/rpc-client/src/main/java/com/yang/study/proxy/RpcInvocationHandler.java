/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

import com.yang.study.domain.RpcRequest;
import com.yang.study.domain.RpcResponse;
import com.yang.study.network.TransPortService;
import com.yang.study.register.RegisterService;

/**
 * @author fuyang
 * @version $Id: RpcInvocationHandler.java, v 0.1 2019年01月18日 4:09 PM fuyang Exp $
 */
public class RpcInvocationHandler implements InvocationHandler {

    private RegisterService registerService;

    private TransPortService transPortService;

    private AtomicLong atomicLong = new AtomicLong();

    private ExecutorService executorService;

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Future<RpcResponse> future = executorService.submit(new Callable<RpcResponse>() {
            @Override
            public RpcResponse call() {
                RpcRequest rpcRequest = new RpcRequest();
                rpcRequest.setService(proxy.getClass().getName());
                rpcRequest.setMethodName(method.getName());
                rpcRequest.setRequestId(atomicLong.get());
                rpcRequest.setParameters(args);
                rpcRequest.setParameterTypes(method.getParameterTypes());
                String address = registerService.getServiceAddress(method.getDeclaringClass().getName());
                if (address == null) {
                    System.out.println("no service avalibale......");
                    return null;
                }
                String[] array = address.split(":");
                return transPortService.transport(array[0], Integer.parseInt(array[1]), rpcRequest);
            }
        });
        return future.get();
    }

    /**
     * Setter method for property <tt>transPortService</tt>.
     *
     * @param transPortService value to be assigned to property transPortService
     */
    public void setTransPortService(TransPortService transPortService) {
        this.transPortService = transPortService;
    }

    /**
     * Setter method for property <tt>executorService</tt>.
     *
     * @param executorService value to be assigned to property executorService
     */
    public void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    /**
     * Setter method for property <tt>registerService</tt>.
     *
     * @param registerService value to be assigned to property registerService
     */
    public void setRegisterService(RegisterService registerService) {
        this.registerService = registerService;
    }
}