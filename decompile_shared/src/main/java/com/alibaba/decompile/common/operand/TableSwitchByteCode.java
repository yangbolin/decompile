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
 * ��TableSwitchByteCode.java��ʵ����������Ӧtableswitch�ֽ���ָ�� 
 * ע:
 * ��JAVA������,switch����������tableswitch���ֽ��룬Ҳ��������
 * lookupswitch���ֽ��룬���case��֧��ֵ�������Ļ������ɵľ���ǰ�ߣ�
 * ���case��֧��ֵ�������Ļ������ɵľ��Ǻ��ߡ�
 * </pre>
 * 
 * @author yangbolin Jan 2, 2013 10:02:25 AM
 */
public class TableSwitchByteCode extends ByteCode {

    /** switch����default��֧��Ӧ�����ƫ�Ƶ�ַ **/
    private int defaultOffset;

    /** switch��������֧��caseֵ����Сֵ **/
    private int low;

    /** switch��������֧��caseֵ�����ֵ **/
    private int high;
    
    /** ������֧��Ӧ��ƫ�Ƶ�ַ **/
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
