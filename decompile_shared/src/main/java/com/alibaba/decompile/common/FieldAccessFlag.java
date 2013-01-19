/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common;

/**
 * 类FieldAccessFlags.java的实现描述：字段访问标志枚举
 * 
 * @author yangbolin Dec 12, 2012 8:15:34 PM
 */
public enum FieldAccessFlag {
    /** 字段是否public **/
    ACC_PUBLIC(0x0001),
    /** 字段是否private **/
    ACC_PRIVATE(0x0002),
    /** 字段是否protected **/
    ACC_PROTECTED(0x0004),
    /** 字段是否static **/
    ACC_STATIC(0x0008),
    /** 字段是否final **/
    ACC_FINAL(0x0010),
    /** 字段是否是volatile **/
    ACC_VOLATILE(0x0040),
    /** 字段是否是transient **/
    ACC_TRANSIENT(0x0080),
    /** 字段是否由编译器自动产生 **/
    ACC_SYNTHETIC(0x1000),
    /** 字段是否是枚举 **/
    ACC_ENUM(0x4000);

    /** 访问标志对应的16进制数值 **/
    private int flagValue;

    FieldAccessFlag(int flagValue){
        this.flagValue = flagValue;
    }

    public int getFlagValue() {
        return flagValue;
    }

    public void setFlagValue(int flagValue) {
        this.flagValue = flagValue;
    }
}
