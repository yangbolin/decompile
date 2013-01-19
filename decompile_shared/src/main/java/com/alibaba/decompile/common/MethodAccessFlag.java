/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common;

/**
 * ��MethodAccessFlag.java��ʵ�������������Ȩ�޵�ö��
 * 
 * @author yangbolin Dec 26, 2012 8:35:46 PM
 */
public enum MethodAccessFlag {
    /** �����Ƿ�Ϊpublic **/
    ACC_PUBLIC(0x0001),
    /** �����Ƿ�Ϊprivate **/
    ACC_PRIVATE(0x0002),
    /** �����Ƿ�Ϊprotected **/
    ACC_PROTECTED(0x0004),
    /** �����Ƿ�Ϊstatic **/
    ACC_STATIC(0x0008),
    /** �����Ƿ�Ϊfinal**/
    ACC_FINAL(0x0010),
    /** �����Ƿ�Ϊsynchronized **/
    ACC_SYNCHRONIZED(0x0020),
    /** �����Ƿ����ɱ������������Žӷ��� **/
    ACC_BRIDGE(0x0040),
    /** �����Ƿ���ܲ������� **/
    ACC_VARARGS(0x0080),
    /** �����Ƿ�Ϊnative **/
    ACC_NATIVE(0x0100),
    /** �����Ƿ�Ϊabstract **/
    ACC_ABSTRACT(0x02000),
    /** �����Ƿ�Ϊstrictfp **/
    ACC_STRICT(0x0800),
    /** �����Ƿ�Ϊ�������Զ����ɵ� **/
    ACC_SYNTHETIC(0x1000)
    ;
    
    /** ���ʱ�־��Ӧ��ʮ��������ֵ **/
    private int flagValue;
    
    MethodAccessFlag(int flagValue) {
        this.flagValue = flagValue;
    }
    
    public int getFlagValue() {
        return flagValue;
    }
    
    public void setFlagValue(int flagValue) {
        this.flagValue = flagValue;
    }
}
