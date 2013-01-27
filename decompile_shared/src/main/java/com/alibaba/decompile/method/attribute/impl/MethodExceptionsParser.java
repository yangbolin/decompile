/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.method.attribute.impl;

import com.alibaba.decompile.attribute.info.AttributeInfo;
import com.alibaba.decompile.attribute.info.ExceptionsInfo;
import com.alibaba.decompile.common.ArrtibuteParser;
import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.common.utils.ByteUtils;
import com.alibaba.decompile.constant.pool.impl.ConstantClassInfo;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.context.impl.ConstantPoolContext;
import com.alibaba.decompile.factory.DecompileFactory;

/**
 * ��MethodExceptionsParser.java��ʵ�������������쳣�б����ԵĽ�����
 * 
 * @author yangbolin Dec 27, 2012 8:10:13 PM
 */
public class MethodExceptionsParser implements ArrtibuteParser {

    @Override
    public AttributeInfo parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.��������ֵ����
        ExceptionsInfo exceptionsInfo = new ExceptionsInfo();
        
        // 1.��ȡ���Գ�����ռ���ֽ�����
        byte[] attributeLengthBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.ATTRIBUTE_LENGTH_BYTES);
        int attributeLength = ByteUtils.bytesToInt(attributeLengthBytes);
        exceptionsInfo.setAttributeLength(attributeLength);
        
        // 2.��ȡ�쳣��Ŀ��ռ���ֽ�����
        byte[] numberOfExceptionsBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.METHOD_EXCEPTIONS_ATTRIBUTE_BYTE);
        int numberOfExceptions = ByteUtils.bytesToInt(numberOfExceptionsBytes);
        exceptionsInfo.setNumberOfExceptions(numberOfExceptions);
        
        ConstantPoolContext constantPoolContext = (ConstantPoolContext)decompileFactory.getDecompileContext(DecompileConstants.CONSTANT_POOL_CONTEXT);
        
        // 3.���ζ�ȡ������ÿ���쳣
        for (int i = 0; i < numberOfExceptions; ++i) {
            // 3.0 ��ȡ�쳣����������ռ���ֽ�����
            byte[] exceptionIndexBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.METHOD_EXCEPTIONS_ATTRIBUTE_BYTE);
            int exceptionsIndex = ByteUtils.bytesToInt(exceptionIndexBytes);
            exceptionsInfo.addIndex(exceptionsIndex);
            
            // 3.1 ��ȡ����������
            ConstantClassInfo constantClassInfo = (ConstantClassInfo)constantPoolContext.getConstantInfoByIndex(exceptionsIndex - 1);
            exceptionsInfo.addTypeString(constantClassInfo.getStringDescription());
        }
        
        return (AttributeInfo)exceptionsInfo;
    }
}
