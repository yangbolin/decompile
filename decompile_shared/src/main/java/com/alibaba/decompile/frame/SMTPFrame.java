/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.frame;

/**
 * <pre>
 * ��SMTPFrame.java��ʵ��������ÿ��frame��ͬ���Եĳ���
 * </pre>
 * 
 * @author yangbolin Jan 25, 2013 7:16:14 PM
 */
public class SMTPFrame {

    /** frame������ **/
    private int type;
    /** ƫ���� **/
    private int offsetDelta;
    /** ���� **/
    private String name;
    
    public int getType() {
        return type;
    }
    
    public void setType(int type) {
        this.type = type;
    }
    
    public int getOffsetDelta() {
        return offsetDelta;
    }
    
    public void setOffsetDelta(int offsetDelta) {
        this.offsetDelta = offsetDelta;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(" frame_type = %d /* %s */", this.type, this.name));
        sb.append(String.format("\toffsetDelta = %d", this.offsetDelta));
        return sb.toString();
    }
}
