/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.frame;

import com.alibaba.decompile.frame.info.VerificationTypeInfo;

/**
 * <pre>
 * 类SameLocals1StackItemFrameExtended.java的实现描述：tag值为247。offset_delta=offset_delta。
 * 表示当前值和前一帧有相同的局部变量，并且操作栈内的操作数条目数为1，因而它为该操作数栈内的操作数保存了一份
 * verification_type_info。和SameLocals1StackItemFrame的区别就是这里offset_delta是直接给出的
 * </pre>
 * 
 * @author yangbolin Jan 25, 2013 7:39:32 PM
 */
public class SameLocals1StackItemFrameExtended extends SMTPFrame {

    /** 存储类型信息 **/
    private VerificationTypeInfo verificationTypeInfo;

    public VerificationTypeInfo getVerificationTypeInfo() {
        return verificationTypeInfo;
    }

    public void setVerificationTypeInfo(VerificationTypeInfo verificationTypeInfo) {
        this.verificationTypeInfo = verificationTypeInfo;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\n");
        sb.append(String.format("verificationTypeInfo = [ %s ]", this.verificationTypeInfo.toString()));
        return super.toString();
    }
}
