/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.attribute.info;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 类Exceptions.java的实现描述：使用在方法表中，表示方法抛出的异常
 * </pre>
 * 
 * @author yangbolin Dec 13, 2012 2:24:51 PM
 */
public class ExceptionsInfo extends AttributeInfo {

    /** 异常的数目 **/
    private int           numberOfExceptions;
    /** 异常类型在常量池中的索引列表 **/
    private List<Integer> exceptionsIndexList     = new ArrayList<Integer>();
    /** 异常类型的描述列表 **/
    private List<String>  exceptionTypeStringList = new ArrayList<String>();

    /**
     * <pre>
     * 增加一个异常类型的索引
     * </pre>
     * 
     * @param index
     */
    public void addIndex(int index) {
        this.exceptionsIndexList.add(index);
    }

    /**
     * <pre>
     * 增加一个异常类型的字符串
     * </pre>
     * 
     * @param typeString
     */
    public void addTypeString(String typeString) {
        this.exceptionTypeStringList.add(typeString);
    }

    public int getNumberOfExceptions() {
        return numberOfExceptions;
    }

    public void setNumberOfExceptions(int numberOfExceptions) {
        this.numberOfExceptions = numberOfExceptions;
    }

    public List<Integer> getExceptionsIndexList() {
        return exceptionsIndexList;
    }

    public void setExceptionsIndexList(List<Integer> exceptionsIndexList) {
        this.exceptionsIndexList = exceptionsIndexList;
    }

    public List<String> getExceptionTypeStringList() {
        return exceptionTypeStringList;
    }

    public void setExceptionTypeStringList(List<String> exceptionTypeStringList) {
        this.exceptionTypeStringList = exceptionTypeStringList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Exceptions:\n");
        sb.append("[");
        for (String type : this.exceptionTypeStringList) {
            sb.append(String.format(" %s ", type));
        }
        sb.append("]");
        return sb.toString();
    }
}
