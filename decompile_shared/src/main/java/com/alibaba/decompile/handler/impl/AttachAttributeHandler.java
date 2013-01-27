/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.handler.impl;

import com.alibaba.decompile.attach.factory.AttachAttributeParserFactory;
import com.alibaba.decompile.attribute.info.AttributeInfo;
import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.common.utils.ByteUtils;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.context.impl.AttachAttributeContext;
import com.alibaba.decompile.context.impl.ConstantPoolContext;
import com.alibaba.decompile.factory.DecompileFactory;
import com.alibaba.decompile.handler.DecompileHandler;

/**
 * <pre>
 * ��AttachAttributeHandler.java��ʵ���������������ԵĽ���
 * </pre>
 *  
 * @author yangbolin Jan 27, 2013 4:49:25 PM
 */
public class AttachAttributeHandler extends DecompileHandler {
    
    private AttachAttributeContext attachAttributeContext;

    @Override
    public void parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        
        System.out.println("***PARSE ATTACH ATTRIBUTE***");
        
        this.attachAttributeContext = new AttachAttributeContext();
        
        // 0.��ȡ�������Ե���Ŀ
        byte[] attributeNumBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.ATTACH_ATTRIBUTE_NUM_BYTES);
        int attributeNum = ByteUtils.bytesToInt(attributeNumBytes);
        
        ConstantPoolContext context = (ConstantPoolContext)decompileFactory.getDecompileContext(DecompileConstants.CONSTANT_POOL_CONTEXT);
        
        // 1.���ν���ÿһ������
        for (int i = 0; i < attributeNum; ++i) {
            // 1.0 ��ȡ��������
            byte[] nameIndexBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.ATTRIBUTE_NAME_INDEX_BYTES);
            int nameIndex = ByteUtils.bytesToInt(nameIndexBytes);
            String name = context.getUTF8tringByIndex(nameIndex);
            
            // 1.1 ���ԵĽ���
            AttributeInfo attributeInfo = AttachAttributeParserFactory.getSpecificParser(name).parse(byteCodeContext, decompileFactory);
            attributeInfo.setAttributeName(name);
            attributeInfo.setAttributeNameIndex(nameIndex);
            
            this.attachAttributeContext.addAttributeInfo(attributeInfo);
        }
        
        // 2.�������Ե����
        System.out.println(this.attachAttributeContext.toString());
        System.out.println("***PARSE STOP SUCCESSFULLY***");
    }
}
