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
 * 类SameLocals1StackItemFrame.java的实现描述：tag值为[64-127]。offset_delta=frame_type-64。
 * 表示当前帧和前一帧有相同的局部变量，并且操作栈内的操作数条目为1，因此它为该操作数栈内的操作数保存了一项
 * verification_type_info
 * </pre>
 * 
 * @author yangbolin Jan 25, 2013 7:26:04 PM
 */
public class SameLocals1StackItemFrame extends SMTPFrame {

    /** 类型信息 **/
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
