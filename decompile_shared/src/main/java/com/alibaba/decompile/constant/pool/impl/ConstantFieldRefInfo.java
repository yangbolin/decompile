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
 * 类ConstantFieldRefInfo.java的实现描述：常量池中的字段
 * </pre>
 * 
 * @author yangbolin Dec 10, 2012 4:44:12 PM
 */
public class ConstantFieldRefInfo extends ConstantInfo {

    /** 字段所属类在常量池中的索引所占的字节数目 **/
    private int classIndexByteNum;
    /** 字段所属类在常量池中对应的索引值 **/
    private int classIndexValue;
    /** 字段描述符在常量池中的索引所占字节数目 **/
    private int descriptorByteNum;
    /** 字段描述符在常量池中对应的索引值 **/
    private int descriptorValue;

    public int getClassIndexByteNum() {
        return classIndexByteNum;
    }

    public void setClassIndexByteNum(int classIndexByteNum) {
        this.classIndexByteNum = classIndexByteNum;
    }

    public int getClassIndexValue() {
        return classIndexValue;
    }

    public void setClassIndexValue(int classIndexValue) {
        this.classIndexValue = classIndexValue;
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
        sb.append(String.format("#%d.#%d\t// %s", this.classIndexValue, this.descriptorValue, this.getStringDescription()));
        
        return sb.toString();
    }
}
