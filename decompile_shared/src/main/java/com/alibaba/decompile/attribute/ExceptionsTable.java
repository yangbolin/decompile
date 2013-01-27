/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.attribute;

/**
 * <pre>
 * ��ExceptionsTable.java��ʵ����������JAVA�����������try{}catch{}finally{}������
 * ���룬�ͻ����쳣�����.
 * ע��
 * ��Щ�ֶεĺ������£�
 * ����ֽ���ӵ�start_pc�е���end_pc��֮��(������end_pc��)������������Ϊcatch_type��
 * ��������쳣(catch_typeΪָ��һ��CONSTANT_Class_info���ͳ���������)����ת����
 * handler_pc�м���������catch_type��ֵΪ0ʱ�������κε��쳣�������Ҫת��handler_pc
 * ���д���
 * </pre>
 * 
 * @author yangbolin Jan 13, 2013 3:41:41 PM
 */
public class ExceptionsTable {

    private int    startPC;
    private int    endPC;
    private int    handlerPC;
    private int    catchType;
    /** �쳣���������� **/
    private String catchTypeString;

    public int getStartPC() {
        return startPC;
    }

    public void setStartPC(int startPC) {
        this.startPC = startPC;
    }

    public int getEndPC() {
        return endPC;
    }

    public void setEndPC(int endPC) {
        this.endPC = endPC;
    }

    public int getHandlerPC() {
        return handlerPC;
    }

    public void setHandlerPC(int handlerPC) {
        this.handlerPC = handlerPC;
    }

    public int getCatchType() {
        return catchType;
    }

    public void setCatchType(int catchType) {
        this.catchType = catchType;
    }
    
    public String getCatchTypeString() {
        return catchTypeString;
    }
    
    public void setCatchTypeString(String catchTypeString) {
        this.catchTypeString = catchTypeString;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d\t%d\t%d\t%s\n", this.startPC, this.endPC, this.handlerPC, this.catchTypeString));
        return sb.toString();
    }
}
