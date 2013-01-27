/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common.operand;

import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.common.utils.ByteUtils;
import com.alibaba.decompile.context.ByteCodeContext;

/**
 * <pre>
 * 类AbstractSwitchByteCodeOperandParser.java的实现描述：解析lookupswitch和tableswitch时的共同代码
 * </pre>
 * 
 * @author yangbolin Jan 2, 2013 3:16:15 PM
 */
public abstract class AbstractSwitchByteCodeOperandParser {

    /**
     * <pre>
     * 读取对齐的字节，如果对齐的字节解析出来之后对应的整数不是0说明对齐字节解析有问题
     * </pre>
     * 
     * @param byteCodeContext
     * @return
     */
    protected int parsePaddingBytes(ByteCodeContext byteCodeContext) {
        int padBytesNum = 4 - byteCodeContext.getCurrentIndex() % 4;
        if (padBytesNum != 0) {
            byte[] padBytes = byteCodeContext.getSpecifiedByteCodeArray(padBytesNum);
            if (ByteUtils.bytesToInt(padBytes) != 0) {
                return -1;
            }
        }
        return padBytesNum;
    }

    /**
     * <pre>
     * 不论是lookupswitch还是tableswitch都需要解析出default分支对应的跳转偏移量
     * </pre>
     * 
     * @param byteCodeContext
     * @param byteCode
     */
    protected int parseDefaultOffset(ByteCodeContext byteCodeContext) {
        byte[] defaultOffsetBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.OPERAND_FOUR_BYTE);
        int defaultOffset = ByteUtils.bytesToInt(defaultOffsetBytes);
        return defaultOffset;
    }
}
