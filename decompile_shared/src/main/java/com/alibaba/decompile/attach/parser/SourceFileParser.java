/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.attach.parser;

import com.alibaba.decompile.attribute.info.AttributeInfo;
import com.alibaba.decompile.attribute.info.SourceFileInfo;
import com.alibaba.decompile.common.ArrtibuteParser;
import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.common.utils.ByteUtils;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.context.impl.ConstantPoolContext;
import com.alibaba.decompile.factory.DecompileFactory;

/**
 * <pre>
 * ��SourceFileParser.java��ʵ��������Դ�ļ����ƵĽ���
 * </pre>
 *  
 * @author yangbolin Jan 27, 2013 4:55:05 PM
 */
public class SourceFileParser implements ArrtibuteParser {

    @Override
    public AttributeInfo parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.��������ֵ����
        SourceFileInfo sourceFileInfo = new SourceFileInfo();
        
        // 1.��ȡ���Գ���
        byte[] lengthBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.ATTRIBUTE_LENGTH_BYTES);
        int length = ByteUtils.bytesToInt(lengthBytes);
        sourceFileInfo.setAttributeLength(length);
        
        // 2.��ȡ������ռ������
        byte[] indexBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.SOURCE_FILE_INDEX_BYTES);
        int index = ByteUtils.bytesToInt(indexBytes);
        
        // 3.��ȡ����
        ConstantPoolContext context = (ConstantPoolContext)decompileFactory.getDecompileContext(DecompileConstants.CONSTANT_POOL_CONTEXT);
        String name = context.getUTF8tringByIndex(index);
        sourceFileInfo.setSourceName(name);
        
        return (AttributeInfo)sourceFileInfo;
    }
}
