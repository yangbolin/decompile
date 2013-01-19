/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.constant.pool;

/**
 * 类ConstantInfo.java的实现描述：常量池中数据结构的抽象
 * 
 * @author yangbolin Dec 10, 2012 11:11:34 AM
 */
public abstract class ConstantInfo {

    /** 表示什么类型的常量 **/
    private int    tag;
    /** 常量类型的字符串表示 **/
    private String tagString;
    /** 整个常量的字符串描述 **/
    private String stringDescription;

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }
    
    public String getTagString() {
        return tagString;
    }
    
    public void setTagString(String tagString) {
        this.tagString = tagString;
    }
    
    public String getStringDescription() {
        return stringDescription;
    }
    
    public void setStringDescription(String stringDescription) {
        this.stringDescription = stringDescription;
    }
}
