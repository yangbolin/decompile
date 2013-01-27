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
import com.alibaba.decompile.common.operand.MultianewarrayByteCode;
import com.alibaba.decompile.common.utils.ByteUtils;
import com.alibaba.decompile.constant.pool.impl.ConstantClassInfo;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.context.impl.ConstantPoolContext;
import com.alibaba.decompile.factory.DecompileFactory;

/**
 * <pre>
 * 类MultianewarrayByteCodeOperandParser.java的实现描述：对应multianewarray字节码 
 * </pre>
 * 
 * @author yangbolin Jan 9, 2013 8:17:47 PM
 */
public class MultianewarrayByteCodeOperandParser implements ByteCodeOperandParser {

    @Override
    public ByteCode parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.创建返回值对象
        MultianewarrayByteCode byteCode = new MultianewarrayByteCode();
        byteCode.setOperandBytes(DecompileConstants.OPERAND_TWO_BYTE);
        
        // 1.读取多维数组的类型在常量池中的索引所占的字节数组
        byte[] indexBytes = byteCodeContext.getSpecifiedByteCodeArray(byteCode.getOperandBytes());
        int index = ByteUtils.bytesToInt(indexBytes);
        byteCode.setIndex(index);
        
        // 2.获取多维数组类型的字符串描述信息
        ConstantPoolContext context = (ConstantPoolContext)decompileFactory.getDecompileContext(DecompileConstants.CONSTANT_POOL_CONTEXT);
        ConstantClassInfo constantClassInfo = (ConstantClassInfo)context.getConstantInfoByIndex(index - 1);
        byteCode.setDescriptionString(constantClassInfo.getStringDescription());
        
        // 3.读取数组维数所占的字节数组
        byte[] dimensionsBytes = byteCodeContext.getSpecifiedByteCodeArray(byteCode.getOperandBytes());
        int dimensions = ByteUtils.bytesToInt(dimensionsBytes);
        byteCode.setDimensions(dimensions);
        
        return (ByteCode)byteCode;
    }
}
