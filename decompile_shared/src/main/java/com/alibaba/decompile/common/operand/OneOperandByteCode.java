/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common.operand;

import com.alibaba.decompile.common.ByteCode;

/**
 * <pre>
 * ��OneByteOperandByteCode.java��ʵ��������ֻ��һ�����������ֽ���
 * ע��:
 * ���ﲻ��Ҫ�Բ�������ռ���ֽ�����Ŀ�����֣��ֽ���������������е��ֽڽ�
 * ������˫�ֽڽ��������Լ����ֽڽ���������Щ������������ͬ�Ľ������ֻ��
 * һ�����������ֽ���
 * </pre>
 * 
 * @author yangbolin Dec 30, 2012 11:14:08 AM
 */
public class OneOperandByteCode extends ByteCode {
    /** �ֽ�������� **/
    private int operand;
    
    public int getOperand() {
        return operand;
    }
    
    public void setOperand(int operand) {
        this.operand = operand;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d:\t%s %d", this.getBaseOffset(), this.getSymbol(), this.operand));
        return sb.toString();
    }
}
