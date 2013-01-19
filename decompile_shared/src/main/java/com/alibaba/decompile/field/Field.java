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
 * ��Field.java��ʵ���������ֶ����ݽṹ
 * 
 * @author yangbolin Dec 12, 2012 7:43:55 PM
 */
public class Field {

    /** �ֶεķ��ʱ�� **/
    private int                  accessFlags;
    /** �ֶη��ʱ�־�ļ��� **/
    private Set<FieldAccessFlag> accessFlagsSet = new HashSet<FieldAccessFlag>();
    /** �ֶεļ������ڳ������е����� **/
    private int                  nameIndex;
    /** �ֶεļ����� **/
    private String               fieldName;
    /** �ֶ��������ڳ������е����� **/
    private int                  descriptorIndex;
    /** �ֶ���������Ӧ���ַ��� **/
    private String               descriptorName;
    /** �ֶ����Ե���Ŀ **/
    private int                  attributeCount;
    /** �ֶε����Լ��� **/
    private Set<AttributeInfo>   attributeSet   = new HashSet<AttributeInfo>();

    /**
     * <pre>
     * ����һ���ֶεķ��ʱ�־
     * </pre>
     * 
     * @param accessFlag
     */
    public void addAccessFlag(FieldAccessFlag accessFlag) {
        this.accessFlagsSet.add(accessFlag);
    }

    /**
     * <pre>
     * ����һ���ֶε�����
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
