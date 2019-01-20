/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study.zk;

import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import com.yang.study.register.RegisterService;

/**
 * @author fuyang
 * @version $Id: ZkClientServiceImpl.java, v 0.1 2019年01月18日 6:46 PM fuyang Exp $
 */
public class ZkClientServiceImpl implements ZkClientService {

    private static final String ROOT = "/rpc/service";

    private String address;

    private ZkClient zkClient;

    private RegisterService registerService;

    public void init() {
        zkClient = new ZkClient(address, 3000);
        if (!exist(ROOT)) {
            zkClient.createPersistent(ROOT, true);
        }
        List<String> servics = getChilds(ROOT);
        for (String sevice : servics) {
            childChangesListener(ROOT + "/" + sevice);
            registerService.setService(sevice, getChilds(ROOT + "/" + sevice));
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

    public void dataChangeListener(String path) {
        zkClient.subscribeDataChanges(path, new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println("data changed, path=:" + s + ",data=" + o);
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println("data deleted, path=:" + s + ",data=");
            }
        });
    }

    public void childChangesListener(String path) {
        zkClient.subscribeChildChanges(path, new IZkChildListener() {
            @Override
            public void handleChildChange(String s, List<String> list) throws Exception {
                if (s.startsWith(ROOT)) {
                    String service = s.substring(ROOT.length() + 1);
                    registerService.setService(service, list);
                }
                System.out.println("childs changed, path=:" + s + ",data=" + list);
            }
        });
    }

    /**
     * Setter method for property <tt>address</tt>.
     *
     * @param address value to be assigned to property address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Setter method for property <tt>registerService</tt>.
     *
     * @param registerService value to be assigned to property registerService
     */
    public void setRegisterService(RegisterService registerService) {
        this.registerService = registerService;
    }
}