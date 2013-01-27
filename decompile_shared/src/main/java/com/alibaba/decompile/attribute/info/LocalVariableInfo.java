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
 * 类LocalVariableInfo.java的实现描述：LocalVariableTable属性用于描述栈帧中
 * 局部变量表中的变量与JAVA源代码中定义的变量之间的关系，它不是运行时必须的属性，默
 * 认也不会生成到class文件中，可以在javac中使用-g:none或-g:vars选项来取消或要求
 * 生成这项信息
 * </pre>
 * 
 * @author yangbolin Jan 13, 2013 8:02:22 PM
 */
public class LocalVariableInfo extends AttributeInfo {

    /** 局部变量的数目 **/
    private int                 localVariableTableLength;
    /** 局部变量列表 **/
    private List<LocalVariable> localVariableList = new ArrayList<LocalVariable>();

    /** 增加一个局部变量 **/
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
