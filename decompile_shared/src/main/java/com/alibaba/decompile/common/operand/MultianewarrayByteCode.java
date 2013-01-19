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
 * ��MultianewarrayByteCode.java��ʵ����������Ӧmultianewarray�ֽ���
 * </pre>
 * 
 * @author yangbolin Jan 9, 2013 7:54:51 PM
 */
public class MultianewarrayByteCode extends ByteCode {

    /** ��ά���������ڳ������е����� **/
    private int    index;
    /** ��ά�������͵��ַ������� **/
    private String descriptionString;
    /** ��ά�����ά�� **/
    private int    dimensions;

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

    public int getDimensions() {
        return dimensions;
    }

    public void setDimensions(int dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d:\t%s  #%d  %d //class %s", this.getBaseOffset(), this.getSymbol(), this.index,
                                this.dimensions, this.getDescriptionString()));
        return sb.toString();
    }
}
