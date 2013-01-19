/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common.operand;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.alibaba.decompile.common.ByteCode;

/**
 * <pre>
 * ��LookupSwitchByteCode.java��ʵ����������Ӧ�ֽ���ָ��lookupswitch
 * </pre>
 * 
 * @author yangbolin Jan 2, 2013 2:39:07 PM
 */
public class LookupSwitchByteCode extends ByteCode {

    /** switch����Ӧdefault��֧����תƫ���� **/
    private int                   defaultOffset;
    /** switch�����case��֧����Ŀ��������default��֧ **/
    private int                   braches;
    /** �洢caseֵ����תƫ�Ƶ�ַ��Hash��ϵ **/
    private Map<Integer, Integer> offsetMap = new HashMap<Integer, Integer>();

    /**
     * <pre>
     * ����һ��caseֵ����תƫ������hash��¼
     * </pre>
     * 
     * @param caseValue case��ֵ
     * @param offset ��תƫ�Ƶ�ַ
     */
    public void addOffsetMap(int caseValue, int offset) {
        this.offsetMap.put(caseValue, offset);
    }

    public int getDefaultOffset() {
        return defaultOffset;
    }

    public void setDefaultOffset(int defaultOffset) {
        this.defaultOffset = defaultOffset;
    }

    public int getBraches() {
        return braches;
    }

    public void setBraches(int braches) {
        this.braches = braches;
    }

    public Map<Integer, Integer> getOffsetMap() {
        return offsetMap;
    }

    public void setOffsetMap(Map<Integer, Integer> offsetMap) {
        this.offsetMap = offsetMap;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(String.format("%d:\t%s{ //%d\n", this.getBaseOffset(), this.getSymbol(), this.getBraches()));
        
        Set<Integer> keySet = this.offsetMap.keySet();
        for(Integer key : keySet) {
            sb.append(String.format("\t%d:%d;\n", key, this.offsetMap.get(key) + this.getBaseOffset()));
        }
        
        sb.append(String.format("\tdefault:%d}", this.defaultOffset));
        
        return sb.toString();
    }
}
