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
 * 类SkipWideByteCode.java的实现描述：对应跳转偏移量是四字节的字节码指令
 * </pre>
 * 
 * @author yangbolin Jan 9, 2013 9:23:26 PM
 */
public class SkipWideByteCode extends ByteCode {

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
        sb.append(String.format("%d:\t%s  %d", this.getBaseOffset(), this.getSymbol(),
                                this.offset + this.getBaseOffset()));
        return sb.toString();
    }
}
