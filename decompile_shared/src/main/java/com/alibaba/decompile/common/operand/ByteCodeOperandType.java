/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common.operand;

/**
 * <pre>
 * ��ByteCodeOperandType.java��ʵ���������ֽ�������������� 
 * ע:
 * �ֽ���ָ��˵���ο� http://www.blogjava.net/DLevin/archive/2011/09/13/358497.html
 * �����ǹٷ��ĵ� http://docs.oracle.com/javase/specs/jvms/se7/html/jvms-6.html
 * </pre>
 * 
 * @author yangbolin Dec 30, 2012 9:50:22 AM
 */
public enum ByteCodeOperandType {
    /** û�в����� **/
    NONE(0),
    /** �ֽ����е�store��loadָ�� **/
    SPECIAL_STORE_LOAD(1),
    /** ��Ӧiinc�ֽ���ָ�� **/
    SPECIAL_IINC(2),
    /** ��Ӧ�ֽ�����תָ�� **/
    SPECIAL_SKIP(3),
    /** ��Ӧret�ֽ���ָ�� **/
    SPECIAL_RET(4),
    /** ��Ӧtableswitch�ֽ���ָ�� **/
    SPECIAL_TABLESWITCH(5),
    /** ��Ӧlookupswitch�ֽ���ָ�� **/
    SPECIAL_LOOKUPSWITCH(6),
    /** ��Ӧ�����ֶε��ֽ��� **/
    SPECIAL_OPERATEFIELD(7),
    /** ��Ӧ�������з������ֽ��� **/
    SPECIAL_INVOKE_METHOD(8),
    /** ��Ӧ���ýӿ��з������ֽ��� **/
    SPECIAL_INVOKE_INTERFACE_METHOD(9),
    /** ��Ӧnew�ֽ��� **/
    SPECIAL_NEW(10),
    /** ��Ӧnewarray�ֽ��� **/
    SPECIAL_NEWARRAY(11),
    /** ��Ӧanewarray�ֽ��� **/
    SPECIAL_ANEWARRAY(12),
    /** ��Ӧmultianewarray�ֽ��� **/
    SPECIAL_MULTIANEWARRAY(13),
    /** ��Ӧֻ��һ�������������������ֽ��� **/
    SPECAIL_ONLYCLASSINDEX(14),
    /** ��Ӧ��תƫ������4���ֽڵ��ֽ��� **/
    SPECIAL_SKIPWIDEBYTE(15),
    ;
    
    int intValue;
    
    ByteCodeOperandType(int value) {
        this.intValue = value;
    }
    
    public int getIntValue() {
        return intValue;
    }
    
    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }
}
