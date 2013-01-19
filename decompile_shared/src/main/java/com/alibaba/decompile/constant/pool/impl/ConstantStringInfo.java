/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.constant.pool.impl;

import com.alibaba.decompile.constant.pool.ConstantInfo;

/**
 * <pre>
 * ��ConstanStringInfo.java��ʵ���������ַ������泣��
 * </pre>
 * 
 * @author yangbolin Dec 10, 2012 4:20:51 PM
 */
public class ConstantStringInfo extends ConstantInfo {

    /** ������ռ���ֽ��� **/
    private int indexByteNum;
    /** ������ֵ **/
    private int indexValue;

    public int getIndexByteNum() {
        return indexByteNum;
    }

    public void setIndexByteNum(int indexByteNum) {
        this.indexByteNum = indexByteNum;
    }

    public int getIndexValue() {
        return indexValue;
    }

    public void setIndexValue(int indexValue) {
        this.indexValue = indexValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getTagString());
        sb.append("\t");
        sb.append(String.format("#%d;\t//  %s", this.indexValue, this.getStringDescription()));
        return sb.toString();
    }
}
