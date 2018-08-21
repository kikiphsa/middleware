/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yang.study.bean;

import com.yang.study.interfaces.Happy;
import com.yang.study.interfaces.Login;

/**
 *
 *
 * @author fuyang
 * @version $Id: Scu.java, v 0.1 2018年07月13日 下午5:28 fuyang Exp $
 */
public class Scu implements Happy {

    public Scu(){
        System.out.println("Construct Scu......");
    }

    private int rank;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        System.out.println("setter......");
        this.rank = rank;
    }

    @Login
    public String happy() {
        return "scu happy!";
    }
}