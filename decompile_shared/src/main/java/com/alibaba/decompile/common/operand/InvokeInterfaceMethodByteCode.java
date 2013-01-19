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
 * ��InvokeInterfaceMethodByteCode.java��ʵ����������Ӧ���ýӿڷ������ֽ���
 * </pre>
 * 
 * @author yangbolin Jan 5, 2013 8:44:08 PM
 */
public class InvokeInterfaceMethodByteCode extends ByteCode {

    /** �����ڳ������е����� **/
    private int    index;

    /**
     * �ֽ����count�ֶΣ����count�ֶ�ռ�������ֽڣ�Ŀǰ�Լ�Ҳû�и������� �ֶεĺ��壬�Ƚ���������˵
     */
    private int    count;

    /** �������ַ��������� **/
    private String descriptionString;

    /**
     * 0�ֶΣ����0�ֶεĻ�����Ҳû��������Ƚ���������˵
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
