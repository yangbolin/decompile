/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.method.attribute.impl;

import com.alibaba.decompile.attribute.ExceptionsTable;
import com.alibaba.decompile.attribute.info.AttributeInfo;
import com.alibaba.decompile.attribute.info.CodeInfo;
import com.alibaba.decompile.common.ArrtibuteParser;
import com.alibaba.decompile.common.ByteCode;
import com.alibaba.decompile.common.ByteUtils;
import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.common.operand.ByteCodeOperandParserFactory;
import com.alibaba.decompile.constant.pool.impl.ConstantClassInfo;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.context.JVMByteCodeContext;
import com.alibaba.decompile.context.impl.ConstantPoolContext;
import com.alibaba.decompile.factory.DecompileFactory;
import com.alibaba.decompile.method.attribute.ParseMethodAttributeFactory;

/**
 * <pre>
 * ��MethodCodeParser.java��ʵ�������������ֽ���Ľ�����
 * </pre>
 * 
 * @author yangbolin Dec 27, 2012 7:58:39 PM
 */
public class MethodCodeParser implements ArrtibuteParser {

    private ByteCodeOperandParserFactory byteCodeOperandParserFactory;

    public MethodCodeParser(){
        this.byteCodeOperandParserFactory = new ByteCodeOperandParserFactory();
    }

    @Override
    public AttributeInfo parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.��������ֵ����
        CodeInfo codeInfo = new CodeInfo();

        // 1.��ȡ���Եĳ�����ռ���ֽ���Ŀ
        byte[] attributeLengthBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.ATTRIBUTE_LENGTH_BYTES);
        int attributeLength = Integer.valueOf(ByteUtils.bytesToHex(attributeLengthBytes), DecompileConstants.HEX_RADIX);
        codeInfo.setAttributeLength(attributeLength);

        // 2.��ȡ������max_stack��ռ���ֽ�����
        byte[] maxStackBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.METHOD_MAX_STACK_BYTE);
        int maxStack = Integer.valueOf(ByteUtils.bytesToHex(maxStackBytes), DecompileConstants.HEX_RADIX);
        codeInfo.setMaxStack(maxStack);

        // 3.��ȡ������max_locals��ռ�ֽ�����
        byte[] maxLocalsBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.METHOD_MAX_LOCALS_BYTE);
        int maxLocals = Integer.valueOf(ByteUtils.bytesToHex(maxLocalsBytes), DecompileConstants.HEX_RADIX);
        codeInfo.setMaxLocals(maxLocals);

        // 4.��ȡcode_length��ռ���ֽ�����
        byte[] codeLengthBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.METHOD_CODE_LENGTH_BYTE);
        int codeLength = Integer.valueOf(ByteUtils.bytesToHex(codeLengthBytes), DecompileConstants.HEX_RADIX);
        codeInfo.setCodeLength(codeLength);

        // 5.�ֽ���Ľ���
        int currentIndex = 0;
        JVMByteCodeContext jvmByteCodeContext = decompileFactory.getJvmByteCodeContext();

        /**
         * <pre>
         * JVM�ֽ���ƫ�����������ֽ�Ϊ��λ�������ֽ���ָ����ռ���ֽ���ĿΪ��λ�ģ����������λ����ͳһ��
         * ��Щ��λ��1����Щ��2����������ȵ�
         * http://hllvm.group.iteye.com/group/topic/35386
         * </pre>
         */

        while (currentIndex < codeLength) {
            // 5.0 ��ȡ�ֽ����code��ռ�ֽ�����
            byte[] codeBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.BYTE_CODE_SYMBOL_CODE_BYTE);
            int code = Integer.valueOf(ByteUtils.bytesToHex(codeBytes), DecompileConstants.HEX_RADIX);

            // 5.1 �����ֽ����Ƿ���wide����
            ByteCode byteCode = jvmByteCodeContext.findByteCodeByCode(code);
            if (byteCode.getSymbol().equals("wide")) {
                byteCodeContext.setHasWide(true);
            }

            // 5.2 �����ֽ����type��ȡ��Ӧ�Ľ�����
            ByteCode parsedByteCode = byteCodeOperandParserFactory.getSpecParser(byteCode.getType()).parse(byteCodeContext,
                                                                                                           decompileFactory);
            parsedByteCode.setBaseOffset(currentIndex);
            parsedByteCode.setCode(byteCode.getCode());
            parsedByteCode.setSymbol(byteCode.getSymbol());
            parsedByteCode.setComment(byteCode.getComment());
            parsedByteCode.setType(byteCode.getType());

            // 5.3 �޸�ƫ�Ƶ�ַ
            currentIndex += parsedByteCode.getTotalBytes();

            codeInfo.addByteCode(parsedByteCode);
        }

        ConstantPoolContext constantPoolContext = (ConstantPoolContext) decompileFactory.getDecompileContext(DecompileConstants.CONSTANT_POOL_CONTEXT);

        // 6.�쳣�Ľ���
        // 6.0 ��ȡ�쳣��������Ŀ
        byte[] exceptionsTableLengthBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.EXCEPTIONS_TABLE_BYTE);
        int exceptionsTableLength = Integer.valueOf(ByteUtils.bytesToHex(exceptionsTableLengthBytes),
                                                    DecompileConstants.HEX_RADIX);
        codeInfo.setExceptionsTableLength(exceptionsTableLength);

        // 6.1 ��ȡ�쳣����
        for (int i = 0; i < exceptionsTableLength; ++i) {
            ExceptionsTable exceptionsTable = new ExceptionsTable();
            byte[] startPCBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.EXCEPTIONS_TABLE_BYTE);
            int startPC = Integer.valueOf(ByteUtils.bytesToHex(startPCBytes), DecompileConstants.HEX_RADIX);
            exceptionsTable.setStartPC(startPC);

            byte[] endPCBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.EXCEPTIONS_TABLE_BYTE);
            int endPC = Integer.valueOf(ByteUtils.bytesToHex(endPCBytes), DecompileConstants.HEX_RADIX);
            exceptionsTable.setEndPC(endPC);

            byte[] handlerPCBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.EXCEPTIONS_TABLE_BYTE);
            int handlerPC = Integer.valueOf(ByteUtils.bytesToHex(handlerPCBytes), DecompileConstants.HEX_RADIX);
            exceptionsTable.setHandlerPC(handlerPC);

            byte[] catchTypeBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.EXCEPTIONS_TABLE_BYTE);
            int catchType = Integer.valueOf(ByteUtils.bytesToHex(catchTypeBytes), DecompileConstants.HEX_RADIX);
            exceptionsTable.setCatchType(catchType);

            ConstantClassInfo constantClassInfo = (ConstantClassInfo) constantPoolContext.getConstantInfoByIndex(catchType - 1);
            exceptionsTable.setCatchTypeString(constantClassInfo.getStringDescription());

            codeInfo.addExceptionsTable(exceptionsTable);
        }

        // 7.��ȡcode���Եĸ���������Ŀ
        byte[] codeInfoAttributesLengthBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.CODE_INFO_ATTRIBUTE_LENGTH_BYTE);
        int codeInfoAttributeLength = Integer.valueOf(ByteUtils.bytesToHex(codeInfoAttributesLengthBytes),
                                                      DecompileConstants.HEX_RADIX);
        codeInfo.setAttributeLength(codeInfoAttributeLength);

        // 8.���ζ�ȡÿһ����������
        for (int j = 0; j < codeInfoAttributeLength; ++j) {
            // 8.0 ������������������ռ���ֽ�����
            byte[] attributeNameIndexBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.ATTRIBUTE_NAME_INDEX_BYTES);
            int attributeNameIndex = Integer.valueOf(ByteUtils.bytesToHex(attributeNameIndexBytes),
                                                     DecompileConstants.HEX_RADIX);

            // 8.1 ��ȡ�������ƶ�Ӧ�����Խ�����
            String attributeName = constantPoolContext.getUTF8tringByIndex(attributeNameIndex - 1);
            AttributeInfo attributeInfo = ParseMethodAttributeFactory.getSpecParser(attributeName).parse(byteCodeContext,
                                                                                                         decompileFactory);

            attributeInfo.setAttributeNameIndex(attributeNameIndex);
            attributeInfo.setAttributeName(attributeName);

            codeInfo.addAttributeInfo(attributeInfo);
        }

        return (AttributeInfo) codeInfo;
    }
}
