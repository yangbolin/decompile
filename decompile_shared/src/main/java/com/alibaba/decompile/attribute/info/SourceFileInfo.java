/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.attribute.info;

/**
 * ��SourceFile.java��ʵ��������ʹ�������ļ��У���ʾԴ�ļ�����
 * 
 * @author yangbolin Dec 13, 2012 2:36:36 PM
 */
public class SourceFileInfo extends AttributeInfo {

    /** Դ�ļ������ڳ������е����� **/
    private int    sourceFileIndex;
    /** Դ�ļ������� **/
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
