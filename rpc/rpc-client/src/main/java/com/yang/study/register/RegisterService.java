/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study.register;

import java.util.List;

/**
 * @author fuyang
 * @version $Id: RegisterService.java, v 0.1 2019年01月18日 6:26 PM fuyang Exp $
 */
public interface RegisterService {

    String getServiceAddress(String service);

    void addService(String service, String address);

    void removeService(String service, String address);

    void setService(String service,List<String> list);
}