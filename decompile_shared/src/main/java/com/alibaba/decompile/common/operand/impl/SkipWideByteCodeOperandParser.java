/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common.operand.impl;

import com.alibaba.decompile.common.ByteCode;
import com.alibaba.decompile.common.ByteUtils;
import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.common.operand.ByteCodeOperandParser;
import com.alibaba.decompile.common.operand.SkipWideByteCode;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.factory.DecompileFactory;

/**
 * <pre>
 * 类SkipWideByteCodeOperandParser.java的实现描述：对应跳转偏移量是四字节的字节码指令
 * </pre>
 *  
 * @author yangbolin Jan 9, 2013 9:26:47 PM
 */
public class SkipWideByteCodeOperandParser implements ByteCodeOperandParser {

    @Override
    public ByteCode parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.创建返回值对象
        SkipWideByteCode byteCode = new SkipWideByteCode();
        byteCode.setOperandBytes(DecompileConstants.OPERAND_FOUR_BYTE);
        
        // 1.读取跳转偏移量所占的字节数组
        byte[] offsetBytes = byteCodeContext.getSpecifiedByteCodeArray(byteCode.getOperandBytes());
        int offset = Integer.valueOf(ByteUtils.bytesToHex(offsetBytes), DecompileConstants.HEX_RADIX);
        byteCode.setOffset(offset);
        
        // 2.设置当前字节码所占的字节总数
        byteCode.setTotalBytes(DecompileConstants.BYTE_CODE_SYMBOL_CODE_BYTE + byteCode.getOperandBytes());
        
        return (ByteCode)byteCode;
    }

}
