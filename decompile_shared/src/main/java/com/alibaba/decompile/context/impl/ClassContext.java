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
 * 类ClassContext.java的实现描述：当前类以及当前类的超类对应的上下文
 *  
 * @author yangbolin Dec 11, 2012 1:31:36 PM
 */
public class ClassContext extends DecompileContext {
    /** 当前类的全限定名在常量池中的描述符 **/
    private int thisClassIndex;
    /** 当前类的全限定名 **/
    private String thisClassQualifiedName;
    /** 当前类的父类名在常量池中的描述符 **/
    private int superClassIndex;
    /** 当前类的父类全限定名 **/
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
