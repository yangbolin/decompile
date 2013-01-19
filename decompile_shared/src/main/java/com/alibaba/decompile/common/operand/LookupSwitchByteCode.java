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
 * 类LookupSwitchByteCode.java的实现描述：对应字节码指令lookupswitch
 * </pre>
 * 
 * @author yangbolin Jan 2, 2013 2:39:07 PM
 */
public class LookupSwitchByteCode extends ByteCode {

    /** switch语句对应default分支的跳转偏移量 **/
    private int                   defaultOffset;
    /** switch语句中case分支的数目，不包括default分支 **/
    private int                   braches;
    /** 存储case值和跳转偏移地址的Hash关系 **/
    private Map<Integer, Integer> offsetMap = new HashMap<Integer, Integer>();

    /**
     * <pre>
     * 新增一条case值和跳转偏移量的hash记录
     * </pre>
     * 
     * @param caseValue case的值
     * @param offset 跳转偏移地址
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
