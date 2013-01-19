/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.constant.pool.impl;

import com.alibaba.decompile.constant.pool.ConstantInfo;

/**
 * <pre>
 * ��ConstantLongInfo.java��ʵ���������������еĳ�����
 * </pre>
 * 
 * @author yangbolin Dec 10, 2012 3:39:39 PM
 */
public class ConstantLongInfo extends ConstantInfo {

    /** ��ռ���ֽ��� **/
    private int  byteNum;
    /** ���յ�long��ֵ **/
    private long value;

    public int getByteNum() {
        return byteNum;
    }

    public void setByteNum(int byteNum) {
        this.byteNum = byteNum;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getTagString());
        sb.append("\t");
        sb.append(String.format("%d", this.value));
        return sb.toString();
    }
}
