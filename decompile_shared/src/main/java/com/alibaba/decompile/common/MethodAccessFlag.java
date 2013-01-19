/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common;

/**
 * 类MethodAccessFlag.java的实现描述：类访问权限的枚举
 * 
 * @author yangbolin Dec 26, 2012 8:35:46 PM
 */
public enum MethodAccessFlag {
    /** 方法是否为public **/
    ACC_PUBLIC(0x0001),
    /** 方法是否为private **/
    ACC_PRIVATE(0x0002),
    /** 方法是否为protected **/
    ACC_PROTECTED(0x0004),
    /** 方法是否为static **/
    ACC_STATIC(0x0008),
    /** 方法是否为final**/
    ACC_FINAL(0x0010),
    /** 方法是否为synchronized **/
    ACC_SYNCHRONIZED(0x0020),
    /** 方法是否是由编译器产生的桥接方法 **/
    ACC_BRIDGE(0x0040),
    /** 方法是否接受不定参数 **/
    ACC_VARARGS(0x0080),
    /** 方法是否为native **/
    ACC_NATIVE(0x0100),
    /** 方法是否为abstract **/
    ACC_ABSTRACT(0x02000),
    /** 方法是否为strictfp **/
    ACC_STRICT(0x0800),
    /** 方法是否为编译器自动生成的 **/
    ACC_SYNTHETIC(0x1000)
    ;
    
    /** 访问标志对应的十六进制数值 **/
    private int flagValue;
    
    MethodAccessFlag(int flagValue) {
        this.flagValue = flagValue;
    }
    
    public int getFlagValue() {
        return flagValue;
    }
    
    public void setFlagValue(int flagValue) {
        this.flagValue = flagValue;
    }
}
