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
 * 类ExceptionsTable.java的实现描述：在JAVA代码中如果有try{}catch{}finally{}这样的
 * 代码，就会有异常表出现.
 * 注：
 * 这些字段的含义如下：
 * 如果字节码从第start_pc行到第end_pc行之间(不包含end_pc行)，出现了类型为catch_type或
 * 其子类的异常(catch_type为指向一个CONSTANT_Class_info类型常量的索引)，则转到第
 * handler_pc行继续处理。当catch_type的值为0时，代表任何的异常情况都需要转向到handler_pc
 * 进行处理
 * </pre>
 * 
 * @author yangbolin Jan 13, 2013 3:41:41 PM
 */
public class ExceptionsTable {

    private int    startPC;
    private int    endPC;
    private int    handlerPC;
    private int    catchType;
    /** 异常类型描述符 **/
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
