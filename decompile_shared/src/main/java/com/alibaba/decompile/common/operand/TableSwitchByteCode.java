/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common.operand;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.decompile.common.ByteCode;

/**
 * <pre>
 * 类TableSwitchByteCode.java的实现描述：对应tableswitch字节码指令 
 * 注:
 * 在JAVA代码中,switch语句可以生成tableswitch的字节码，也可以生成
 * lookupswitch的字节码，如果case分支的值是连续的话，生成的就是前者，
 * 如果case分支的值不连续的话，生成的就是后者。
 * </pre>
 * 
 * @author yangbolin Jan 2, 2013 10:02:25 AM
 */
public class TableSwitchByteCode extends ByteCode {

    /** switch语句的default分支对应的相对偏移地址 **/
    private int defaultOffset;

    /** switch语句各个分支的case值的最小值 **/
    private int low;

    /** switch语句各个分支的case值的最大值 **/
    private int high;
    
    /** 各个分支对应的偏移地址 **/
    private List<Integer> offsetList = new ArrayList<Integer>();
    
    public void addOffset(int offset) {
        this.offsetList.add(offset);
    }
    
    public int getDefaultOffset() {
        return defaultOffset;
    }
    
    public void setDefaultOffset(int defaultOffset) {
        this.defaultOffset = defaultOffset;
    }
    
    public int getLow() {
        return low;
    }
    
    public void setLow(int low) {
        this.low = low;
    }
    
    public int getHigh() {
        return high;
    }
    
    public void setHigh(int high) {
        this.high = high;
    }
    
    public List<Integer> getOffsetList() {
        return offsetList;
    }
    
    public void setOffsetList(List<Integer> offsetList) {
        this.offsetList = offsetList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int num = this.high - this.low + 1;
        
        sb.append(String.format("%d:\t%s{ //%d\n", this.getBaseOffset(), this.getSymbol(), num));
        
        for (int i = 0; i < num; ++i) {
            sb.append(String.format("\t%d:%d;\n", this.low + i, this.offsetList.get(i) + this.getBaseOffset()));
        }
        
        sb.append(String.format("\t default:%d }", this.defaultOffset + this.getBaseOffset()));
        
        return sb.toString();
    }
}
