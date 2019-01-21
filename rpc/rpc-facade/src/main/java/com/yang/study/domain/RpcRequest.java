/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study.domain;

import java.io.Serializable;

/**
 * @author fuyang
 * @version $Id: RpcRequest.java, v 0.1 2019年01月18日 3:48 PM fuyang Exp $
 */
public class RpcRequest implements Serializable {

    private long requestId;

    private String service;

    private String methodName;

    private Class<?>[] parameterTypes;

    private Object[] parameters;

    /**
     * Getter method for property <tt>requestId</tt>.
     *
     * @return property value of requestId
     */
    public long getRequestId() {
        return requestId;
    }

    /**
     * Setter method for property <tt>requestId</tt>.
     *
     * @param requestId value to be assigned to property requestId
     */
    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    /**
     * Getter method for property <tt>methodName</tt>.
     *
     * @return property value of methodName
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * Setter method for property <tt>methodName</tt>.
     *
     * @param methodName value to be assigned to property methodName
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    /**
     * Getter method for property <tt>parameterTypes</tt>.
     *
     * @return property value of parameterTypes
     */
    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    /**
     * Setter method for property <tt>parameterTypes</tt>.
     *
     * @param parameterTypes value to be assigned to property parameterTypes
     */
    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    /**
     * Getter method for property <tt>parameters</tt>.
     *
     * @return property value of parameters
     */
    public Object[] getParameters() {
        return parameters;
    }

    /**
     * Setter method for property <tt>parameters</tt>.
     *
     * @param parameters value to be assigned to property parameters
     */
    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    /**
     * Getter method for property <tt>service</tt>.
     *
     * @return property value of service
     */
    public String getService() {
        return service;
    }

    /**
     * Setter method for property <tt>service</tt>.
     *
     * @param service value to be assigned to property service
     */
    public void setService(String service) {
        this.service = service;
    }
}