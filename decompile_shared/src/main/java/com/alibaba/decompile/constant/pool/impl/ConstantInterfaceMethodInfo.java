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
 * 类ConstantInterfaceMethodInfo.java的实现描述：常量池中的接口方法
 * </pre>
 * 
 * @author yangbolin Dec 10, 2012 6:14:00 PM
 */
public class ConstantInterfaceMethodInfo extends ConstantInfo {

    /** 方法所属的接口在常量池中对应的索引所占的字节数目 **/
    private int interfaceIndexByteNum;
    /** 方法所属接口在常量池中对应的索引值 **/
    private int interfaceIndexValue;
    /** 方法描述符在常量池中对应的索引所占据的字节数目 **/
    private int descriptorByteNum;
    /** 方法描述符在常量池中对应的索引值 **/
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
