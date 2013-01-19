/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.attribute.info;

/**
 * <pre>
 * ��ConstantValue.java��ʵ��������ʹ�����ֶα���ʾfinal�ؼ��ֶ���ĳ���ֵ
 * ע��:
 * ������������ʾ�ֶ��Ƿ�����Ϊfinal���ͣ�����ֶα�����Ϊfinal���͵Ļ�����ô�ֶξͻ�
 * ��Ӧ�������е�һ�����泣����������������CONSTANT_Long_info,CONSTANT_Float_info,
 * CONSTANT_Double_info,CONSTANT_Integer_info��CONSTANT_String_info�����е�
 * һ�֣�����ֶ�������final���ԣ���ô��Ӧ��ConstantValueInfo�����Գ����ֶ�һ����2��
 * ��Ϊ��ʾ���Գ��ȵ�һ��u2���͵����ݽṹ
 * </pre>
 * 
 * @author yangbolin Dec 13, 2012 1:35:56 PM
 */
public class ConstantValueInfo extends AttributeInfo {

    /** ��������һ�����泣�������� **/
    private int    constantValueIndex;
    /** �����������泣����Ӧ������ **/
    private String constantValueString;

    public int getConstantValueIndex() {
        return constantValueIndex;
    }

    public void setConstantValueIndex(int constantValueIndex) {
        this.constantValueIndex = constantValueIndex;
    }

    public String getConstantValueString() {
        return constantValueString;
    }

    public void setConstantValueString(String constantValueString) {
        this.constantValueString = constantValueString;
    }
}
