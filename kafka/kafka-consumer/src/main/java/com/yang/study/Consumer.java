/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yang.study;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

/**
 * @author fuyang
 * @version $Id: Consumer.java, v 0.1 2018年09月04日 下午3:34 fuyang Exp $
 */
public class Consumer implements MessageListener {

    public void onMessage(Object data) {
        ConsumerRecord consumerRecord=(ConsumerRecord) data;
        System.out.println(consumerRecord);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}