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
import com.alibaba.decompile.common.operand.AnewarrayByteCode;
import com.alibaba.decompile.common.operand.ByteCodeOperandParser;
import com.alibaba.decompile.common.utils.ByteUtils;
import com.alibaba.decompile.constant.pool.impl.ConstantClassInfo;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.context.impl.ConstantPoolContext;
import com.alibaba.decompile.factory.DecompileFactory;

/**
 * <pre>
 * ��AnewarrayByteCodeParser.java��ʵ����������Ӧanewarray�ֽ���Ľ��� 
 * </pre>
 * 
 * @author yangbolin Jan 9, 2013 7:20:01 PM
 */
public class AnewarrayByteCodeOperandParser implements ByteCodeOperandParser {

    @Override
    public ByteCode parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.��������ֵ����
        AnewarrayByteCode byteCode = new AnewarrayByteCode();
        byteCode.setOperandBytes(DecompileConstants.OPERAND_TWO_BYTE);
        
        // 1.��ȡ���������ڳ�������������ռ���ֽ�����
        byte[] indexBytes = byteCodeContext.getSpecifiedByteCodeArray(byteCode.getOperandBytes());
        int index = ByteUtils.bytesToInt(indexBytes);
        byteCode.setIndex(index);
        
        // 2.��ȡ�����ڳ������е�������Ϣ
        ConstantPoolContext context = (ConstantPoolContext)decompileFactory.getDecompileContext(DecompileConstants.CONSTANT_POOL_CONTEXT);
        ConstantClassInfo constantClassInfo = (ConstantClassInfo)context.getConstantInfoByIndex(index - 1);
        byteCode.setDescriptionString(constantClassInfo.getStringDescription());
        
        return (ByteCode)byteCode;
    }
}
