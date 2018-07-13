/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yang.study.bean;

import java.io.Serializable;

import com.yang.study.interfaces.Happy;

/**
 *
 *
 * @author fuyang
 * @version $Id: Scu.java, v 0.1 2018年07月13日 下午5:28 fuyang Exp $
 */
public class Scu implements Happy {

    private int rank;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String happy() {
        return "scu happy!";
    }
}