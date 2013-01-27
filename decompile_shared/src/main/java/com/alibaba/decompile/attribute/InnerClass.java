/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.attribute;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.decompile.common.ClassAccessFlag;

/**
 * <pre>
 * ��InnerClasses.java��ʵ���������ڲ���
 * </pre>
 * 
 * @author yangbolin Jan 27, 2013 5:32:47 PM
 */
public class InnerClass {

    /** �ڲ���ȫ�޶������ڳ������е����� **/
    private int                  innerClassIndex;
    /** �ڲ���ȫ�޶����� **/
    private String               innerClassName;
    /** �ⲿ��ȫ�޶������ڳ������е����� **/
    private int                  outerClassIndex;
    /** �ⲿ��ȫ�޶����� **/
    private String               outerClassName;

    private Set<ClassAccessFlag> accessSet = new HashSet<ClassAccessFlag>();

    public void addAccessFlag(ClassAccessFlag flag) {
        this.accessSet.add(flag);
    }

    public int getInnerClassIndex() {
        return innerClassIndex;
    }

    public void setInnerClassIndex(int innerClassIndex) {
        this.innerClassIndex = innerClassIndex;
    }

    public String getInnerClassName() {
        return innerClassName;
    }

    public void setInnerClassName(String innerClassName) {
        this.innerClassName = innerClassName;
    }

    public int getOuterClassIndex() {
        return outerClassIndex;
    }

    public void setOuterClassIndex(int outerClassIndex) {
        this.outerClassIndex = outerClassIndex;
    }

    public String getOuterClassName() {
        return outerClassName;
    }

    public void setOuterClassName(String outerClassName) {
        this.outerClassName = outerClassName;
    }

    public Set<ClassAccessFlag> getAccessSet() {
        return accessSet;
    }

    public void setAccessSet(Set<ClassAccessFlag> accessSet) {
        this.accessSet = accessSet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("InnerClass: %s #%d\n", this.innerClassIndex, this.innerClassName));
        sb.append(String.format("OuterClass: %s #%d\n", this.outerClassIndex, this.innerClassName));
        
        sb.append("Access Flag:\n ");
        for (ClassAccessFlag flag : this.accessSet) {
            sb.append(flag + " ");
        }
        
        return sb.toString();
    }
}
