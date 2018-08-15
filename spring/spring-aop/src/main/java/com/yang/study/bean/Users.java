/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yang.study.bean;

/**
 *
 * @author fuyang
 * @version $Id: Users.java, v 0.1 2018年08月14日 下午3:51 fuyang Exp $
 */
public class Users {

    private String userName;
    private int age;

    public Users(){

    }

    public Users(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    /**
     * Getter method for property <tt>userName</tt>.
     *
     * @return property value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter method for property <tt>userName</tt>.
     *
     * @param userName value to be assigned to property userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Getter method for property <tt>age</tt>.
     *
     * @return property value of age
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter method for property <tt>age</tt>.
     *
     * @param age value to be assigned to property age
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "userName="+userName+",age="+age;
    }
}