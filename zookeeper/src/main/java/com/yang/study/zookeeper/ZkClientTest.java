/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yang.study.zookeeper;

import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

/**
 * @author fuyang
 * @version $Id: ZkClientTest.java, v 0.1 2018年12月06日 5:08 PM fuyang Exp $
 */
public class ZkClientTest {

    private ZkClient zkClient;

    public ZkClientTest(String config, int connectTimeOut) {
        zkClient = new ZkClient(config, connectTimeOut);
    }

    private void createNode(String path, Object data) {
        zkClient.createPersistent(path, data);
    }

    private String getData(String path) {
        return zkClient.readData(path);
    }

    private void setData(String path, Object data) {
        zkClient.writeData(path, data);
    }

    private boolean exist(String path) {
        return zkClient.exists(path);
    }

    private void close() {
        zkClient.close();
    }

    private void dataChangeListener(String path) {
        zkClient.subscribeDataChanges(path, new IZkDataListener() {
            public void handleDataChange(String dataPath, Object data) throws Exception {
                System.out.println("change:" + dataPath + " " + data);
            }

            public void handleDataDeleted(String dataPath) throws Exception {
                System.out.println("delete:" + dataPath);
            }
        });
    }

    private void childChangeListener(String path) {
        zkClient.subscribeChildChanges(path, new IZkChildListener() {
            public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
                System.out.println(parentPath + " " + currentChilds);
            }
        });
    }

    private void delete(String path) {
        zkClient.deleteRecursive(path);
    }

    public static void main(String[] args) {
        ZkClientTest zkClientTest = new ZkClientTest("localhost:2181", 3000);
        zkClientTest.dataChangeListener("/fuyang/zz");
        zkClientTest.childChangeListener("/fuyang/zz");
        zkClientTest.createNode("/fuyang/zz","fuyang");
        try {
            Thread.sleep(3000);
            System.out.println("test");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        zkClientTest.createNode("/fuyang/zz/cc", "fuyang");
        try {
            Thread.sleep(3000);
            zkClientTest.delete("/fuyang");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        zkClientTest.close();
    }
}