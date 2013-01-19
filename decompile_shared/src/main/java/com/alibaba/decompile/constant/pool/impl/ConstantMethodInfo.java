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
 * ��ConstantMethodInfo.java��ʵ���������������еķ���
 * </pre>
 * 
 * @author yangbolin Dec 10, 2012 5:25:48 PM
 */
public class ConstantMethodInfo extends ConstantInfo {

    /** �����������ڳ������е�������Ӧ���ֽ��� **/
    private int    classIndexByteNum;
    /** �����������ڳ������е�����ֵ **/
    private int    classIndexValue;
    /** ��������������Ӧ���ֽ���Ŀ **/
    private int    descriptorByteNum;
    /** ������������ֵ **/
    private int    descriptorValue;

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
        sb.append(String.format("#%d.#%d\t// %s", this.classIndexValue, this.descriptorValue,
                                this.getStringDescription()));
        return sb.toString();
    }
}
