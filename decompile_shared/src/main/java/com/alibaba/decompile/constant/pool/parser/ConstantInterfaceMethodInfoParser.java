/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.constant.pool.parser;

import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.common.utils.ByteUtils;
import com.alibaba.decompile.constant.pool.ConstantInfo;
import com.alibaba.decompile.constant.pool.ConstantInfoParser;
import com.alibaba.decompile.constant.pool.ConstantType;
import com.alibaba.decompile.constant.pool.impl.ConstantInterfaceMethodInfo;
import com.alibaba.decompile.context.ByteCodeContext;

/**
 * <pre>
 * ��ConstantInterfaceMethodParser.java��ʵ���������������нӿڷ����Ľ�����
 * </pre>
 * 
 * @author yangbolin Jan 2, 2013 4:49:52 PM
 */
public class ConstantInterfaceMethodInfoParser implements ConstantInfoParser {

    private static final String CONSTANT_INTERFACE_METHOD = "InterfaceMethod";

    @Override
    public ConstantInfo parse(ByteCodeContext byteCodeContext) {
        // 0.��������ֵ����
        ConstantInterfaceMethodInfo constantInfo = new ConstantInterfaceMethodInfo();
        constantInfo.setTag(ConstantType.CONSTANT_INTERFACE_METHOD_REF_TAG.getIntValue());
        constantInfo.setTagString(CONSTANT_INTERFACE_METHOD);
        constantInfo.setInterfaceIndexByteNum(DecompileConstants.CONSTANT_METHOD_INTERFACE_BYTES);
        constantInfo.setDescriptorByteNum(DecompileConstants.CONSTANT_METHOD_DESCRIPTOR_BYTES);
        
        // 1.��ȡ�������ڵĽӿ��ڳ�������������ռ���ֽ�����
        byte[] interfaceIndexBytes = byteCodeContext.getSpecifiedByteCodeArray(constantInfo.getInterfaceIndexByteNum());
        int interfaceIndex = ByteUtils.bytesToInt(interfaceIndexBytes);
        constantInfo.setInterfaceIndexValue(interfaceIndex);
        
        // 2.��ȡ�����������ڳ�������������ռ���ֽ�����
        byte[] descriptorBytes = byteCodeContext.getSpecifiedByteCodeArray(constantInfo.getDescriptorByteNum());
        int descriptor = ByteUtils.bytesToInt(descriptorBytes);
        constantInfo.setDescriptorValue(descriptor);
       
        return (ConstantInfo)constantInfo;
    }
}
