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
 * ��InvokeInterfaceMethodByteCodeParser.java��ʵ����������Ӧ���ýӿڷ������ֽ���
 * </pre>
 * 
 * @author yangbolin Jan 5, 2013 9:01:10 PM
 */
public class InvokeInterfaceMethodByteCodeOperandParser implements ByteCodeOperandParser {

    @Override
    public ByteCode parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.��������ֵ����
        InvokeInterfaceMethodByteCode byteCode = new InvokeInterfaceMethodByteCode();
        byteCode.setOperandBytes(DecompileConstants.OPERAND_TWO_BYTE);
        
        // 1.��ȡ�������еķ���������ռ���ֽ�����
        byte[] indexBytes = byteCodeContext.getSpecifiedByteCodeArray(byteCode.getOperandBytes());
        int index = ByteUtils.bytesToInt(indexBytes);
        byteCode.setIndex(index);
        
        // 2.��ȡ�������з����������ַ���
        ConstantPoolContext constantPoolContext = (ConstantPoolContext) decompileFactory.getDecompileContext(DecompileConstants.CONSTANT_POOL_CONTEXT);
        ConstantInterfaceMethodInfo constantInterfaceMethodInfo = (ConstantInterfaceMethodInfo) constantPoolContext.getConstantInfoByIndex(index - 1);
        byteCode.setDescriptionString(constantInterfaceMethodInfo.getStringDescription());

        // 2.��ȡcount�ֶ�
        byte[] countBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.OPERAND_ONE_BYTE);
        int count = ByteUtils.bytesToInt(countBytes);
        byteCode.setCount(count);
        
        // 3.��ȡ0�ֶ�
        byte[] zeroBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.OPERAND_ONE_BYTE);
        int zero = ByteUtils.bytesToInt(zeroBytes);
        byteCode.setZero(zero);
        
        return (ByteCode) byteCode;
    }
}
