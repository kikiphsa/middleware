/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yang.study.zookeeper;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

/**
 * @author fuyang
 * @version $Id: ZkConnect.java, v 0.1 2018年11月26日 2:44 PM fuyang Exp $
 */
public class ZkConnect {

    private static final String ROOT = "/fuyang";

    private String config;

    private int timeOut;

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    private ZooKeeper zooKeeper;

    public ZkConnect(String config, int timeOut) {
        this.config = config;
        this.timeOut = timeOut;
    }

    public ZooKeeper connect() {
        try {
            zooKeeper = new ZooKeeper(config, timeOut, new Watcher() {
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("watch:" + watchedEvent);
                    if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                        countDownLatch.countDown();
                    }
                }
            });
            countDownLatch.await();
            System.out.println("connected to zookeeper......");
            if (exist(ROOT) == null) {
                createNode(ROOT, "fuyang", CreateMode.PERSISTENT);
            } else {
                System.out.println("root already exist...");
            }
            return zooKeeper;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String createNode(String path, String data, CreateMode createMode) {
        try {
            return zooKeeper.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, createMode);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getChild(String path) {
        try {
            return zooKeeper.getChildren(path, new Watcher() {
                public void process(WatchedEvent watchedEvent) {
                    System.out.println(watchedEvent);
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Stat exist(String path) {
        try {
            return zooKeeper.exists(path, new Watcher() {
                public void process(WatchedEvent watchedEvent) {
                    System.out.println(watchedEvent);
                }
            });
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Stat setData(String path, String message) {
        try {
            return zooKeeper.setData(path, message.getBytes(), -1);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getData(String path) {
        Stat stat = new Stat();
        try {
            return new String(zooKeeper.getData(path, true, stat));
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(String path) {
        try {
            zooKeeper.delete(path, -1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            zooKeeper.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}