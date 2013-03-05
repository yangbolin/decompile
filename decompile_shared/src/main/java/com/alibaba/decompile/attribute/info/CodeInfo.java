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
 * ��CodeInfo.java��ʵ��������ʹ���ڷ������У���ʾ������code����
 * ע��:
 * Code���Եĳ�����һ��u4���͵���ֵ������ֶ�д�ڻ�����
 * </pre>
 * 
 * @author yangbolin Dec 13, 2012 1:32:49 PM
 */
public class CodeInfo extends AttributeInfo {

    /**
     * <pre>
     * max_stack�����˲�����ջ��ȵ����ֵ���ڷ���ִ�е�����ʱ�̣�
     * ������ջ�����ᳬ��������ֵ����������е�ʱ����Ҫ�������
     * ֵ������ջ֡��ջ�Ĳ�����ȡ�
     * </pre>
     */
    private int                   maxStack;

    /**
     * <pre>
     * max_locals����ֲ���������Ĵ洢�ռ䣬������max_locals��
     * ��λ��Slot, Slot�������Ϊ�ֲ����������ڴ���ʹ�õ���С��λ��
     * </pre>
     */
    private int                   maxLocals;

    /**
     * <pre>
     * code_length����JAVA���������ֽ���ָ���ĳ��ȣ�code_length
     * ��һ��u4���͵ĳ���ֵ�����������ֵ�ɴﵽ2^32-1,����������淶����
     * ����һ��������������65535���ֽ���ָ��������������ƣ�javac
     * �;ܾ����롣
     * </pre>
     */
    private int                   codeLength;

    /** code���Եĸ���������Ŀ **/
    private int                   attributesCount;

    /** code���Եĸ������� **/
    private List<AttributeInfo>   attributeInfoList   = new ArrayList<AttributeInfo>();

    /** �쳣��������Ŀ **/
    private int                   exceptionsTableLength;
    /**
     * �쳣�������athrow�������ֽ����˵�����쳣��Ĵ�����
     */
    private List<ExceptionsTable> exceptionsTableList = new ArrayList<ExceptionsTable>();

    /** �ֽ����б� **/
    private List<ByteCode>        byteCodeList        = new ArrayList<ByteCode>();

    /**
     * <pre>
     * ����һ���ֽ���
     * </pre>
     * 
     * @param byteCode
     */
    public void addByteCode(ByteCode byteCode) {
        this.byteCodeList.add(byteCode);
    }

    /**
     * <pre>
     * ����һ���쳣�����Ӧ��
     * </pre>
     * 
     * @param exceptionsTable
     */
    public void addExceptionsTable(ExceptionsTable exceptionsTable) {
        this.exceptionsTableList.add(exceptionsTable);
    }

    /**
     * <pre>
     * ����һ��code���Եĸ�������
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
