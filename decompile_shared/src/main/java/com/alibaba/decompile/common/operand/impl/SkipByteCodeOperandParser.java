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
import com.alibaba.decompile.common.operand.SkipByteCode;
import com.alibaba.decompile.common.utils.ByteUtils;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.factory.DecompileFactory;

/**
 * <pre>
 * 类SkipByteCodeOperandParser.java的实现描述：解析JVM跳转指令的参数
 * 注：
 * 这里解析出来的只是相对偏移量，实际的跳转地址应该是基地址+偏移量，跳转指令
 * 本身的地址就是基地址，假如跳转指令本身的地址是M,偏移量是N,那么最终的跳转
 * 地址就是M+N
 * </pre>
 * 
 * @author yangbolin Jan 1, 2013 5:04:02 PM
 */
public class SkipByteCodeOperandParser implements ByteCodeOperandParser {

    @Override
    public ByteCode parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.创建返回值对象
        SkipByteCode byteCode = new SkipByteCode();
        
        // 1.读取跳转偏移量所占的字节数组
        byteCode.setOperandBytes(DecompileConstants.OPERAND_TWO_BYTE);
        byte[] offsetBytes = byteCodeContext.getSpecifiedByteCodeArray(byteCode.getOperandBytes());
        
        // 2.把字节数组转换成整型数字
        int offset = ByteUtils.bytesToInt(offsetBytes);
        
        byteCode.setOffset(offset);
        
        return (ByteCode)byteCode;
    }
}
