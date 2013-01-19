/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.context;

/**
 * ��ByteCodeContext.java��ʵ���������ֽ���������
 * 
 * @author yangbolin Dec 7, 2012 9:22:13 AM
 */
public class ByteCodeContext {

    /** class�ļ����ֽ����� **/
    private byte[]  classByte;
    /** ��ǰҪ������ֽڵ�ָ�� **/
    private int     currentIndex;
    /** �Ƿ�ֹͣ���� **/
    private boolean stop    = false;
    /**
     * ָʾ��ǰ�ֽ����Ƿ��б�wide����,ֻ���ڽ����ֽ����ʱ������� ע��ʹ�ý���֮��һ��Ҫ�ѱ�־��ԭΪfalse
     */
    private boolean hasWide = false;
    
    /**
     * <pre>
     * �ֽ�����ָ����ǰ�ƶ�һ��
     * </pre>
     */
    public void forwardCurrentIndex() {
        ++currentIndex;
    }

    /**
     * <pre>
     * �ֽ�����ָ����ǰ�ƶ�step��
     * </pre>
     * 
     * @param step
     */
    public void forwardCurrentIndexSteps(int step) {
        this.currentIndex += step;
    }

    /**
     * <pre>
     * �ֽ�����ָ������ƶ�
     * </pre>
     */
    public void backCurrentIndex() {
        --currentIndex;
    }

    /**
     * <pre>
     * �ֽ�����ָ������ƶ�step��
     * </pre>
     * 
     * @param step
     */
    public void backwardCurrentIndexSteps(int step) {
        this.currentIndex -= step;
    }

    /**
     * <pre>
     * ��ȡָ����С���ֽ�������
     * ע��:
     * ֮ǰ��ȡָ����С����Ĵ����Ƿ�ɢ�ڸ���������еģ�������һ�δ���ĳ�ȡ����
     * �����������Լ������鷳���ҽ��˵���Լ����ó�ȡ����νOOP�������ݺ���Ϊ�ķ�װ��
     * ����ʵ�ִ���ĸ��ã���ȻOOP����ʵ�ִ���ĸ��ã�Ϊ�β��Ѵ����ȡһ���أ����
     * ������ȡ���������ã����е�Υ��OOP��������
     * </pre>
     * 
     * @param size �����С
     * @return
     */
    public byte[] getSpecifiedByteCodeArray(int size) {
        
        byte[] targetBytes = new byte[size];

        System.arraycopy(this.classByte, this.currentIndex, targetBytes, 0, size);
        this.currentIndex += size;

        return targetBytes;
    }

    public byte[] getClassByte() {
        return classByte;
    }

    public void setClassByte(byte[] classByte) {
        this.classByte = classByte;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public boolean isHasWide() {
        return hasWide;
    }

    public void setHasWide(boolean hasWide) {
        this.hasWide = hasWide;
    }
}
