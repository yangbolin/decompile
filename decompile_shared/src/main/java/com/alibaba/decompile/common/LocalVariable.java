/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common;

/**
 * <pre>
 * ��LocalVariable.java��ʵ�������������ľֲ�����
 * </pre>
 * 
 * @author yangbolin Jan 14, 2013 9:01:34 PM
 */
public class LocalVariable {

    /** �ֲ������������ڿ�ʼ���ֽ���ƫ�������� **/
    private int    startPC;
    /** �ֲ�����������Χ�ĳ��� **/
    private int    length;
    /** �ֲ������������ڳ������е����� **/
    private int    nameIndex;
    /** �ֲ��������������ڳ������е����� **/
    private int    descriptorIndex;
    /** �ֲ����������� **/
    private String name;
    /** �ֲ������������� **/
    private String descriptor;

    public int getStartPC() {
        return startPC;
    }

    public void setStartPC(int startPC) {
        this.startPC = startPC;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(int nameIndex) {
        this.nameIndex = nameIndex;
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(int descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }
}
