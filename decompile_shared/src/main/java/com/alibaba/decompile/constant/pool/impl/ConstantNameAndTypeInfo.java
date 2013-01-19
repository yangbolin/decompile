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
 * 类ConstantNameAndTypeInfo.java的实现描述:字段或者方法的部分符号引用
 * </pre>
 * 
 * @author yangbolin Dec 10, 2012 6:56:47 PM
 */
public class ConstantNameAndTypeInfo extends ConstantInfo {

    /** 字段或者方法名常量项索引所占的字节数目 **/
    private int nameIndexByteNum;
    /** 字段或者方法名常量项索引值 **/
    private int nameIndexValue;
    /** 字段或者方法描述符常量项的索引所占的字节数目 **/
    private int descriptorByteNum;
    /** 字段或者方法描述符常量项的索引值 **/
    private int descriptorValue;

    public int getNameIndexByteNum() {
        return nameIndexByteNum;
    }

    public void setNameIndexByteNum(int nameIndexByteNum) {
        this.nameIndexByteNum = nameIndexByteNum;
    }

    public int getNameIndexValue() {
        return nameIndexValue;
    }

    public void setNameIndexValue(int nameIndexValue) {
        this.nameIndexValue = nameIndexValue;
    }

    public int getDescriptorByteNum() {
        return descriptorByteNum;
    }

    public void setDescriptorByteNum(int descriptorByteNum) {
        this.descriptorByteNum = descriptorByteNum;
    }

    public int getDescriptorValue() {
        return descriptorValue;
    }

    public void setDescriptorValue(int descriptorValue) {
        this.descriptorValue = descriptorValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getTagString());
        sb.append("\t");
        sb.append(String.format("#%d:#%d// %s", this.nameIndexValue, this.descriptorValue, this.getStringDescription()));
        return sb.toString();
    }
}
