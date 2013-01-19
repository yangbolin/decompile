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
 * ��RetByteCode.java��ʵ����������Ӧret�ֽ���ָ��
 * ע:
 * retָ��ǰ�����ʹ��wide�����Σ������wide���Σ���ʾ
 * retָ��Ĳ�����ռ�������ֽڣ����û��wide���Σ���ʾ��
 * ������ռ��һ���ֽڣ�����Ĳ�����Ŀǰ��Ȼ���Ϊ�����ƫ
 * ����
 * </pre>
 * @author yangbolin Jan 2, 2013 9:03:13 AM
 */
public class RetByteCode extends ByteCode {
    /** retָ������ƫ���� **/
    private int offset;
    
    public int getOffset() {
        return offset;
    }
    
    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(String.format("%d:\t%s", this.getBaseOffset(), this.getSymbol()));
        if (this.isHasWide()) {
            sb.append("_w");
        }
        
        sb.append("\t");
        sb.append(this.offset + this.getBaseOffset());
        
        return sb.toString();
    }
}
