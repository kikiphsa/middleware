/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study.zk;

import java.util.List;

import org.I0Itec.zkclient.ZkClient;

/**
 * @author fuyang
 * @version $Id: ZkClientServiceImpl.java, v 0.1 2019年01月18日 6:46 PM fuyang Exp $
 */
public class ZkClientServiceImpl implements ZkClientService {

    private String address;

    private ZkClient zkClient;

    public void init() {
        zkClient = new ZkClient(address, 3000);
        if (!exist(ROOT)) {
            createPersistent(ROOT, true);
        }
    }

    public boolean exist(String path) {
        return zkClient.exists(path);
    }

    public void createPersistent(String path, Object data) {
        zkClient.createPersistent(path, data);
    }

    public void createEphemeral(String path, Object data) {
        zkClient.createEphemeral(path, data);
    }

    public boolean delete(String path) {
        return zkClient.deleteRecursive(path);
    }

    public Object read(String path) {
        return zkClient.readData(path);
    }

    public void write(String path, Object data) {
        zkClient.writeData(path, data);
    }

    public List<String> getChilds(String path) {
        return zkClient.getChildren(path);
    }

    /**
     * Setter method for property <tt>address</tt>.
     *
     * @param address value to be assigned to property address
     */
    public void setAddress(String address) {
        this.address = address;
    }
}