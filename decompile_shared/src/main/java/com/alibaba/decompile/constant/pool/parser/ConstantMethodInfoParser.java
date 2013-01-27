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
import com.alibaba.decompile.constant.pool.impl.ConstantMethodInfo;
import com.alibaba.decompile.context.ByteCodeContext;

/**
 * <pre>
 * ��ConstantMethodInfoParser.java��ʵ�����������������෽���Ľ���
 * </pre>
 * 
 * @author yangbolin Jan 2, 2013 4:50:40 PM
 */
public class ConstantMethodInfoParser implements ConstantInfoParser {
    
    private static final String CONSTANT_METHOD = "Method";
    
    @Override
    public ConstantInfo parse(ByteCodeContext byteCodeContext) {
        // 0.��������ֵ����
        ConstantMethodInfo constantInfo = new ConstantMethodInfo();
        constantInfo.setTag(ConstantType.CONSTANT_METHOD_REF_TAG.getIntValue());
        constantInfo.setTagString(CONSTANT_METHOD);
        constantInfo.setClassIndexByteNum(DecompileConstants.CONSTANT_METHOD_CLASS_BYTES);
        constantInfo.setDescriptorByteNum(DecompileConstants.CONSTANT_METHOD_DESCRIPTOR_BYTES);
        
        // 1.��ȡ�����������ڳ������е�������ռ���ֽ�����
        byte[] classIndexBytes = byteCodeContext.getSpecifiedByteCodeArray(constantInfo.getClassIndexByteNum());
        int classIndex = ByteUtils.bytesToInt(classIndexBytes);
        constantInfo.setClassIndexValue(classIndex);
        
        // 2.��ȡ�����������ڳ���������ռ���ֽ�����
        byte[] descriptorBytes = byteCodeContext.getSpecifiedByteCodeArray(constantInfo.getDescriptorByteNum());
        int descriptor = ByteUtils.bytesToInt(descriptorBytes);
        constantInfo.setDescriptorValue(descriptor);
        
        return (ConstantInfo)constantInfo;
    }

}
