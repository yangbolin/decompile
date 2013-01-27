/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.frame.info;

/**
 * <pre>
 * ��VerificationTypeInfo.java��ʵ��������frame�б����������Ϣ
 * </pre>
 * 
 * @author yangbolin Jan 25, 2013 7:33:18 PM
 */
public class VerificationTypeInfo {

    /** ��� **/
    private int    tag;
    /** ���� **/
    private String name;

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
