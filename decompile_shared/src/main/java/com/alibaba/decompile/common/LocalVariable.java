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
 * 类LocalVariable.java的实现描述：方法的局部变量
 * </pre>
 * 
 * @author yangbolin Jan 14, 2013 9:01:34 PM
 */
public class LocalVariable {

    /** 局部变量生命周期开始的字节码偏移量索引 **/
    private int    startPC;
    /** 局部变量作用域范围的长度 **/
    private int    length;
    /** 局部变量的名称在常量池中的索引 **/
    private int    nameIndex;
    /** 局部变量的描述符在常量池中的索引 **/
    private int    descriptorIndex;
    /** 局部变量的名称 **/
    private String name;
    /** 局部变量的描述符 **/
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
