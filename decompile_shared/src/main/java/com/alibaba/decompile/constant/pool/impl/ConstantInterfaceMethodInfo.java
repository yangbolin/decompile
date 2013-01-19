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
 * ��ConstantInterfaceMethodInfo.java��ʵ���������������еĽӿڷ���
 * </pre>
 * 
 * @author yangbolin Dec 10, 2012 6:14:00 PM
 */
public class ConstantInterfaceMethodInfo extends ConstantInfo {

    /** ���������Ľӿ��ڳ������ж�Ӧ��������ռ���ֽ���Ŀ **/
    private int interfaceIndexByteNum;
    /** ���������ӿ��ڳ������ж�Ӧ������ֵ **/
    private int interfaceIndexValue;
    /** �����������ڳ������ж�Ӧ��������ռ�ݵ��ֽ���Ŀ **/
    private int descriptorByteNum;
    /** �����������ڳ������ж�Ӧ������ֵ **/
    private int descriptorValue;

    public int getInterfaceIndexByteNum() {
        return interfaceIndexByteNum;
    }

    public void setInterfaceIndexByteNum(int interfaceIndexByteNum) {
        this.interfaceIndexByteNum = interfaceIndexByteNum;
    }

    public int getInterfaceIndexValue() {
        return interfaceIndexValue;
    }

    public void setInterfaceIndexValue(int interfaceIndexValue) {
        this.interfaceIndexValue = interfaceIndexValue;
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
        sb.append(String.format("#%d.#%d\t// %s", this.interfaceIndexValue, this.descriptorValue,
                                this.getStringDescription()));
        return sb.toString();
    }
}
