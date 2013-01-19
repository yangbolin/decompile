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
 * 类LineNumberTable.java的实现描述：使用在Code属性中，表示JAVA源代码行号与字节码指令之间的对应关系
 * </pre>
 * 
 * @author yangbolin Dec 13, 2012 2:30:00 PM
 */
public class LineNumberTableInfo extends AttributeInfo {

    /** start_pc和line_number之间对应关系的数目 **/
    private int                   lineNumberTableLength;
    /** start_pc和line_number之间的映射关系 **/
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
