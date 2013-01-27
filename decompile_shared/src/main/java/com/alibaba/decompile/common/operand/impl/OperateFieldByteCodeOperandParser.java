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
 * ��OperateFieldByteCodeOperandParser.java��ʵ�������������ֶε��ֽ��������������
 * </pre>
 * 
 * @author yangbolin Jan 4, 2013 8:50:52 PM
 */
public class OperateFieldByteCodeOperandParser implements ByteCodeOperandParser {

    @Override
    public ByteCode parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.��������ֵ����
        OperateFieldByteCode byteCode = new OperateFieldByteCode();
        byteCode.setOperandBytes(DecompileConstants.OPERAND_TWO_BYTE);
        
        // 1.��ȡ�ֶ��ڳ�������������ռ���ֽ�����
        byte[] indexBytes = byteCodeContext.getSpecifiedByteCodeArray(byteCode.getOperandBytes());
        int index = ByteUtils.bytesToInt(indexBytes);
        byteCode.setFieldIndex(index);
        
        // 2.���ݳ������е�������ȡһ��ConstantFieldRefInfo���͵ĳ���
        ConstantPoolContext context = (ConstantPoolContext)decompileFactory.getDecompileContext(DecompileConstants.CONSTANT_POOL_CONTEXT);
        
        ConstantFieldRefInfo constantFieldRefInfo = (ConstantFieldRefInfo)context.getConstantInfoByIndex(index - 1);
        
        // 3.�����ֶε�������Ϣ
        byteCode.setDescriptionString(constantFieldRefInfo.getStringDescription());
        
        return (ByteCode)byteCode;
    }
}
