/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study.zk;

import java.util.List;

/**
 *
 * @author fuyang
 * @version $Id: ZkClientService.java, v 0.1 2019年01月18日 6:45 PM fuyang Exp $
 */
public interface ZkClientService {

    public static final String ROOT = "/rpc/service";

    boolean exist(String path);

    void createPersistent(String path, Object data);

    void createEphemeral(String path, Object data);

    boolean delete(String path);

    Object read(String path);

    void write(String path, Object data);

    List<String> getChilds(String path);
    
}