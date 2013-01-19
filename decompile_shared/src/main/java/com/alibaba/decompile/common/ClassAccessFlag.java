/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common;

/**
 * 类AccessFlags.java的实现描述：类访问标志的枚举
 * 
 * @author yangbolin Dec 11, 2012 10:12:17 AM
 */
public enum ClassAccessFlag {
    /** 是否为public类型 **/
    ACC_PUBLIC(0x0001),
    /** 是否被声明为final，只有类可以设置这个访问标志 **/
    ACC_FINAL(0x0010),
    /** 是否允许使用invokespecail字节码指令，JDK1.2之后编译出来的类，这个访问标志为真 **/
    ACC_SUPER(0x0020),
    /** 是否是一个接口 **/
    ACC_INTERFACE(0x0200),
    /** 是否是一个抽象类 **/
    ACC_ABSTRACT(0x0400),
    /** 标识这个类并非由用户代码产生 **/
    ACC_SYNTHETIC(0x1000),
    /** 标识这是一个注解 **/
    ACC_ANNOTATION(0x2000),
    /** 标识这是一个枚举 **/
    ACC_ENUM(0x4000);
    
    /** 标志的值 **/
    private int flagValue;
    ClassAccessFlag(int flagValue) {
        this.flagValue = flagValue;
    }
    
    public int getFlagValue() {
        return flagValue;
    }
    
    public void setFlagValue(int flagValue) {
        this.flagValue = flagValue;
    }
}
