/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.field;

import java.util.HashSet;
import java.util.Set;
import com.alibaba.decompile.attribute.info.AttributeInfo;
import com.alibaba.decompile.common.FieldAccessFlag;

/**
 * 类Field.java的实现描述：字段数据结构
 * 
 * @author yangbolin Dec 12, 2012 7:43:55 PM
 */
public class Field {

    /** 字段的访问标记 **/
    private int                  accessFlags;
    /** 字段访问标志的集合 **/
    private Set<FieldAccessFlag> accessFlagsSet = new HashSet<FieldAccessFlag>();
    /** 字段的简单名称在常量池中的索引 **/
    private int                  nameIndex;
    /** 字段的简单名称 **/
    private String               fieldName;
    /** 字段描述符在常量池中的索引 **/
    private int                  descriptorIndex;
    /** 字段描述符对应的字符串 **/
    private String               descriptorName;
    /** 字段属性的数目 **/
    private int                  attributeCount;
    /** 字段的属性集合 **/
    private Set<AttributeInfo>   attributeSet   = new HashSet<AttributeInfo>();

    /**
     * <pre>
     * 增加一个字段的访问标志
     * </pre>
     * 
     * @param accessFlag
     */
    public void addAccessFlag(FieldAccessFlag accessFlag) {
        this.accessFlagsSet.add(accessFlag);
    }

    /**
     * <pre>
     * 增加一个字段的属性
     * </pre>
     * 
     * @param attributeInfo
     */
    public void addAttribute(AttributeInfo attributeInfo) {
        this.attributeSet.add(attributeInfo);
    }

    public int getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(int accessFlags) {
        this.accessFlags = accessFlags;
    }

    public Set<FieldAccessFlag> getAccessFlagsSet() {
        return accessFlagsSet;
    }

    public void setAccessFlagsSet(Set<FieldAccessFlag> accessFlagsSet) {
        this.accessFlagsSet = accessFlagsSet;
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(int nameIndex) {
        this.nameIndex = nameIndex;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(int descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }

    public String getDescriptorName() {
        return descriptorName;
    }

    public void setDescriptorName(String descriptorName) {
        this.descriptorName = descriptorName;
    }

    public int getAttributeCount() {
        return attributeCount;
    }

    public void setAttributeCount(int attributeCount) {
        this.attributeCount = attributeCount;
    }

    public Set<AttributeInfo> getAttributeSet() {
        return attributeSet;
    }

    public void setAttributeSet(Set<AttributeInfo> attributeSet) {
        this.attributeSet = attributeSet;
    }
}
