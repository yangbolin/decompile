/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.method;

/**
 * <pre>
 * 类MethodArgs.java的实现描述：方法参数的相关信息，这些信息都是从方法描述符中获取到
 * </pre>
 * 
 * @author yangbolin Jan 27, 2013 3:52:10 PM
 */
public class MethodArgs {

    /** 参数数目 **/
    private int    num;
    /** 参数类型描述符 **/
    private String typeDescriptor;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTypeDescriptor() {
        return typeDescriptor;
    }

    public void setTypeDescriptor(String typeDescriptor) {
        this.typeDescriptor = typeDescriptor;
    }
}
