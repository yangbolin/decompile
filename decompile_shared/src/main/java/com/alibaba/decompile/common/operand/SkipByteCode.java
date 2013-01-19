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
 * 类SkipByteCode.java的实现描述：对应跳转指令的字节码 
 * </pre>
 * 
 * @author yangbolin Jan 1, 2013 5:01:31 PM
 */
public class SkipByteCode extends ByteCode {
    /** 跳转偏移量 **/
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
        sb.append("\t");
        sb.append(this.offset + this.getBaseOffset());
        
        return sb.toString();
    }
}
