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
 * 类ByteCodeWithSimpleOperand.java的实现描述：istore,iload, dstore,dload, 
 * fstore,fload, astore,aload,lstore,lload等字节码指令
 * </pre>
 * 
 * @author yangbolin Dec 30, 2012 9:35:27 AM
 */
public class StoreLoadByteCode extends ByteCode {

    /** 操作数 **/
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
        
        sb.append(String.format("%d:\t%s", this.getBaseOffset(), this.getSymbol()));
        
        if(this.isHasWide()) {
            sb.append("_w");
        }
        
        sb.append("\t#");
        sb.append(this.operand);
        return sb.toString();
    }
}
