/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.frame.info;

/**
 * <pre>
 * ��UninitializedVariableInfo.java��ʵ��������ָ����֤����Ϊuninitialized��
 * offset��¼�����ڴ���ʵ����newָ���ƫ������
 * 
 * ע:
 * The offset item indicates the offset of the new instruction that created
 * the object being stored in the location.
 * </pre>
 * 
 * @author yangbolin Jan 26, 2013 1:59:58 PM
 */
public class UninitializedVariableInfo extends VerificationTypeInfo {
   
    private int offset;
    
    public int getOffset() {
        return offset;
    }
    
    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
