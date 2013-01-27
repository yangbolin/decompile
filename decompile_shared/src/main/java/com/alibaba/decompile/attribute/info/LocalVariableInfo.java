/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.attribute.info;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.decompile.common.LocalVariable;

/**
 * <pre>
 * ��LocalVariableInfo.java��ʵ��������LocalVariableTable������������ջ֡��
 * �ֲ��������еı�����JAVAԴ�����ж���ı���֮��Ĺ�ϵ������������ʱ��������ԣ�Ĭ
 * ��Ҳ�������ɵ�class�ļ��У�������javac��ʹ��-g:none��-g:varsѡ����ȡ����Ҫ��
 * ����������Ϣ
 * </pre>
 * 
 * @author yangbolin Jan 13, 2013 8:02:22 PM
 */
public class LocalVariableInfo extends AttributeInfo {

    /** �ֲ���������Ŀ **/
    private int                 localVariableTableLength;
    /** �ֲ������б� **/
    private List<LocalVariable> localVariableList = new ArrayList<LocalVariable>();

    /** ����һ���ֲ����� **/
    public void addLocalVariable(LocalVariable localVariable) {
        this.localVariableList.add(localVariable);
    }

    public int getLocalVariableTableLength() {
        return localVariableTableLength;
    }

    public void setLocalVariableTableLength(int localVariableTableLength) {
        this.localVariableTableLength = localVariableTableLength;
    }

    public List<LocalVariable> getLocalVariableList() {
        return localVariableList;
    }

    public void setLocalVariableList(List<LocalVariable> localVariableList) {
        this.localVariableList = localVariableList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LocalVariable:\n");
        for (LocalVariable localVariable : this.localVariableList) {
            sb.append(localVariable.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
