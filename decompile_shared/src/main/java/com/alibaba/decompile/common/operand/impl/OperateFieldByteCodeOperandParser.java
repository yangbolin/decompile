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
import com.alibaba.decompile.common.operand.OperateFieldByteCode;
import com.alibaba.decompile.common.utils.ByteUtils;
import com.alibaba.decompile.constant.pool.impl.ConstantFieldRefInfo;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.context.impl.ConstantPoolContext;
import com.alibaba.decompile.factory.DecompileFactory;

/**
 * <pre>
 * 类OperateFieldByteCodeOperandParser.java的实现描述：操作字段的字节码操作数解析器
 * </pre>
 * 
 * @author yangbolin Jan 4, 2013 8:50:52 PM
 */
public class OperateFieldByteCodeOperandParser implements ByteCodeOperandParser {

    @Override
    public ByteCode parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.创建返回值对象
        OperateFieldByteCode byteCode = new OperateFieldByteCode();
        byteCode.setOperandBytes(DecompileConstants.OPERAND_TWO_BYTE);
        
        // 1.读取字段在常量池中索引所占的字节数组
        byte[] indexBytes = byteCodeContext.getSpecifiedByteCodeArray(byteCode.getOperandBytes());
        int index = ByteUtils.bytesToInt(indexBytes);
        byteCode.setFieldIndex(index);
        
        // 2.根据常量池中的索引获取一个ConstantFieldRefInfo类型的常量
        ConstantPoolContext context = (ConstantPoolContext)decompileFactory.getDecompileContext(DecompileConstants.CONSTANT_POOL_CONTEXT);
        
        ConstantFieldRefInfo constantFieldRefInfo = (ConstantFieldRefInfo)context.getConstantInfoByIndex(index - 1);
        
        // 3.设置字段的描述信息
        byteCode.setDescriptionString(constantFieldRefInfo.getStringDescription());
        
        return (ByteCode)byteCode;
    }
}
