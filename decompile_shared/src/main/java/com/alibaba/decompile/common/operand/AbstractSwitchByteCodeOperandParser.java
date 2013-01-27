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
 * ��AbstractSwitchByteCodeOperandParser.java��ʵ������������lookupswitch��tableswitchʱ�Ĺ�ͬ����
 * </pre>
 * 
 * @author yangbolin Jan 2, 2013 3:16:15 PM
 */
public abstract class AbstractSwitchByteCodeOperandParser {

    /**
     * <pre>
     * ��ȡ������ֽڣ����������ֽڽ�������֮���Ӧ����������0˵�������ֽڽ���������
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
     * ������lookupswitch����tableswitch����Ҫ������default��֧��Ӧ����תƫ����
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
