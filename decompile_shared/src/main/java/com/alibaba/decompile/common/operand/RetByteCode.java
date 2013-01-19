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
 * 类RetByteCode.java的实现描述：对应ret字节码指令
 * 注:
 * ret指令前面可以使用wide来修饰，如果有wide修饰，表示
 * ret指令的操作数占了两个字节，如果没有wide修饰，表示其
 * 操作数占了一个字节，这里的操作数目前仍然理解为是相对偏
 * 移量
 * </pre>
 * @author yangbolin Jan 2, 2013 9:03:13 AM
 */
public class RetByteCode extends ByteCode {
    /** ret指令的相对偏移量 **/
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
