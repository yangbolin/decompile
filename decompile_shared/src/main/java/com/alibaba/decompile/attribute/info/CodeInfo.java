/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.attribute.info;

import java.util.ArrayList;
import java.util.List;
import com.alibaba.decompile.attribute.ExceptionsTable;
import com.alibaba.decompile.common.ByteCode;

/**
 * <pre>
 * 类CodeInfo.java的实现描述：使用在方法表中，表示方法的code属性
 * 注意:
 * Code属性的长度是一个u4类型的数值，这个字段写在基类中
 * </pre>
 * 
 * @author yangbolin Dec 13, 2012 1:32:49 PM
 */
public class CodeInfo extends AttributeInfo {

    /**
     * <pre>
     * max_stack代表了操作数栈深度的最大值，在方法执行的任意时刻，
     * 操作数栈都不会超过这个深度值，虚拟机运行的时候需要根据这个
     * 值来分配栈帧中栈的操作深度。
     * </pre>
     */
    private int                   maxStack;

    /**
     * <pre>
     * max_locals代表局部变量所需的存储空间，在这里max_locals的
     * 单位是Slot, Slot是虚拟机为局部变量分配内存所使用的最小单位。
     * </pre>
     */
    private int                   maxLocals;

    /**
     * <pre>
     * code_length代表JAVA程序编译成字节码指令后的长度，code_length
     * 是一个u4类型的长度值，理论上最大值可达到2^32-1,但是虚拟机规范中限
     * 制了一个方法不允许超过65535条字节码指令，如果超过这个限制，javac
     * 就拒绝编译。
     * </pre>
     */
    private int                   codeLength;

    /** code属性的附加属性数目 **/
    private int                   attributesCount;

    /** code属性的附加属性 **/
    private List<AttributeInfo>   attributeInfoList   = new ArrayList<AttributeInfo>();

    /** 异常处理表的数目 **/
    private int                   exceptionsTableLength;
    /**
     * 异常表，如果有athrow这样的字节码就说明有异常表的存在你
     */
    private List<ExceptionsTable> exceptionsTableList = new ArrayList<ExceptionsTable>();

    /** 字节码列表 **/
    private List<ByteCode>        byteCodeList        = new ArrayList<ByteCode>();

    /**
     * <pre>
     * 增加一个字节码
     * </pre>
     * 
     * @param byteCode
     */
    public void addByteCode(ByteCode byteCode) {
        this.byteCodeList.add(byteCode);
    }

    /**
     * <pre>
     * 增加一个异常处理对应表
     * </pre>
     * 
     * @param exceptionsTable
     */
    public void addExceptionsTable(ExceptionsTable exceptionsTable) {
        this.exceptionsTableList.add(exceptionsTable);
    }

    /**
     * <pre>
     * 新增一个code属性的附加属性
     * </pre>
     * 
     * @param attributeInfo
     */
    public void addAttributeInfo(AttributeInfo attributeInfo) {
        this.attributeInfoList.add(attributeInfo);
    }

    public int getMaxStack() {
        return maxStack;
    }

    public void setMaxStack(int maxStack) {
        this.maxStack = maxStack;
    }

    public int getMaxLocals() {
        return maxLocals;
    }

    public void setMaxLocals(int maxLocals) {
        this.maxLocals = maxLocals;
    }

    public int getCodeLength() {
        return codeLength;
    }

    public void setCodeLength(int codeLength) {
        this.codeLength = codeLength;
    }

    public List<ByteCode> getByteCodeList() {
        return byteCodeList;
    }

    public void setByteCodeList(List<ByteCode> byteCodeList) {
        this.byteCodeList = byteCodeList;
    }

    public int getAttributesCount() {
        return attributesCount;
    }

    public void setAttributesCount(int attributesCount) {
        this.attributesCount = attributesCount;
    }

    public List<AttributeInfo> getAttributeInfoList() {
        return attributeInfoList;
    }

    public void setAttributeInfoList(List<AttributeInfo> attributeInfoList) {
        this.attributeInfoList = attributeInfoList;
    }

    public List<ExceptionsTable> getExceptionsTableList() {
        return exceptionsTableList;
    }

    public void setExceptionsTableList(List<ExceptionsTable> exceptionsTableList) {
        this.exceptionsTableList = exceptionsTableList;
    }
    
    public int getExceptionsTableLength() {
        return exceptionsTableLength;
    }
    
    public void setExceptionsTableLength(int exceptionsTableLength) {
        this.exceptionsTableLength = exceptionsTableLength;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("maxLocals:%d maxStacks:%d\n", this.maxLocals, this.maxStack));
        
        for(ByteCode byteCode : byteCodeList) {
            sb.append(byteCode.toString());
            sb.append("\n");
        }
        
        if (this.exceptionsTableLength != 0) {
            sb.append("Exceptions:\n");
            sb.append("from\tto\ttarget\ttype\n");
            for (ExceptionsTable exceptionTable : this.exceptionsTableList) {
                sb.append(exceptionTable.toString());
            }
        }
        
        for (AttributeInfo attributeInfo : this.attributeInfoList) {
            sb.append(attributeInfo.toString());
            sb.append("\n");
        }
        
        return sb.toString();
    }
}
