/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.context.impl;

import com.alibaba.decompile.context.DecompileContext;

/**
 * ��ClassContext.java��ʵ����������ǰ���Լ���ǰ��ĳ����Ӧ��������
 *  
 * @author yangbolin Dec 11, 2012 1:31:36 PM
 */
public class ClassContext extends DecompileContext {
    /** ��ǰ���ȫ�޶����ڳ������е������� **/
    private int thisClassIndex;
    /** ��ǰ���ȫ�޶��� **/
    private String thisClassQualifiedName;
    /** ��ǰ��ĸ������ڳ������е������� **/
    private int superClassIndex;
    /** ��ǰ��ĸ���ȫ�޶��� **/
    private String superClassQualifiedName;
    
    public int getThisClassIndex() {
        return thisClassIndex;
    }
    
    public void setThisClassIndex(int thisClassIndex) {
        this.thisClassIndex = thisClassIndex;
    }
    
    public String getThisClassQualifiedName() {
        return thisClassQualifiedName;
    }
    
    public void setThisClassQualifiedName(String thisClassQualifiedName) {
        this.thisClassQualifiedName = thisClassQualifiedName;
    }
    
    public int getSuperClassIndex() {
        return superClassIndex;
    }
    
    public void setSuperClassIndex(int superClassIndex) {
        this.superClassIndex = superClassIndex;
    }

    public String getSuperClassQualifiedName() {
        return superClassQualifiedName;
    }

    public void setSuperClassQualifiedName(String superClassQualifiedName) {
        this.superClassQualifiedName = superClassQualifiedName;
    }
}
