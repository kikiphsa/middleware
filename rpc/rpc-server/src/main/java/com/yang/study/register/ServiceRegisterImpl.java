/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study.register;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import com.yang.study.zk.ZkClientService;

/**
 * @author fuyang
 * @version $Id: ServiceRegisterImpl.java, v 0.1 2019年01月21日 11:42 AM fuyang Exp $
 */
public class ServiceRegisterImpl implements ServiceRegister {

    private ZkClientService zkClientService;

    private Map<String, Object> serviceBeanMapping = new HashMap<>();

    @Override
    public void register(String service, Object bean) {
        serviceBeanMapping.put(service, bean);
        if (!zkClientService.exist(ZkClientService.ROOT + "/" + service)) {
            zkClientService.createPersistent(ZkClientService.ROOT + "/" + service, null);
        }
        try {
            String address = InetAddress.getLocalHost().getHostAddress() + ":1234";
            if (!zkClientService.exist(ZkClientService.ROOT + "/" + service + "/" + address)) {
                System.out.println("添加服务service=" + service + ",address=" + address);
                zkClientService.createEphemeral(ZkClientService.ROOT + "/" + service + "/" + address, null);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getServiceBean(String service) {
        return serviceBeanMapping.get(service);
    }

    /**
     * Setter method for property <tt>zkClientService</tt>.
     *
     * @param zkClientService value to be assigned to property zkClientService
     */
    public void setZkClientService(ZkClientService zkClientService) {
        this.zkClientService = zkClientService;
    }
}