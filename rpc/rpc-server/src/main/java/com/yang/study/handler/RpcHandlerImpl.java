/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study.handler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.yang.study.domain.RpcRequest;
import com.yang.study.domain.RpcResponse;
import com.yang.study.register.ServiceRegister;

/**
 * @author fuyang
 * @version $Id: RpcHandlerImpl.java, v 0.1 2019年01月21日 11:23 AM fuyang Exp $
 */
public class RpcHandlerImpl implements RpcHandler {

    private ServiceRegister serviceRegister;

    @Override
    public RpcResponse handler(RpcRequest rpcRequest) {
        if (rpcRequest == null) {
            return null;
        }
        Object serviceBean = serviceRegister.getServiceBean(rpcRequest.getService());
        if (serviceBean == null) {
            System.out.println("no bean service avaliable......");
            return null;
        }
        Class<?> serviceClass = serviceBean.getClass();
        try {
            Method method = serviceClass.getMethod(rpcRequest.getMethodName(), rpcRequest.getParameterTypes());
            method.setAccessible(true);
            RpcResponse rpcResponse = new RpcResponse();
            rpcResponse.setRequestId(rpcRequest.getRequestId());
            rpcResponse.setResult(method.invoke(serviceBean, rpcRequest.getParameters()));
            return rpcResponse;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Setter method for property <tt>serviceRegister</tt>.
     *
     * @param serviceRegister value to be assigned to property serviceRegister
     */
    public void setServiceRegister(ServiceRegister serviceRegister) {
        this.serviceRegister = serviceRegister;
    }
}