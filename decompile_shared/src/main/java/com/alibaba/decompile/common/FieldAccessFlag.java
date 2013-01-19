/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common;

/**
 * ��FieldAccessFlags.java��ʵ���������ֶη��ʱ�־ö��
 * 
 * @author yangbolin Dec 12, 2012 8:15:34 PM
 */
public enum FieldAccessFlag {
    /** �ֶ��Ƿ�public **/
    ACC_PUBLIC(0x0001),
    /** �ֶ��Ƿ�private **/
    ACC_PRIVATE(0x0002),
    /** �ֶ��Ƿ�protected **/
    ACC_PROTECTED(0x0004),
    /** �ֶ��Ƿ�static **/
    ACC_STATIC(0x0008),
    /** �ֶ��Ƿ�final **/
    ACC_FINAL(0x0010),
    /** �ֶ��Ƿ���volatile **/
    ACC_VOLATILE(0x0040),
    /** �ֶ��Ƿ���transient **/
    ACC_TRANSIENT(0x0080),
    /** �ֶ��Ƿ��ɱ������Զ����� **/
    ACC_SYNTHETIC(0x1000),
    /** �ֶ��Ƿ���ö�� **/
    ACC_ENUM(0x4000);

    /** ���ʱ�־��Ӧ��16������ֵ **/
    private int flagValue;

    FieldAccessFlag(int flagValue){
        this.flagValue = flagValue;
    }

    public int getFlagValue() {
        return flagValue;
    }

    public void setFlagValue(int flagValue) {
        this.flagValue = flagValue;
    }
}
