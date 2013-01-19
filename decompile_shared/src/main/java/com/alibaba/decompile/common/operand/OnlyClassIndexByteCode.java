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
 * 类OnlyClassIndexOperandByteCode.java的实现描述：对应字节码checkcast和instanceof
 * </pre>
 * 
 * @author yangbolin Jan 9, 2013 9:08:46 PM
 */
public class OnlyClassIndexByteCode extends ByteCode {

    /** 类型在常量池中的索引 **/
    private int    index;
    /** 类型的字符串描述 **/
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
        sb.append(String.format("%d:\t%s  #%d //class %s", this.getBaseOffset(), this.getSymbol(), this.index,
                                this.descriptionString));
        return sb.toString();
    }
}
