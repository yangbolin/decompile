/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.frame;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.decompile.frame.info.VerificationTypeInfo;

/**
 * <pre>
 * 类FullFrame.java的实现描述：tag值为255。offset_delta=offset_delta。full_frame则定义了
 * 所有的信息，包括offset_delta的值，以及当前帧和前一帧不同的所有局部变量和操作数。locals[0]表示
 * 0号局部变量；stack[0]表示栈底操作数
 * </pre>
 * 
 * @author yangbolin Jan 25, 2013 8:15:58 PM
 */
public class FullFrame extends SMTPFrame {

    /** 局部变量的数目 **/
    private int                        numberOfLocals;
    /** 局部变量的类型列表 **/
    private List<VerificationTypeInfo> localTypeInfoList = new ArrayList<VerificationTypeInfo>();
    /** 栈中操作数的数目 **/
    private int                        numberOfStackItems;
    /** 栈中操作数的类型列表 **/
    private List<VerificationTypeInfo> stackTypeInfoList = new ArrayList<VerificationTypeInfo>();

    public void addLocalTypeInfo(VerificationTypeInfo typeInfo) {
        this.localTypeInfoList.add(typeInfo);
    }

    public void addStackTypeInfo(VerificationTypeInfo typeInfo) {
        this.stackTypeInfoList.add(typeInfo);
    }

    
    public int getNumberOfLocals() {
        return numberOfLocals;
    }
    
    public void setNumberOfLocals(int numberOfLocals) {
        this.numberOfLocals = numberOfLocals;
    }
    
    public List<VerificationTypeInfo> getLocalTypeInfoList() {
        return localTypeInfoList;
    }
    
    public void setLocalTypeInfoList(List<VerificationTypeInfo> localTypeInfoList) {
        this.localTypeInfoList = localTypeInfoList;
    }
    
    public int getNumberOfStackItems() {
        return numberOfStackItems;
    }
    
    public void setNumberOfStackItems(int numberOfStackItems) {
        this.numberOfStackItems = numberOfStackItems;
    }
    
    public List<VerificationTypeInfo> getStackTypeInfoList() {
        return stackTypeInfoList;
    }
    
    public void setStackTypeInfoList(List<VerificationTypeInfo> stackTypeInfoList) {
        this.stackTypeInfoList = stackTypeInfoList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\n");
        sb.append(" locals = [ ");
        for (VerificationTypeInfo typeInfo : this.localTypeInfoList) {
            sb.append(String.format(" %s ", typeInfo.toString()));
        }
        sb.append(" ]\n");
        sb.append(" stacks = [ ");
        for (VerificationTypeInfo typeInfo : this.stackTypeInfoList) {
            sb.append(String.format(" %s ", typeInfo.toString()));
        }
        sb.append(" ]");
        return sb.toString();
    }
}
