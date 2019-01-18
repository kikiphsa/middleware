/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study.domain;

/**
 * @author fuyang
 * @version $Id: RpcResponse.java, v 0.1 2019年01月18日 3:50 PM fuyang Exp $
 */
public class RpcResponse {

    private String requestId;

    private Object result;

    /**
     * Getter method for property <tt>requestId</tt>.
     *
     * @return property value of requestId
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Setter method for property <tt>requestId</tt>.
     *
     * @param requestId value to be assigned to property requestId
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    /**
     * Getter method for property <tt>result</tt>.
     *
     * @return property value of result
     */
    public Object getResult() {
        return result;
    }

    /**
     * Setter method for property <tt>result</tt>.
     *
     * @param result value to be assigned to property result
     */
    public void setResult(Object result) {
        this.result = result;
    }
}