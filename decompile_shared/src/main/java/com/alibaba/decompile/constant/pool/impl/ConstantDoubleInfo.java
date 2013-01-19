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
 * 类ConstantDoubleInfo.java的实现描述：常量池中的Double型数字
 * </pre>
 * 
 * @author yangbolin Dec 10, 2012 3:53:36 PM
 */
public class ConstantDoubleInfo extends ConstantInfo {

    /** 字节数目 **/
    private int    byteNum;
    /** 最终的value值 **/
    private double value;

    public int getByteNum() {
        return byteNum;
    }

    public void setByteNum(int byteNum) {
        this.byteNum = byteNum;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getTagString());
        sb.append("\t");
        sb.append(String.format("%f", this.value));
        return sb.toString();
    }
}
