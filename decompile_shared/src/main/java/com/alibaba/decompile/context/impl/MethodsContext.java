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
import com.alibaba.decompile.method.Method;

/**
 * ��MethodsContext.java��ʵ�����������з������ϵ�������
 * 
 * @author yangbolin Dec 26, 2012 8:32:08 PM
 */
public class MethodsContext extends DecompileContext{
    /** ��������Ŀ **/
    private int methodsCount;
    
    /** �����б� **/
    private List<Method> methodList = new ArrayList<Method>();
    
    /** ����һ������ **/
    public void addMethod(Method method) {
        this.methodList.add(method);
    }
    
    public int getMemthodsCount() {
        return methodsCount;
    }
    
    public void setMemthodsCount(int methodsCount) {
        this.methodsCount = methodsCount;
    }
    
    public List<Method> getMethodList() {
        return methodList;
    }
    
    public void setMethodList(List<Method> methodList) {
        this.methodList = methodList;
    }
}
