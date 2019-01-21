/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study.register;

import java.util.*;

import org.springframework.util.CollectionUtils;

/**
 * @author fuyang
 * @version $Id: RegisterServiceImpl.java, v 0.1 2019年01月18日 6:45 PM fuyang Exp $
 */
public class RegisterServiceImpl implements RegisterService {

    private Map<String, List<String>> serviceMapping = new HashMap<>();

    @Override
    public String getServiceAddress(String service) {
        List<String> address = serviceMapping.get(service);
        System.out.println("服务service=" + service + ",可用列表list=" + address);
        if (CollectionUtils.isEmpty(address)) {
            return null;
        }
        return address.get(new Random().nextInt(address.size()));
    }

    @Override
    public void addService(String service, String address) {
        synchronized (this) {
            if (serviceMapping.containsKey(service)) {
                serviceMapping.get(service).add(address);
                return;
            }
            List<String> addressList = new ArrayList<>();
            addressList.add(address);
            serviceMapping.put(service, addressList);
        }
    }

    @Override
    public void removeService(String service, String address) {
        synchronized (this) {
            if (serviceMapping.containsKey(service)) {
                serviceMapping.get(service).remove(address);
            }
        }
    }

    @Override
    public void setService(String service, List<String> list) {
        synchronized (this) {
            System.out.println("更新服务service=" + service + ",列表list=" + list);
            serviceMapping.put(service, list);
        }
    }
}