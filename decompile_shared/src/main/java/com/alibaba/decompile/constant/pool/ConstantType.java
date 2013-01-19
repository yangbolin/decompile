/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.constant.pool;

/**
 * <pre>
 * ��ConstantType.java��ʵ���������������г���������
 * </pre>
 * 
 * @author yangbolin Jan 2, 2013 4:37:03 PM
 */
public enum ConstantType {
    /** �������ж�ӦUTF8��������ַ���TAG **/
    CONSTANT_UTF8_STR_TAG(1),
    /** ��������������������TAG **/
    CONSTANT_INTEGER_TAG(3),
    /** �������и�������������TAG **/
    CONSTANT_FLOAT_TAG(4),
    /** �������г�������������TAG **/
    CONSTANT_LONG_TAG(5),
    /** ��������˫���ȸ����͵����泣��TAG **/
    CONSTANT_DOUBLE_TAG(6),
    /** �����������ӿڵķ�������TAG **/
    CONSTANT_CLASS_TAG(7),
    /** ���������ַ�������������TAG **/
    CONSTANT_STRING_TAG(8),
    /** ���������ֶη�������TAG **/
    CONSTANT_FIELD_REF_TAG(9),
    /** ���������෽���ķ�������TAG **/
    CONSTANT_METHOD_REF_TAG(10),
    /** �������нӿڷ����ķ�������TAG **/
    CONSTANT_INTERFACE_METHOD_REF_TAG(11),
    /** ���������ֶκͷ����Ĳ��ַ�������TAG **/
    CONSTANT_NAME_ADN_TYPE_TAG(12);

    private int intValue;

    ConstantType(int intValue){
        this.intValue = intValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }
}
