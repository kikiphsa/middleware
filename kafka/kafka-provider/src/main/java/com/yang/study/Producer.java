/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yang.study;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 *
 * @author fuyang
 * @version $Id: Producer.java, v 0.1 2018年09月04日 下午3:24 fuyang Exp $
 */
public class Producer {

    private KafkaTemplate<Object,Object>kafkaTemplate;

    public void sendMessage(String topic,int partion,Object data){
        ListenableFuture<SendResult<Object,Object>>listenableFuture=kafkaTemplate.send(topic,partion,"key",data);
        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<Object, Object>>() {
            public void onFailure(Throwable ex) {
                System.out.println("send msg failture......");
            }

            public void onSuccess(SendResult<Object, Object> result) {
                System.out.println(result.getProducerRecord());
                System.out.println(result.getRecordMetadata());
                System.out.println("send msg success......");
            }
        });
    }

    /**
     * Setter method for property <tt>kafkaTemplate</tt>.
     *
     * @param kafkaTemplate value to be assigned to property kafkaTemplate
     */
    public void setKafkaTemplate(KafkaTemplate<Object, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
}