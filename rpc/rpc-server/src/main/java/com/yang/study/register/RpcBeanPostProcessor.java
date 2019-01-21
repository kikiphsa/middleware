/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study.register;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.yang.study.domain.RpcService;

/**
 * @author fuyang
 * @version $Id: RpcBeanPostProcessor.java, v 0.1 2019年01月21日 1:58 PM fuyang Exp $
 */
public class RpcBeanPostProcessor implements BeanPostProcessor {

    private ServiceRegister serviceRegister;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(RpcService.class)) {
            String service = bean.getClass().getInterfaces()[0].getName();
            System.out.println("添加服务,service=" + service);
            serviceRegister.register(service, bean);
        }
        return bean;
    }

    /**
     * Setter method for property <tt>serviceRegister</tt>.
     *
     * @param serviceRegister value to be assigned to property serviceRegister
     */
    public void setServiceRegister(ServiceRegister serviceRegister) {
        this.serviceRegister = serviceRegister;
    }
}