/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study.register;

/**
 * @author fuyang
 * @version $Id: ServiceRegister.java, v 0.1 2019年01月21日 11:39 AM fuyang Exp $
 */
public interface ServiceRegister {

    void register(String service, Object bean);

    Object getServiceBean(String service);
}