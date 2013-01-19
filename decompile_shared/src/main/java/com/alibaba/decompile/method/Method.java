/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.method;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.decompile.attribute.info.AttributeInfo;
import com.alibaba.decompile.common.MethodAccessFlag;

/**
 * 类Method.java的实现描述：类中方法对应的对象
 * 
 * @author yangbolin Dec 26, 2012 8:34:20 PM
 */
public class Method {

    /** 方法名称索引 **/
    private int                   nameIndex;
    /** 方法名称索引对应的常量字符串 **/
    private String                methodName;
    /** 方法描述符对应的常量字符串 **/
    private String                descriptorName;
    /** 方法描述索引 **/
    private int                   descriptorIndex;
    /** 方法的访问权限集合 **/
    private Set<MethodAccessFlag> accessFlagSet = new HashSet<MethodAccessFlag>();
    /** 方法的属性数目 **/
    private int                   attributeCount;
    /** 方法属性集合 **/
    private Set<AttributeInfo> attributeSet   = new HashSet<AttributeInfo>();
    
    /**
     * <pre>
     * 增加一个方法的访问权限
     * </pre>
     * @param methodAccessFlag
     */
    public void addAccessFlag(MethodAccessFlag methodAccessFlag) {
        this.accessFlagSet.add(methodAccessFlag);
    }
    
    /**
     * <pre>
     * 增加一个方法的属性
     * </pre>
     * @param attributeInfo
     */
    public void addAttributeInfo(AttributeInfo attributeInfo) {
        this.attributeSet.add(attributeInfo);
    }
    
    public int getNameIndex() {
        return nameIndex;
    }
    
    public void setNameIndex(int nameIndex) {
        this.nameIndex = nameIndex;
    }
    
    public String getMethodName() {
        return methodName;
    }
    
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
    
    public String getDescriptorName() {
        return descriptorName;
    }
    
    public void setDescriptorName(String descriptorName) {
        this.descriptorName = descriptorName;
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }
    
    public void setDescriptorIndex(int descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }
    
    public Set<MethodAccessFlag> getAccessFlagSet() {
        return accessFlagSet;
    }
    
    public void setAccessFlagSet(Set<MethodAccessFlag> accessFlagSet) {
        this.accessFlagSet = accessFlagSet;
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
