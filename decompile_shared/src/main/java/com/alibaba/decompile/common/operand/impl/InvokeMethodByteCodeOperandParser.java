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
import com.alibaba.decompile.common.operand.InvokeMethodByteCode;
import com.alibaba.decompile.common.utils.ByteUtils;
import com.alibaba.decompile.constant.pool.impl.ConstantMethodInfo;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.context.impl.ConstantPoolContext;
import com.alibaba.decompile.factory.DecompileFactory;

/**
 * <pre>
 * 类InvokeMethodByteCodeOperandParser.java的实现描述：调用类中方法的字节码
 * </pre>
 *  
 * @author yangbolin Jan 5, 2013 8:31:54 PM
 */
public class InvokeMethodByteCodeOperandParser implements ByteCodeOperandParser {

    @Override
    public ByteCode parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.创建返回值对象
        InvokeMethodByteCode byteCode = new InvokeMethodByteCode();
        byteCode.setOperandBytes(DecompileConstants.OPERAND_TWO_BYTE);
        
        // 1.解析方法在常量池中的索引所占的字节数组
        byte[] indexBytes = byteCodeContext.getSpecifiedByteCodeArray(byteCode.getOperandBytes());
        int index = ByteUtils.bytesToInt(indexBytes);
        byteCode.setIndex(index);
        
        // 2.读取常量池中方法的描述符字符串
        ConstantPoolContext context = (ConstantPoolContext)decompileFactory.getDecompileContext(DecompileConstants.CONSTANT_POOL_CONTEXT);
        ConstantMethodInfo constantMethodInfo = (ConstantMethodInfo)context.getConstantInfoByIndex(index - 1);
        byteCode.setDescriptionString(constantMethodInfo.getStringDescription());
        
        return (ByteCode)byteCode;
    }
}
