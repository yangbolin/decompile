/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common.operand;

/**
 * <pre>
 * 类ByteCodeOperandType.java的实现描述：字节码操作数的类型 
 * 注:
 * 字节码指令说明参考 http://www.blogjava.net/DLevin/archive/2011/09/13/358497.html
 * 这里是官方文档 http://docs.oracle.com/javase/specs/jvms/se7/html/jvms-6.html
 * </pre>
 * 
 * @author yangbolin Dec 30, 2012 9:50:22 AM
 */
public enum ByteCodeOperandType {
    /** 没有操作数 **/
    NONE(0),
    /** 字节码中的store和load指令 **/
    SPECIAL_STORE_LOAD(1),
    /** 对应iinc字节码指令 **/
    SPECIAL_IINC(2),
    /** 对应字节码跳转指令 **/
    SPECIAL_SKIP(3),
    /** 对应ret字节码指令 **/
    SPECIAL_RET(4),
    /** 对应tableswitch字节码指令 **/
    SPECIAL_TABLESWITCH(5),
    /** 对应lookupswitch字节码指令 **/
    SPECIAL_LOOKUPSWITCH(6),
    /** 对应操作字段的字节码 **/
    SPECIAL_OPERATEFIELD(7),
    /** 对应调用类中方法的字节码 **/
    SPECIAL_INVOKE_METHOD(8),
    /** 对应调用接口中方法的字节码 **/
    SPECIAL_INVOKE_INTERFACE_METHOD(9),
    /** 对应new字节码 **/
    SPECIAL_NEW(10),
    /** 对应newarray字节码 **/
    SPECIAL_NEWARRAY(11),
    /** 对应anewarray字节码 **/
    SPECIAL_ANEWARRAY(12),
    /** 对应multianewarray字节码 **/
    SPECIAL_MULTIANEWARRAY(13),
    /** 对应只有一个类型索引操作数的字节码 **/
    SPECAIL_ONLYCLASSINDEX(14),
    /** 对应跳转偏移量是4个字节的字节码 **/
    SPECIAL_SKIPWIDEBYTE(15),
    ;
    
    int intValue;
    
    ByteCodeOperandType(int value) {
        this.intValue = value;
    }
    
    public int getIntValue() {
        return intValue;
    }
    
    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }
}
