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
 * 类SameFrameExtended.java的实现描述：tag值为251。offset_delta=offset_delta。表示当前帧和前一帧
 * 有相同的局部变量，并且操作数栈为空。和same_frame的区别是same_frame_extended中的offset_delta是直接
 * 给出的
 * </pre>
 *  
 * @author yangbolin Jan 25, 2013 7:50:15 PM
 */
public class SameFrameExtended extends SMTPFrame {

    @Override
    public String toString() {
        return super.toString();
    }
}
