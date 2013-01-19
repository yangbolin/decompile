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
 * 类InvokeInterfaceMethodByteCode.java的实现描述：对应调用接口方法的字节码
 * </pre>
 * 
 * @author yangbolin Jan 5, 2013 8:44:08 PM
 */
public class InvokeInterfaceMethodByteCode extends ByteCode {

    /** 方法在常量池中的索引 **/
    private int    index;

    /**
     * 字节码的count字段，这个count字段占了两个字节，目前自己也没有搞清楚这个 字段的含义，先解析出来再说
     */
    private int    count;

    /** 方法的字符串描述符 **/
    private String descriptionString;

    /**
     * 0字段，这个0字段的还以我也没搞清楚，先解析出来再说
     */
    private int    zero;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getZero() {
        return zero;
    }

    public void setZero(int zero) {
        this.zero = zero;
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
        sb.append(String.format("%d:\t%s\t#%d %d; //%s", this.getBaseOffset(), this.getSymbol(), this.index,
                                this.count, this.descriptionString));
        return sb.toString();
    }
}
