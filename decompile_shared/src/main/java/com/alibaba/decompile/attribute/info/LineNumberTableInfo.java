/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.attribute.info;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * ��LineNumberTable.java��ʵ��������ʹ����Code�����У���ʾJAVAԴ�����к����ֽ���ָ��֮��Ķ�Ӧ��ϵ
 * </pre>
 * 
 * @author yangbolin Dec 13, 2012 2:30:00 PM
 */
public class LineNumberTableInfo extends AttributeInfo {

    /** start_pc��line_number֮���Ӧ��ϵ����Ŀ **/
    private int                   lineNumberTableLength;
    /** start_pc��line_number֮���ӳ���ϵ **/
    private Map<Integer, Integer> pcNumberMap = new HashMap<Integer, Integer>();
    
    public void addPcNumberMap(int pc, int lineNumber) {
        pcNumberMap.put(pc, lineNumber);
    }
    
    public int getLineNumberTableLength() {
        return lineNumberTableLength;
    }
    
    public void setLineNumberTableLength(int lineNumberTableLength) {
        this.lineNumberTableLength = lineNumberTableLength;
    }
    
    public Map<Integer, Integer> getPcNumberMap() {
        return pcNumberMap;
    }
    
    public void setPcNumberMap(Map<Integer, Integer> pcNumberMap) {
        this.pcNumberMap = pcNumberMap;
    }
}
