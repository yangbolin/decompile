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
 * 类FieldContext.java的实现描述：字段上下文
 * 
 * @author yangbolin Dec 12, 2012 7:40:40 PM
 */
public class FieldsContext extends DecompileContext {

    /** 字段的数目 **/
    private int         fieldCount;
    /** 字段的列表 **/
    private List<Field> fieldList = new ArrayList<Field>();

    /**
     * <pre>
     * 增加一个字段
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
