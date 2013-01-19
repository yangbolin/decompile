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
 * ��IincByteCode.java��ʵ�������������ֽ���ָ��iinc
 * ע:
 * ������ֵconstbyte�ӵ�indexbyteָ����int���͵ľֲ���
 * ���С�
 * </pre>
 * 
 * @author yangbolin Dec 30, 2012 11:06:25 AM
 */
public class IincByteCode extends ByteCode {

    /** ָ���ֲ����������� **/
    private int index;
    /** ��Ҫ���ӵĳ���ֵ **/
    private int constValue;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getConstValue() {
        return constValue;
    }

    public void setConstValue(int constValue) {
        this.constValue = constValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(String.format("%d:\t%s", this.getBaseOffset(), this.getSymbol()));
        if (this.isHasWide()) {
            sb.append("_w");
        }

        sb.append("\t");
        sb.append(String.format("#%d %d", this.index, this.constValue));

        return sb.toString();
    }
}
