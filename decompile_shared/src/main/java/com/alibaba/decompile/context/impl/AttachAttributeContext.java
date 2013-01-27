/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.context.impl;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.decompile.attribute.info.AttributeInfo;
import com.alibaba.decompile.context.DecompileContext;

/**
 * <pre>
 * 类AttachAttributeContext.java的实现描述：附加属性上下文
 * </pre>
 * 
 * @author yangbolin Jan 27, 2013 5:09:03 PM
 */
public class AttachAttributeContext extends DecompileContext {

    private int                 count;
    private List<AttributeInfo> infoList = new ArrayList<AttributeInfo>();

    public void addAttributeInfo(AttributeInfo attributeInfo) {
        this.infoList.add(attributeInfo);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<AttributeInfo> getInfoList() {
        return infoList;
    }

    public void setInfoList(List<AttributeInfo> infoList) {
        this.infoList = infoList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (AttributeInfo attributeInfo : infoList) {
            sb.append(attributeInfo.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
