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
import com.alibaba.decompile.constant.pool.impl.ConstantUTF8Info;
import com.alibaba.decompile.context.ByteCodeContext;

/**
 * <pre>
 * ��ConstantUTF8InfoParser.java��ʵ��������������������UTF8���͵��ַ���
 * </pre>
 * 
 * @author yangbolin Jan 2, 2013 4:51:58 PM
 */
public class ConstantUTF8InfoParser implements ConstantInfoParser {
    
    private static final String CONSTANT_UTF8 = "Asciz";
    @Override
    public ConstantInfo parse(ByteCodeContext byteCodeContext) {
        // 0.��������ֵ����
        ConstantUTF8Info constantInfo = new ConstantUTF8Info();
        constantInfo.setTag(ConstantType.CONSTANT_UTF8_STR_TAG.getIntValue());
        constantInfo.setTagString(CONSTANT_UTF8);
        
        // 1.��ȡ�ַ���������ռ���ֽ�����
        byte[] lengthBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.CONSTANT_UTF8STRING_LENGTH_BYTES);
        int length = ByteUtils.bytesToInt(lengthBytes);
        
        // 2.��ȡUTF8���͵��ַ�����ռ���ֽ�����
        byte[] utf8StringBytes = byteCodeContext.getSpecifiedByteCodeArray(length);
        
        try {
            constantInfo.setUtf8String(new String(utf8StringBytes, "UTF-8").toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        
        return (ConstantInfo)constantInfo;
    }
}
