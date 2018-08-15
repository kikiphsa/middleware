/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yang.study.bean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author fuyang
 * @version $Id: Cat.java, v 0.1 2018年08月14日 下午2:15 fuyang Exp $
 */
public class Cat {

    public Cat() {
        System.out.println("constrcut...");
    }

    @Autowired
    public Cat(Mouse mouse) {
        this.mouse = mouse;
        System.out.println("constrcut...args "+mouse);
    }

    private Mouse mouse;

    /**
     * Setter method for property <tt>mouse</tt>.
     *
     * @param mouse value to be assigned to property mouse
     */

    public void setMouse(Mouse mouse) {
        System.out.println("setter mouse "+mouse);
        this.mouse = mouse;
    }

    /**
     * Getter method for property <tt>mouse</tt>.
     *
     * @return property value of mouse
     */
    public Mouse getMouse() {
        return mouse;
    }
}