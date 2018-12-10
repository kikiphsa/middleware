/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yang.study.curator;

import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * @author fuyang
 * @version $Id: Curator.java, v 0.1 2018年12月10日 2:36 PM fuyang Exp $
 */
public class Curator {

    public CuratorFramework curatorFramework;

    public Curator(String config, int sessionTimeOut, int connectTimeOut) {
        curatorFramework = CuratorFrameworkFactory.builder().connectString(config).sessionTimeoutMs(sessionTimeOut).connectionTimeoutMs(
                connectTimeOut)
                .retryPolicy(new ExponentialBackoffRetry(1000, 6)).build();
    }

    private void connect() {
        curatorFramework.start();
    }

    private void close() {
        if (curatorFramework != null) {
            curatorFramework.close();
        }
    }

    private void create(String path, byte[] data, CreateMode createMode) {
        try {
            curatorFramework.create().withMode(createMode).forPath(path, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createInBackGround(String path, byte[] data) {
        try {
            System.out.println(curatorFramework);
            curatorFramework.create().withMode(CreateMode.EPHEMERAL).inBackground(new BackgroundCallback() {
                public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                    System.out.println(curatorFramework);
                    System.out.println(curatorEvent);
                }
            }).forPath(path, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<String> getChildren(String path) {
        try {
            return curatorFramework.getChildren().forPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean exists(String path) {
        try {
            return curatorFramework.checkExists().forPath(path) != null ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void delete(String path) {
        try {
            curatorFramework.delete().forPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private byte[] getData(String path) {
        try {
            return curatorFramework.getData().forPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void setData(String path, byte[] data) {
        try {
            curatorFramework.setData().withVersion(-1).forPath(path, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Curator curator = new Curator("localhost", 1000, 1000);
        curator.connect();
        curator.create("/fuyang/curator", "test".getBytes(), CreateMode.EPHEMERAL);
        System.out.println(new String(curator.getData("/fuyang/curator")));
        curator.setData("/fuyang/curator", "test2".getBytes());
        System.out.println(new String(curator.getData("/fuyang/curator")));
        System.out.println(curator.exists("/fuyang/curator"));
        System.out.println(curator.getChildren("/fuyang"));
        curator.delete("/fuyang/curator");
        System.out.println(curator.exists("/fuyang/curator"));
        curator.createInBackGround("/fuyang/curators", "test".getBytes());
        curator.close();
    }
}