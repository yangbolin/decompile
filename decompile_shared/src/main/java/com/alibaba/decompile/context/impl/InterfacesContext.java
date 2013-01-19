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
 * ��InterfacesContext.java��ʵ����������ǰ��ʵ�ֵĽӿڻ��ߵ�ǰ�ӿ�ʵ�ֵĽӿ�������
 * 
 * @author yangbolin Dec 11, 2012 4:21:58 PM
 */
public class InterfacesContext extends DecompileContext {
    /** �ӿڵ���Ŀ **/
    private int count;
    /** �ӿ��������� **/
    private List<Integer> indexList = new ArrayList<Integer>();
    /** �ӿ�ȫ�޶����Ƽ��� **/
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
     * �������б�������һ������ֵ
     * </pre>
     * @param index
     */
    public void addIndex(int index) {
        this.indexList.add(index);
    }
    
    /**
     * <pre>
     * ��ȫ�޶����б�������һ��ȫ�޶�����
     * </pre>
     * @param name
     */
    public void addQualifiedName(String name) {
        this.qualifiedNameList.add(name);
    }
}
