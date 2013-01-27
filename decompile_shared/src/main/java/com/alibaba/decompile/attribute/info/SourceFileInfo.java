/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.attribute.info;

/**
 * 类SourceFile.java的实现描述：使用在类文件中，表示源文件名称
 * 
 * @author yangbolin Dec 13, 2012 2:36:36 PM
 */
public class SourceFileInfo extends AttributeInfo {

    /** 源文件名称在常量池中的索引 **/
    private int    sourceFileIndex;
    /** 源文件的名称 **/
    private String sourceName;

    public int getSourceFileIndex() {
        return sourceFileIndex;
    }

    public void setSourceFileIndex(int sourceFileIndex) {
        this.sourceFileIndex = sourceFileIndex;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getAttributeName( )+ ":\n");
        sb.append(String.format("SourceFile Name: %s", this.sourceName));
        return sb.toString();
    }
}
