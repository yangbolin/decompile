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
 * ��ObjectVariableInfo.java��ʵ��������ָ����֤����Ϊcpool_index��ָ��������ʵ��
 * </pre>
 * 
 * @author yangbolin Jan 26, 2013 1:48:11 PM
 */
public class ObjectVariableInfo extends VerificationTypeInfo {

    /** �����ڳ������е�����,��Ӧ�ĳ���������CONSTANT_Class_info **/
    private int cpoolIndex;

    public int getCpoolIndex() {
        return cpoolIndex;
    }

    public void setCpoolIndex(int cpoolIndex) {
        this.cpoolIndex = cpoolIndex;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
