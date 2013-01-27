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
import com.alibaba.decompile.common.operand.InvokeInterfaceMethodByteCode;
import com.alibaba.decompile.common.utils.ByteUtils;
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
        
        // 1.读取常量池中的方法索引所占的字节数组
        byte[] indexBytes = byteCodeContext.getSpecifiedByteCodeArray(byteCode.getOperandBytes());
        int index = ByteUtils.bytesToInt(indexBytes);
        byteCode.setIndex(index);
        
        // 2.读取常量池中方法的描述字符串
        ConstantPoolContext constantPoolContext = (ConstantPoolContext) decompileFactory.getDecompileContext(DecompileConstants.CONSTANT_POOL_CONTEXT);
        ConstantInterfaceMethodInfo constantInterfaceMethodInfo = (ConstantInterfaceMethodInfo) constantPoolContext.getConstantInfoByIndex(index - 1);
        byteCode.setDescriptionString(constantInterfaceMethodInfo.getStringDescription());

        // 2.读取count字段
        byte[] countBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.OPERAND_ONE_BYTE);
        int count = ByteUtils.bytesToInt(countBytes);
        byteCode.setCount(count);
        
        // 3.读取0字段
        byte[] zeroBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.OPERAND_ONE_BYTE);
        int zero = ByteUtils.bytesToInt(zeroBytes);
        byteCode.setZero(zero);
        
        return (ByteCode) byteCode;
    }
}
