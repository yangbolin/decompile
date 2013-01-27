/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.frame.info;

/**
 * <pre>
 * 类ObjectVariableInfo.java的实现描述：指定验证类型为cpool_index中指定的类型实例
 * </pre>
 * 
 * @author yangbolin Jan 26, 2013 1:48:11 PM
 */
public class ObjectVariableInfo extends VerificationTypeInfo {

    /** 类型在常量池中的索引,对应的常量类型是CONSTANT_Class_info **/
    private int cpoolIndex;

    public int getCpoolIndex() {
        return cpoolIndex;
    }

    public void setCpoolIndex(int cpoolIndex) {
        this.cpoolIndex = cpoolIndex;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
