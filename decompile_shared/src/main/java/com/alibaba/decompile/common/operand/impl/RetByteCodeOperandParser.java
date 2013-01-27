/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common.operand.impl;

import com.alibaba.decompile.common.ByteCode;
import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.common.operand.ByteCodeOperandParser;
import com.alibaba.decompile.common.operand.RetByteCode;
import com.alibaba.decompile.common.utils.ByteUtils;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.factory.DecompileFactory;

/**
 * <pre>
 * 类RetByteCodeOperandParser.java的实现描述：ret字节码指令操作数解析器 
 * </pre>
 * @author yangbolin Jan 2, 2013 9:22:16 AM
 */
public class RetByteCodeOperandParser implements ByteCodeOperandParser {

    @Override
    public ByteCode parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.创建返回值对象
        RetByteCode byteCode = new RetByteCode();
        
        // 1.判断操作数所占的字节数目
        if (byteCodeContext.isHasWide()) {
            byteCode.setOperandBytes(DecompileConstants.OPERAND_TWO_BYTE);
            byteCode.setHasWide(true);
            byteCodeContext.setHasWide(false);      // 一次使用，立即复原
        } else {
            byteCode.setOperandBytes(DecompileConstants.OPERAND_ONE_BYTE);
        }
        
        // 2.读取操作数所占的字节数组
        byte[] offsetBytes = byteCodeContext.getSpecifiedByteCodeArray(byteCode.getOperandBytes());
        
        // 3. bytes to integer
        int offset = ByteUtils.bytesToInt(offsetBytes);
        byteCode.setOffset(offset);
        
        return (ByteCode)byteCode;
    }
}
