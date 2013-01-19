/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.context.impl;

import java.util.ArrayList;
import java.util.List;
import com.alibaba.decompile.context.DecompileContext;
import com.alibaba.decompile.field.Field;

/**
 * ��FieldContext.java��ʵ���������ֶ�������
 * 
 * @author yangbolin Dec 12, 2012 7:40:40 PM
 */
public class FieldsContext extends DecompileContext {

    /** �ֶε���Ŀ **/
    private int         fieldCount;
    /** �ֶε��б� **/
    private List<Field> fieldList = new ArrayList<Field>();

    /**
     * <pre>
     * ����һ���ֶ�
     * </pre>
     * 
     * @param field
     */
    public void addField(Field field) {
        this.fieldList.add(field);
    }

    public int getFieldCount() {
        return fieldCount;
    }

    public void setFieldCount(int fieldCount) {
        this.fieldCount = fieldCount;
    }

    public List<Field> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
    }
}
