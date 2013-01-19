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
 * 类MethodCodeParser.java的实现描述：方法字节码的解析器
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
        // 0.创建返回值对象
        CodeInfo codeInfo = new CodeInfo();

        // 1.读取属性的长度所占的字节数目
        byte[] attributeLengthBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.ATTRIBUTE_LENGTH_BYTES);
        int attributeLength = Integer.valueOf(ByteUtils.bytesToHex(attributeLengthBytes), DecompileConstants.HEX_RADIX);
        codeInfo.setAttributeLength(attributeLength);

        // 2.读取方法的max_stack所占的字节数组
        byte[] maxStackBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.METHOD_MAX_STACK_BYTE);
        int maxStack = Integer.valueOf(ByteUtils.bytesToHex(maxStackBytes), DecompileConstants.HEX_RADIX);
        codeInfo.setMaxStack(maxStack);

        // 3.读取方法的max_locals所占字节数组
        byte[] maxLocalsBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.METHOD_MAX_LOCALS_BYTE);
        int maxLocals = Integer.valueOf(ByteUtils.bytesToHex(maxLocalsBytes), DecompileConstants.HEX_RADIX);
        codeInfo.setMaxLocals(maxLocals);

        // 4.读取code_length所占的字节数组
        byte[] codeLengthBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.METHOD_CODE_LENGTH_BYTE);
        int codeLength = Integer.valueOf(ByteUtils.bytesToHex(codeLengthBytes), DecompileConstants.HEX_RADIX);
        codeInfo.setCodeLength(codeLength);

        // 5.字节码的解析
        int currentIndex = 0;
        JVMByteCodeContext jvmByteCodeContext = decompileFactory.getJvmByteCodeContext();

        /**
         * <pre>
         * JVM字节码偏移量不是以字节为单位而是以字节码指令所占的字节数目为单位的，但是这个单位不是统一的
         * 有些单位是1，有些是2，甚至更多等等
         * http://hllvm.group.iteye.com/group/topic/35386
         * </pre>
         */

        while (currentIndex < codeLength) {
            // 5.0 读取字节码的code所占字节数组
            byte[] codeBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.BYTE_CODE_SYMBOL_CODE_BYTE);
            int code = Integer.valueOf(ByteUtils.bytesToHex(codeBytes), DecompileConstants.HEX_RADIX);

            // 5.1 设置字节码是否有wide修饰
            ByteCode byteCode = jvmByteCodeContext.findByteCodeByCode(code);
            if (byteCode.getSymbol().equals("wide")) {
                byteCodeContext.setHasWide(true);
            }

            // 5.2 根据字节码的type获取相应的解析器
            ByteCode parsedByteCode = byteCodeOperandParserFactory.getSpecParser(byteCode.getType()).parse(byteCodeContext,
                                                                                                           decompileFactory);
            parsedByteCode.setBaseOffset(currentIndex);
            parsedByteCode.setCode(byteCode.getCode());
            parsedByteCode.setSymbol(byteCode.getSymbol());
            parsedByteCode.setComment(byteCode.getComment());
            parsedByteCode.setType(byteCode.getType());

            // 5.3 修改偏移地址
            currentIndex += parsedByteCode.getTotalBytes();

            codeInfo.addByteCode(parsedByteCode);
        }

        ConstantPoolContext constantPoolContext = (ConstantPoolContext) decompileFactory.getDecompileContext(DecompileConstants.CONSTANT_POOL_CONTEXT);

        // 6.异常的解析
        // 6.0 读取异常处理表的数目
        byte[] exceptionsTableLengthBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.EXCEPTIONS_TABLE_BYTE);
        int exceptionsTableLength = Integer.valueOf(ByteUtils.bytesToHex(exceptionsTableLengthBytes),
                                                    DecompileConstants.HEX_RADIX);
        codeInfo.setExceptionsTableLength(exceptionsTableLength);

        // 6.1 读取异常处理
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

        // 7.读取code属性的附加属性数目
        byte[] codeInfoAttributesLengthBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.CODE_INFO_ATTRIBUTE_LENGTH_BYTE);
        int codeInfoAttributeLength = Integer.valueOf(ByteUtils.bytesToHex(codeInfoAttributesLengthBytes),
                                                      DecompileConstants.HEX_RADIX);
        codeInfo.setAttributeLength(codeInfoAttributeLength);

        // 8.依次读取每一个附加属性
        for (int j = 0; j < codeInfoAttributeLength; ++j) {
            // 8.0 解析属性名称索引所占的字节数组
            byte[] attributeNameIndexBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.ATTRIBUTE_NAME_INDEX_BYTES);
            int attributeNameIndex = Integer.valueOf(ByteUtils.bytesToHex(attributeNameIndexBytes),
                                                     DecompileConstants.HEX_RADIX);

            // 8.1 获取属性名称对应的属性解析器
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
