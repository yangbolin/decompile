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
 * ��OperateFieldByteCode.java��ʵ����������Ӧgetstatic,putstatic
 * getfield,putfield���ֽ���
 * </pre>
 * 
 * @author yangbolin Jan 2, 2013 4:06:34 PM
 */
public class OperateFieldByteCode extends ByteCode {

    /** ���������ֶ��ڳ������е����� **/
    private int    fieldIndex;

    /** ���������ֶ���Ϣ���� **/
    private String descriptionString;

    public int getFieldIndex() {
        return fieldIndex;
    }

    public void setFieldIndex(int fieldIndex) {
        this.fieldIndex = fieldIndex;
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

        sb.append(String.format("%d:\t%s\t#%d;", this.getBaseOffset(), this.getDescriptionString(), this.fieldIndex));
        sb.append("\t// ");
        sb.append(this.descriptionString);

        return sb.toString();
    }
}
