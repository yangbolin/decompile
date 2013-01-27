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
 * 类DescriptorType.java的实现描述：描述符标识字符含义枚举
 * </pre>
 *  
 * @author yangbolin Jan 27, 2013 2:34:34 PM
 */
public enum DescriptorType {
    /** 基本类型byte **/
    BYTE("B"),
    /** 基本类型char **/
    CHAR("C"),
    /** 基本类型double **/
    DOUBLE("D"),
    /** 基本类型float **/
    FLOAT("F"),
    /** 基本类型int **/
    INT("I"),
    /** 基本类型long **/
    LONG("L"),
    /** 基本类型short **/
    SHORT("S"),
    /** 基本类型boolean **/
    BOOLEAN("Z"),
    /** 特殊类型void **/
    VOID("V"),
    /** 对象类型,如Ljava/lang/Object **/
    OBJECT("L")
    ;
    
    String value;
    
    DescriptorType(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
}
