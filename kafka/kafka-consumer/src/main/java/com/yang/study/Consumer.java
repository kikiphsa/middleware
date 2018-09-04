/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yang.study;

import org.springframework.kafka.listener.MessageListener;

/**
 * @author fuyang
 * @version $Id: Consumer.java, v 0.1 2018年09月04日 下午3:34 fuyang Exp $
 */
public class Consumer implements MessageListener {

    public void onMessage(Object data) {
        System.out.println(data.getClass());
        System.out.println("receiver msg:" + data);
    }
}