/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common.operand;

import com.alibaba.decompile.common.ByteCode;

/**
 * <pre>
 * ��AnewarrayByteCodeOperand.java��ʵ����������Ӧanewarray�ֽ���ָ�� 
 * </pre>
 * 
 * @author yangbolin Jan 9, 2013 7:08:05 PM
 */
public class AnewarrayByteCode extends ByteCode {
    /** ���������ڳ������е����� **/
    private int    index;
    /** �������͵������ַ��� **/
    private String descriptionString;
    
    public int getIndex() {
        return index;
    }
    
    public void setIndex(int index) {
        this.index = index;
    }
    
    public String getDescriptionString() {
        return descriptionString;
    }
    
    public void setDescriptionString(String descriptionString) {
        this.descriptionString = descriptionString;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d:\t%s\t#%d //class %s", this.getBaseOffset(), this.getSymbol(), this.index, this.descriptionString));
        return sb.toString();
    }
}
