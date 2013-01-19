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
import com.alibaba.decompile.common.operand.InvokeInterfaceMethodByteCode;
import com.alibaba.decompile.constant.pool.impl.ConstantInterfaceMethodInfo;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.context.impl.ConstantPoolContext;
import com.alibaba.decompile.factory.DecompileFactory;

/**
 * <pre>
 * 类InvokeInterfaceMethodByteCodeParser.java的实现描述：对应调用接口方法的字节码
 * </pre>
 * 
 * @author yangbolin Jan 5, 2013 9:01:10 PM
 */
public class InvokeInterfaceMethodByteCodeOperandParser implements ByteCodeOperandParser {

    @Override
    public ByteCode parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.创建返回值对象
        InvokeInterfaceMethodByteCode byteCode = new InvokeInterfaceMethodByteCode();
        byteCode.setOperandBytes(DecompileConstants.OPERAND_TWO_BYTE);
        
        int totalBytes = DecompileConstants.BYTE_CODE_SYMBOL_CODE_BYTE;
        

        // 1.读取常量池中的方法索引所占的字节数组
        byte[] indexBytes = byteCodeContext.getSpecifiedByteCodeArray(byteCode.getOperandBytes());
        int index = Integer.valueOf(ByteUtils.bytesToHex(indexBytes), DecompileConstants.HEX_RADIX);
        byteCode.setIndex(index);
        
        totalBytes+= byteCode.getOperandBytes();

        // 2.读取常量池中方法的描述字符串
        ConstantPoolContext constantPoolContext = (ConstantPoolContext) decompileFactory.getDecompileContext(DecompileConstants.CONSTANT_POOL_CONTEXT);
        ConstantInterfaceMethodInfo constantInterfaceMethodInfo = (ConstantInterfaceMethodInfo) constantPoolContext.getConstantInfoByIndex(index - 1);
        byteCode.setDescriptionString(constantInterfaceMethodInfo.getStringDescription());

        // 2.读取count字段
        byte[] countBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.OPERAND_ONE_BYTE);
        int count = Integer.valueOf(ByteUtils.bytesToHex(countBytes), DecompileConstants.HEX_RADIX);
        byteCode.setCount(count);
        
        totalBytes += DecompileConstants.OPERAND_ONE_BYTE;

        // 3.读取0字段
        byte[] zeroBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.OPERAND_ONE_BYTE);
        int zero = Integer.valueOf(ByteUtils.bytesToHex(zeroBytes), DecompileConstants.HEX_RADIX);
        byteCode.setZero(zero);
        
        totalBytes += DecompileConstants.OPERAND_ONE_BYTE;
        
        // 4.设置当前字节码所占字节总数
        byteCode.setTotalBytes(totalBytes);
        
        return (ByteCode) byteCode;
    }
}
