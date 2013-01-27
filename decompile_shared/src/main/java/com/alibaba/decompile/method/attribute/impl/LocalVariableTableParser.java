/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.method.attribute.impl;

import com.alibaba.decompile.attribute.info.AttributeInfo;
import com.alibaba.decompile.attribute.info.LocalVariableInfo;
import com.alibaba.decompile.common.ArrtibuteParser;
import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.common.LocalVariable;
import com.alibaba.decompile.common.utils.ByteUtils;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.context.impl.ConstantPoolContext;
import com.alibaba.decompile.factory.DecompileFactory;

/**
 * <pre>
 * 类LocalVariableTableParser.java的实现描述：方法局部变量描述的解析器
 * </pre>
 * 
 * @author yangbolin Jan 13, 2013 7:03:50 PM
 */
public class LocalVariableTableParser implements ArrtibuteParser {

    @Override
    public AttributeInfo parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.创建返回值对象
        LocalVariableInfo localVariableInfo = new LocalVariableInfo();

        // 1.读取属性长度所占的字节数组
        byte[] attributeLengthBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.ATTRIBUTE_LENGTH_BYTES);
        int attributeLength = ByteUtils.bytesToInt(attributeLengthBytes);
        localVariableInfo.setAttributeLength(attributeLength);

        // 2.读取局部变量的数目所占的字节数组
        byte[] localVariableTableLengthBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.CODE_LOCAL_VARIABLE_TABLE_BYTE);
        int localVariableTableLength = ByteUtils.bytesToInt(localVariableTableLengthBytes);
        localVariableInfo.setLocalVariableTableLength(localVariableTableLength);

        ConstantPoolContext constantPoolContext = (ConstantPoolContext) decompileFactory.getDecompileContext(DecompileConstants.CONSTANT_POOL_CONTEXT);

        // 3.依次读取每个局部变量
        for (int i = 0; i < localVariableTableLength; ++i) {
            LocalVariable localVariable = new LocalVariable();

            // 3.0 读取局部变量作用域的起始字节码偏移地址索引所占的字节数组
            byte[] startPCBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.CODE_LOCAL_VARIABLE_TABLE_BYTE);
            int startPC = ByteUtils.bytesToInt(startPCBytes);
            localVariable.setStartPC(startPC);

            // 3.1 读取局部变量作用域长度
            byte[] lengthBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.CODE_LOCAL_VARIABLE_TABLE_BYTE);
            int length = ByteUtils.bytesToInt(lengthBytes);
            localVariable.setLength(length);

            // 3.2 读取局部变量名称索引所占的字节数组
            byte[] nameIndexBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.CODE_LOCAL_VARIABLE_TABLE_BYTE);
            int nameIndex = ByteUtils.bytesToInt(nameIndexBytes);
            localVariable.setNameIndex(nameIndex);
            String name = constantPoolContext.getUTF8tringByIndex(nameIndex - 1);
            localVariable.setName(name);

            // 3.3 读取局部变量描述符索引所占的字节数组
            byte[] descriptorIndexBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.CODE_LOCAL_VARIABLE_TABLE_BYTE);
            int descriptorIndex = ByteUtils.bytesToInt(descriptorIndexBytes);
            String descriptor = constantPoolContext.getUTF8tringByIndex(descriptorIndex - 1);
            localVariable.setDescriptor(descriptor);
            
            // 3.3 读取局部变量所在的slot编号所占的字节数组
            byte[] slotBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.LOCAL_VARIABLE_SLOT_BYTES);
            int slot = ByteUtils.bytesToInt(slotBytes);
            localVariable.setIndex(slot);
            
            localVariableInfo.addLocalVariable(localVariable);
        }

        return (AttributeInfo) localVariableInfo;
    }
}
