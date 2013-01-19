/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common;

/**
 * ��AccessFlags.java��ʵ������������ʱ�־��ö��
 * 
 * @author yangbolin Dec 11, 2012 10:12:17 AM
 */
public enum ClassAccessFlag {
    /** �Ƿ�Ϊpublic���� **/
    ACC_PUBLIC(0x0001),
    /** �Ƿ�����Ϊfinal��ֻ�����������������ʱ�־ **/
    ACC_FINAL(0x0010),
    /** �Ƿ�����ʹ��invokespecail�ֽ���ָ�JDK1.2֮�����������࣬������ʱ�־Ϊ�� **/
    ACC_SUPER(0x0020),
    /** �Ƿ���һ���ӿ� **/
    ACC_INTERFACE(0x0200),
    /** �Ƿ���һ�������� **/
    ACC_ABSTRACT(0x0400),
    /** ��ʶ����ಢ�����û�������� **/
    ACC_SYNTHETIC(0x1000),
    /** ��ʶ����һ��ע�� **/
    ACC_ANNOTATION(0x2000),
    /** ��ʶ����һ��ö�� **/
    ACC_ENUM(0x4000);
    
    /** ��־��ֵ **/
    private int flagValue;
    ClassAccessFlag(int flagValue) {
        this.flagValue = flagValue;
    }
    
    public int getFlagValue() {
        return flagValue;
    }
    
    public void setFlagValue(int flagValue) {
        this.flagValue = flagValue;
    }
}
