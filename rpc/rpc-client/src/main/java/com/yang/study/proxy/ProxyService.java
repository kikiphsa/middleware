/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study.proxy;

/**
 * @author fuyang
 * @version $Id: ProxyService.java, v 0.1 2019年01月18日 4:08 PM fuyang Exp $
 */
public interface ProxyService {

    <T> T createProxy(Class<T> clazz);
}