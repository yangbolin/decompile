/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.constant.pool;

/**
 * <pre>
 * 类ConstantType.java的实现描述：常量池中常量的类型
 * </pre>
 * 
 * @author yangbolin Jan 2, 2013 4:37:03 PM
 */
public enum ConstantType {
    /** 常量池中对应UTF8缩略码的字符串TAG **/
    CONSTANT_UTF8_STR_TAG(1),
    /** 常量池中整型字面量的TAG **/
    CONSTANT_INTEGER_TAG(3),
    /** 常量池中浮点型字面量的TAG **/
    CONSTANT_FLOAT_TAG(4),
    /** 常量池中长整型字面量的TAG **/
    CONSTANT_LONG_TAG(5),
    /** 常量池中双精度浮点型的字面常量TAG **/
    CONSTANT_DOUBLE_TAG(6),
    /** 常量池中类或接口的符号引用TAG **/
    CONSTANT_CLASS_TAG(7),
    /** 常量池中字符串类型字面量TAG **/
    CONSTANT_STRING_TAG(8),
    /** 常量池中字段符号引用TAG **/
    CONSTANT_FIELD_REF_TAG(9),
    /** 常量池中类方法的符号引用TAG **/
    CONSTANT_METHOD_REF_TAG(10),
    /** 常量池中接口方法的符号引用TAG **/
    CONSTANT_INTERFACE_METHOD_REF_TAG(11),
    /** 常量池中字段和方法的部分符号引用TAG **/
    CONSTANT_NAME_ADN_TYPE_TAG(12);

    private int intValue;

    ConstantType(int intValue){
        this.intValue = intValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }
}
