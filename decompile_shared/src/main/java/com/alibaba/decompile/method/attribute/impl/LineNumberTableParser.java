/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.method.attribute.impl;

import com.alibaba.decompile.attribute.info.AttributeInfo;
import com.alibaba.decompile.attribute.info.LineNumberTableInfo;
import com.alibaba.decompile.common.ArrtibuteParser;
import com.alibaba.decompile.common.ByteUtils;
import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.factory.DecompileFactory;

/**
 * <pre>
 * 类LineNumberTableParser.java的实现描述：字节码和源程序行号的对应关系
 * </pre>
 *  
 * @author yangbolin Jan 13, 2013 7:01:04 PM
 */
public class LineNumberTableParser implements ArrtibuteParser {

    @Override
    public AttributeInfo parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.创建返回值对象
        LineNumberTableInfo lineNumberTableInfo = new LineNumberTableInfo();
        
        // 1.读取属性的长度所占的字节数组
        byte[] attributeLengthBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.ATTRIBUTE_LENGTH_BYTES);
        int attributeLength = Integer.valueOf(ByteUtils.bytesToHex(attributeLengthBytes), DecompileConstants.HEX_RADIX);
        lineNumberTableInfo.setAttributeLength(attributeLength);
        
        // 2.读取start_pc和line_number之间对应关系的数目
        byte[] lineNumberTableLengthBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.CODE_LINE_NUMBER_TABLE_BYTE);
        int lineNumberTableLength = Integer.valueOf(ByteUtils.bytesToHex(lineNumberTableLengthBytes), DecompileConstants.CODE_LINE_NUMBER_TABLE_BYTE);
        lineNumberTableInfo.setLineNumberTableLength(lineNumberTableLength);
        
        // 3.依次读取每一个字节码和源代码行号的对应记录
        for (int i = 0; i < lineNumberTableLength; ++i) {
            // 3.0 读取start_pc所占的字节数组
            byte[] startPCBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.CODE_LINE_NUMBER_TABLE_BYTE);
            int startPC = Integer.valueOf(ByteUtils.bytesToHex(startPCBytes), DecompileConstants.HEX_RADIX);
            
            // 3.1 读取line_number所占的字节数组
            byte[] lineNumberBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.CODE_LINE_NUMBER_TABLE_BYTE);
            int lineNumber = Integer.valueOf(ByteUtils.bytesToHex(lineNumberBytes), DecompileConstants.HEX_RADIX);
            
            lineNumberTableInfo.addPcNumberMap(startPC, lineNumber);
        }
        
        return (AttributeInfo)lineNumberTableInfo;
    }
}
