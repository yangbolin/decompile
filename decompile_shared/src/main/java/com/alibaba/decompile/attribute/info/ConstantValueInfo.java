/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.attribute.info;

/**
 * <pre>
 * 类ConstantValue.java的实现描述：使用在字段表，表示final关键字定义的常量值
 * 注意:
 * 该属性用来表示字段是否被声明为final类型，如果字段被设置为final类型的话，那么字段就会
 * 对应常量池中的一个字面常量，字面量可以是CONSTANT_Long_info,CONSTANT_Float_info,
 * CONSTANT_Double_info,CONSTANT_Integer_info和CONSTANT_String_info常量中的
 * 一种，如果字段有设置final属性，那么对应的ConstantValueInfo中属性长度字段一定是2，
 * 因为表示属性长度的一个u2类型的数据结构
 * </pre>
 * 
 * @author yangbolin Dec 13, 2012 1:35:56 PM
 */
public class ConstantValueInfo extends AttributeInfo {

    /** 常量池中一个字面常量的索引 **/
    private int    constantValueIndex;
    /** 常量池中字面常量对应的索引 **/
    private String constantValueString;

    public int getConstantValueIndex() {
        return constantValueIndex;
    }

    public void setConstantValueIndex(int constantValueIndex) {
        this.constantValueIndex = constantValueIndex;
    }

    public String getConstantValueString() {
        return constantValueString;
    }

    public void setConstantValueString(String constantValueString) {
        this.constantValueString = constantValueString;
    }
}
