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
 * 类ConstantFloatInfo.java的实现描述：常量池中的浮点数
 * </pre>
 * 
 * @author yangbolin Dec 10, 2012 3:17:38 PM
 */
public class ConstantFloatInfo extends ConstantInfo {

    /** 浮点数最终的值 **/
    private float value;
    /** 浮点数所占的字节数 **/
    private int   byteNum;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getByteNum() {
        return byteNum;
    }

    public void setByteNum(int byteNum) {
        this.byteNum = byteNum;
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
