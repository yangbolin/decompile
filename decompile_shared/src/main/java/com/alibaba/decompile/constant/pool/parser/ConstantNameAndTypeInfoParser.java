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
import com.alibaba.decompile.constant.pool.impl.ConstantNameAndTypeInfo;
import com.alibaba.decompile.context.ByteCodeContext;

/**
 * <pre>
 * ��ConstantNameAndTypeInfoParser.java��ʵ���������ֶλ��߷����Ĳ��ַ������ý�����
 * </pre>
 * 
 * @author yangbolin Jan 2, 2013 4:51:19 PM
 */
public class ConstantNameAndTypeInfoParser implements ConstantInfoParser {

    private static final String CONSTANT_NAME_AND_TYPE = "NameAndType";
    
    @Override
    public ConstantInfo parse(ByteCodeContext byteCodeContext) {
        // 0.��������ֵ����
        ConstantNameAndTypeInfo constantInfo = new ConstantNameAndTypeInfo();
        constantInfo.setTag(ConstantType.CONSTANT_NAME_ADN_TYPE_TAG.getIntValue());
        constantInfo.setTagString(CONSTANT_NAME_AND_TYPE);
        constantInfo.setNameIndexByteNum(DecompileConstants.CONSTANT_NAME_AND_TYPE_NAME_BYTES);
        constantInfo.setDescriptorByteNum(DecompileConstants.CONSTANT_NAME_AND_TYPE_DESCRIPTOR_BYTES);
        
        // 1.��ȡ������������������ռ���ֽ�����
        byte[] nameIndexBytes = byteCodeContext.getSpecifiedByteCodeArray(constantInfo.getNameIndexByteNum());
        int nameIndex = ByteUtils.bytesToInt(nameIndexBytes);
        constantInfo.setNameIndexValue(nameIndex);
        
        // 2.��ȡ��������������ռ���ֽ�����
        byte[] descriptorBytes = byteCodeContext.getSpecifiedByteCodeArray(constantInfo.getDescriptorByteNum());
        int descriptor = ByteUtils.bytesToInt(descriptorBytes);
        constantInfo.setDescriptorValue(descriptor);
        
        return (ConstantInfo)constantInfo;
    }
}
