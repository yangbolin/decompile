/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common;

/**
 * <pre>
 * ��DescriptorType.java��ʵ����������������ʶ�ַ�����ö��
 * </pre>
 *  
 * @author yangbolin Jan 27, 2013 2:34:34 PM
 */
public enum DescriptorType {
    /** ��������byte **/
    BYTE("B"),
    /** ��������char **/
    CHAR("C"),
    /** ��������double **/
    DOUBLE("D"),
    /** ��������float **/
    FLOAT("F"),
    /** ��������int **/
    INT("I"),
    /** ��������long **/
    LONG("L"),
    /** ��������short **/
    SHORT("S"),
    /** ��������boolean **/
    BOOLEAN("Z"),
    /** ��������void **/
    VOID("V"),
    /** ��������,��Ljava/lang/Object **/
    OBJECT("L")
    ;
    
    String value;
    
    DescriptorType(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
}
