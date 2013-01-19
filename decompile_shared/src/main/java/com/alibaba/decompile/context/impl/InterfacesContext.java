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

/**
 * 类InterfacesContext.java的实现描述：当前类实现的接口或者当前接口实现的接口上下文
 * 
 * @author yangbolin Dec 11, 2012 4:21:58 PM
 */
public class InterfacesContext extends DecompileContext {
    /** 接口的数目 **/
    private int count;
    /** 接口索引集合 **/
    private List<Integer> indexList = new ArrayList<Integer>();
    /** 接口全限定名称集合 **/
    private List<String> qualifiedNameList = new ArrayList<String>();
    
    public int getCount() {
        return count;
    }
    
    public void setCount(int count) {
        this.count = count;
    }
    
    public List<Integer> getIndexList() {
        return indexList;
    }
    
    public void setIndexList(List<Integer> indexList) {
        this.indexList = indexList;
    }
    
    public List<String> getQualifiedNameList() {
        return qualifiedNameList;
    }
    
    public void setQualifiedNameList(List<String> qualifiedNameList) {
        this.qualifiedNameList = qualifiedNameList;
    }
    
    /**
     * <pre>
     * 在索引列表中增加一个索引值
     * </pre>
     * @param index
     */
    public void addIndex(int index) {
        this.indexList.add(index);
    }
    
    /**
     * <pre>
     * 在全限定名列表中增加一个全限定名称
     * </pre>
     * @param name
     */
    public void addQualifiedName(String name) {
        this.qualifiedNameList.add(name);
    }
}
