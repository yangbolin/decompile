/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.attribute.info;

/**
 * 类AttributeInfo.java的实现描述：属性的抽象类
 * 
 * @author yangbolin Dec 12, 2012 7:46:55 PM
 */
public abstract class AttributeInfo {

    /** 属性名称在常量池中的索引 **/
    private int    attributeNameIndex;
    /** 属性值的长度 **/
    private int    attributeLength;
    /** 属性的名称 **/
    private String attributeName;

    public int getAttributeNameIndex() {
        return attributeNameIndex;
    }

    public void setAttributeNameIndex(int attributeNameIndex) {
        this.attributeNameIndex = attributeNameIndex;
    }

    public int getAttributeLength() {
        return attributeLength;
    }

    public void setAttributeLength(int attributeLength) {
        this.attributeLength = attributeLength;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }
}
