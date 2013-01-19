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
 * 类OneByteOperandByteCode.java的实现描述：只有一个操作数的字节码
 * 注意:
 * 这里不需要对操作数所占的字节码数目做区分，字节码操作数解析器有单字节解
 * 析器，双字节解析器，以及四字节解析器，这些解析器返回相同的结果，即只有
 * 一个操作数的字节码
 * </pre>
 * 
 * @author yangbolin Dec 30, 2012 11:14:08 AM
 */
public class OneOperandByteCode extends ByteCode {
    /** 字节码操作数 **/
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
