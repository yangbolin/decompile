/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.handler.impl;

import com.alibaba.decompile.attribute.info.AttributeInfo;
import com.alibaba.decompile.common.ByteUtils;
import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.common.MethodAccessFlag;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.context.impl.ConstantPoolContext;
import com.alibaba.decompile.context.impl.MethodsContext;
import com.alibaba.decompile.factory.DecompileFactory;
import com.alibaba.decompile.handler.DecompileHandler;
import com.alibaba.decompile.method.Method;
import com.alibaba.decompile.method.attribute.ParseMethodAttributeFactory;

/**
 * ��MethodsHandler.java��ʵ�����������ֽ����н�������
 * 
 * @author yangbolin Dec 26, 2012 8:20:05 PM
 */
public class MethodsHandler extends DecompileHandler {

    /** ���������� **/
    private MethodsContext methodsContext;

    @Override
    public void parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.�������������Ļ�ȡ�����������ķ���ʹ��
        this.methodsContext = new MethodsContext();
        ConstantPoolContext constantPoolContext = (ConstantPoolContext) decompileFactory.getDecompileContext(DecompileConstants.CONSTANT_POOL_CONTEXT);

        // 1.��ȡ��ʾ������Ŀ���ֽ�������
        byte[] methodsCountBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.METHODS_COUNT_BYTES);

        int methodsCount = Integer.valueOf(ByteUtils.bytesToHex(methodsCountBytes), DecompileConstants.HEX_RADIX);
        this.methodsContext.setMemthodsCount(methodsCount);

        // 2.���ν���ÿ������
        for (int i = 0; i < methodsCount; ++i) {
            Method method = new Method();

            // 2.1���������ķ���Ȩ��
            byte[] accessFlagsBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.METHODS_COUNT_BYTES);
            int accessFlags = Integer.valueOf(ByteUtils.bytesToHex(accessFlagsBytes), DecompileConstants.HEX_RADIX);

            for (MethodAccessFlag methodAccessFlag : MethodAccessFlag.values()) {
                if ((methodAccessFlag.getFlagValue() & accessFlags) != 0) {
                    method.addAccessFlag(methodAccessFlag);
                }
            }

            // 2.2 �����������Ƶ�����
            byte[] nameIndexBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.METHOD_NAME_INDEX_BYTES);
            int nameIndex = Integer.valueOf(ByteUtils.bytesToHex(nameIndexBytes), DecompileConstants.HEX_RADIX);

            String methodName = constantPoolContext.getUTF8tringByIndex(nameIndex);
            method.setNameIndex(nameIndex);
            method.setMethodName(methodName);

            // 2.3 ����������������
            byte[] descriptorIndexBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.METHOD_DESCRIPTOR_BYTES);
            int descriptorIndex = Integer.valueOf(ByteUtils.bytesToHex(descriptorIndexBytes),
                                                  DecompileConstants.HEX_RADIX);
            String descriptorName = constantPoolContext.getUTF8tringByIndex(descriptorIndex);
            method.setDescriptorIndex(descriptorIndex);
            method.setDescriptorName(descriptorName);

            // 2.4 ���������ĸ���������Ŀ
            byte[] attributeCountBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.METHOD_ATTRIBUTE_COUNT_BYTES);
            int attributeCount = Integer.valueOf(ByteUtils.bytesToHex(attributeCountBytes),
                                                 DecompileConstants.HEX_RADIX);
            method.setAttributeCount(attributeCount);

            // 2.5 ���ν���������ÿһ����������
            for (int j = 0; j < attributeCount; ++j) {
                // 2.5.0 �������Ե�����
                byte[] attributeNameIndexBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.ATTRIBUTE_NAME_INDEX_BYTES);
                int attributeNameIndex = Integer.valueOf(ByteUtils.bytesToHex(attributeNameIndexBytes),
                                                         DecompileConstants.HEX_RADIX);
                String attributeName = constantPoolContext.getUTF8tringByIndex(attributeNameIndex);

                // 2.5.1 �����������ۼ�����
                AttributeInfo attributeInfo = ParseMethodAttributeFactory.getSpecParser(attributeName).parse(byteCodeContext,
                                                                                                             decompileFactory);

                attributeInfo.setAttributeNameIndex(attributeNameIndex);
                attributeInfo.setAttributeName(attributeName);

                // 2.5.2 ���÷����ۼ�����
                method.addAttributeInfo(attributeInfo);
            }
        }
    }
}
