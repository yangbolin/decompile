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
 * 类SameFrame.java的实现描述：tag值为[0-63]。offset_delta=frame_type,
 * 表示当前帧和前一帧有相同的局部变量，并且当前操作数栈为空
 * </pre>
 *  
 * @author yangbolin Jan 25, 2013 7:22:17 PM
 */
public class SameFrame extends SMTPFrame {

    @Override
    public String toString() {
        return super.toString();
    }
}
