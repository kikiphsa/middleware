/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study.handler;

import com.yang.study.domain.RpcRequest;
import com.yang.study.domain.RpcResponse;

/**
 * @author fuyang
 * @version $Id: RpcHandler.java, v 0.1 2019年01月21日 11:23 AM fuyang Exp $
 */
public interface RpcHandler {

    RpcResponse handler(RpcRequest rpcRequest);

}