/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.attach.parser;

import com.alibaba.decompile.attribute.InnerClass;
import com.alibaba.decompile.attribute.info.AttributeInfo;
import com.alibaba.decompile.attribute.info.InnerClassesInfo;
import com.alibaba.decompile.common.ArrtibuteParser;
import com.alibaba.decompile.common.ClassAccessFlag;
import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.common.utils.ByteUtils;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.context.impl.ConstantPoolContext;
import com.alibaba.decompile.factory.DecompileFactory;

/**
 * <pre>
 * ��InnerClassesParser.java��ʵ���������ڲ���Ľ����� 
 * </pre>
 * 
 * @author yangbolin Jan 27, 2013 7:55:41 PM
 */
public class InnerClassesParser implements ArrtibuteParser {

    @Override
    public AttributeInfo parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.��������ֵ����
        InnerClassesInfo innerClassesInfo = new InnerClassesInfo();
        
        // 1.��ȡ���Գ���
        byte[] lengthBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.ATTRIBUTE_LENGTH_BYTES);
        int length = ByteUtils.bytesToInt(lengthBytes);
        innerClassesInfo.setAttributeLength(length);
        
        // 2.��ȡ�ڲ������Ŀ
        byte[] innerClassesNumBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.INNER_CLASSES_BYTES);
        int innerClassesNum = ByteUtils.bytesToInt(innerClassesNumBytes);
        innerClassesInfo.setNumberOfClasses(innerClassesNum);
        
        ConstantPoolContext context = (ConstantPoolContext)decompileFactory.getDecompileContext(DecompileConstants.CONSTANT_POOL_CONTEXT);
        
        // 3.���ν���ÿһ���ڲ���
        for (int i = 0; i < innerClassesNum; ++i) {
            InnerClass innerClass = new InnerClass();
            
            // 3.0 ��ȡ�ڲ�������
            byte[] innerClassIndexBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.INNER_CLASSES_BYTES);
            int innerClassIndex = ByteUtils.bytesToInt(innerClassIndexBytes);
            
            // 3.1 ����������ȡ�ڲ���Ȩ�޶�����
            String innerClassName = context.getClassQualifiedName(innerClassIndex);
            innerClass.setInnerClassIndex(innerClassIndex);
            innerClass.setInnerClassName(innerClassName);
            
            // 3.2 ��ȡ�ⲿ������
            byte[] outerClassIndexBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.INNER_CLASSES_BYTES);
            int outerClassIndex = ByteUtils.bytesToInt(outerClassIndexBytes);
            
            // 3.3 ����������ȡ�ⲿ��ȫ�޶�����
            String outerClassName = context.getClassQualifiedName(outerClassIndex);
            innerClass.setOuterClassIndex(outerClassIndex);
            innerClass.setOuterClassName(outerClassName);
            
            // 3.4 ��ȡ�ڲ���ķ��ʱ�ʶ 
            byte[] accessFlagBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.INNER_CLASSES_BYTES);
            int accessFlag = ByteUtils.bytesToInt(accessFlagBytes);
            
            for (ClassAccessFlag flag : ClassAccessFlag.values()) {
                if ((flag.getFlagValue() & accessFlag) == 1) {
                    innerClass.addAccessFlag(flag);
                }
            }
            
            innerClassesInfo.addInnerClass(innerClass);
        }
        
        return (AttributeInfo)innerClassesInfo;
    }
}
