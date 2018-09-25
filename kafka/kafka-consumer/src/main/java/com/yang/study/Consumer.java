/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yang.study;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;

/**
 * @author fuyang
 * @version $Id: Consumer.java, v 0.1 2018年09月04日 下午3:34 fuyang Exp $
 */
public class Consumer implements AcknowledgingMessageListener {

    public void onMessage(ConsumerRecord data, Acknowledgment acknowledgment) {
        System.out.println("ack:"+data);
        int i=2/0;
        acknowledgment.acknowledge();
    }

    public void onMessage(Object data) {
        System.out.println(data);
    }
}