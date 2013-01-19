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
 * 类InvokeMethodByteCode.java的实现描述：对应调用类中方法的字节码
 * </pre>
 * 
 * @author yangbolin Jan 5, 2013 8:21:30 PM
 */
public class InvokeMethodByteCode extends ByteCode {

    /** 方法在常量池中的索引 **/
    private int    index;
    /** 方法的描述 **/
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
        sb.append(String.format("%d:\t%s\t #%d; // %s", this.getBaseOffset(), this.getSymbol(), this.index,
                                this.getDescriptionString()));

        return sb.toString();
    }
}
