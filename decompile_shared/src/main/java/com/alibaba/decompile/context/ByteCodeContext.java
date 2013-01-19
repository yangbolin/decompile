/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.context;

/**
 * 类ByteCodeContext.java的实现描述：字节码上下文
 * 
 * @author yangbolin Dec 7, 2012 9:22:13 AM
 */
public class ByteCodeContext {

    /** class文件的字节数组 **/
    private byte[]  classByte;
    /** 当前要处理的字节的指针 **/
    private int     currentIndex;
    /** 是否停止解析 **/
    private boolean stop    = false;
    /**
     * 指示当前字节码是否有被wide修饰,只有在解析字节码的时候才有用 注意使用结束之后一定要把标志还原为false
     */
    private boolean hasWide = false;
    
    /**
     * <pre>
     * 字节数组指针向前移动一步
     * </pre>
     */
    public void forwardCurrentIndex() {
        ++currentIndex;
    }

    /**
     * <pre>
     * 字节数组指针向前移动step步
     * </pre>
     * 
     * @param step
     */
    public void forwardCurrentIndexSteps(int step) {
        this.currentIndex += step;
    }

    /**
     * <pre>
     * 字节数字指针向后移动
     * </pre>
     */
    public void backCurrentIndex() {
        --currentIndex;
    }

    /**
     * <pre>
     * 字节数组指针向后移动step步
     * </pre>
     * 
     * @param step
     */
    public void backwardCurrentIndexSteps(int step) {
        this.currentIndex -= step;
    }

    /**
     * <pre>
     * 获取指定大小的字节码数组
     * 注意:
     * 之前获取指定大小数组的代码是分散在各个代码块中的，现在做一次代码的抽取处理，
     * 可能是由于自己害怕麻烦，找借口说服自己不用抽取，所谓OOP就是数据和行为的封装，
     * 就是实现代码的复用，既然OOP能能实现代码的复用，为何不把代码抽取一次呢，如果
     * 不做抽取，不做复用，就有点违背OOP的理念了
     * </pre>
     * 
     * @param size 数组大小
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
