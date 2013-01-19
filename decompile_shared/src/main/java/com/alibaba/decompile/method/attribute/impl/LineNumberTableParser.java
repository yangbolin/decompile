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
 * ��LineNumberTableParser.java��ʵ���������ֽ����Դ�����кŵĶ�Ӧ��ϵ
 * </pre>
 *  
 * @author yangbolin Jan 13, 2013 7:01:04 PM
 */
public class LineNumberTableParser implements ArrtibuteParser {

    @Override
    public AttributeInfo parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.��������ֵ����
        LineNumberTableInfo lineNumberTableInfo = new LineNumberTableInfo();
        
        // 1.��ȡ���Եĳ�����ռ���ֽ�����
        byte[] attributeLengthBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.ATTRIBUTE_LENGTH_BYTES);
        int attributeLength = Integer.valueOf(ByteUtils.bytesToHex(attributeLengthBytes), DecompileConstants.HEX_RADIX);
        lineNumberTableInfo.setAttributeLength(attributeLength);
        
        // 2.��ȡstart_pc��line_number֮���Ӧ��ϵ����Ŀ
        byte[] lineNumberTableLengthBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.CODE_LINE_NUMBER_TABLE_BYTE);
        int lineNumberTableLength = Integer.valueOf(ByteUtils.bytesToHex(lineNumberTableLengthBytes), DecompileConstants.CODE_LINE_NUMBER_TABLE_BYTE);
        lineNumberTableInfo.setLineNumberTableLength(lineNumberTableLength);
        
        // 3.���ζ�ȡÿһ���ֽ����Դ�����кŵĶ�Ӧ��¼
        for (int i = 0; i < lineNumberTableLength; ++i) {
            // 3.0 ��ȡstart_pc��ռ���ֽ�����
            byte[] startPCBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.CODE_LINE_NUMBER_TABLE_BYTE);
            int startPC = Integer.valueOf(ByteUtils.bytesToHex(startPCBytes), DecompileConstants.HEX_RADIX);
            
            // 3.1 ��ȡline_number��ռ���ֽ�����
            byte[] lineNumberBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.CODE_LINE_NUMBER_TABLE_BYTE);
            int lineNumber = Integer.valueOf(ByteUtils.bytesToHex(lineNumberBytes), DecompileConstants.HEX_RADIX);
            
            lineNumberTableInfo.addPcNumberMap(startPC, lineNumber);
        }
        
        return (AttributeInfo)lineNumberTableInfo;
    }
}
