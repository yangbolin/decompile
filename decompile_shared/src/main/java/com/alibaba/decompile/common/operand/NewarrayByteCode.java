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
 * ��NewarrayByteCode.java��ʵ����������Ӧnewarray�ֽ���ָ��
 * </pre>
 * 
 * @author yangbolin Jan 6, 2013 8:19:25 PM
 */
public class NewarrayByteCode extends ByteCode {

    /** ��Ҫ�������������͵��ַ������� **/
    private String typeString;

    public String getTypeString() {
        return typeString;
    }

    public void setTypeString(String typeString) {
        this.typeString = typeString;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%d:\t%s %s", this.getBaseOffset(), this.getSymbol(), this.typeString));
       
        return sb.toString();
    }
}
