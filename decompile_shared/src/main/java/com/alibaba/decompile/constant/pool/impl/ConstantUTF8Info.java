/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.constant.pool.impl;

import com.alibaba.decompile.constant.pool.ConstantInfo;

/**
 * <pre>
 * ��ConstantUTF8Info.java��ʵ��������UTF8������ַ���
 * </pre>
 * 
 * @author yangbolin Dec 10, 2012 11:13:28 AM
 */
public class ConstantUTF8Info extends ConstantInfo {

    /** UTF8�ַ�����ռ���ֽ���Ŀ **/
    private int    byteNum;
    /** UTF8�ַ�����Ӧ��String **/
    private String utf8String;

    public int getByteNum() {
        return byteNum;
    }

    public void setByteNum(int byteNum) {
        this.byteNum = byteNum;
    }

    public String getUtf8String() {
        return utf8String;
    }

    public void setUtf8String(String utf8String) {
        this.utf8String = utf8String;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getTagString());
        sb.append("\t");
        sb.append(this.getUtf8String());
        return sb.toString();
    }
}
