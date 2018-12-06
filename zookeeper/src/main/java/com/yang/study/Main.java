/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yang.study;

import org.apache.zookeeper.*;

import com.yang.study.zookeeper.ZkConnect;

/**
 * @author fuyang
 * @version $Id: Main.java, v 0.1 2018年11月26日 2:40 PM fuyang Exp $
 */
public class Main {

    public static void main(String[] args) {
        ZkConnect zkConnect = new ZkConnect("127.0.0.1", 1000);
        ZooKeeper zooKeeper = zkConnect.connect();
        zooKeeper.addAuthInfo("digest", "auth".getBytes());
        ZooKeeper zooKeeper1 = zkConnect.connect();
        try {
            zooKeeper.exists("/fuyang/aa/bb", new Watcher() {
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("zookeeper:" + watchedEvent);
                }
            });
            zooKeeper1.exists("/fuyang/aa/bb", new Watcher() {
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("zookeeper1:" + watchedEvent);
                }
            });
            zooKeeper.create("/fuyang/aa/bb", "test".getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
            zooKeeper.create("/fuyang/aa/bb/ee", "test".getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.EPHEMERAL);
            zooKeeper1.delete("/fuyang/aa/bb/ee",-1);
            zooKeeper1.delete("/fuyang/aa/bb",-1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
        zkConnect.close();
    }
}