/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.constant.pool.parser;

import com.alibaba.decompile.common.ByteUtils;
import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.constant.pool.ConstantInfo;
import com.alibaba.decompile.constant.pool.ConstantInfoParser;
import com.alibaba.decompile.constant.pool.ConstantType;
import com.alibaba.decompile.constant.pool.impl.ConstantIntegerInfo;
import com.alibaba.decompile.context.ByteCodeContext;

/**
 * <pre>
 * ��ConstantIntegerInfoParser.java��ʵ����������������Integer���ͳ����Ľ���
 * </pre>
 * 
 * @author yangbolin Jan 2, 2013 4:49:19 PM
 */
public class ConstantIntegerInfoParser implements ConstantInfoParser {
    private static final String CONSTANT_INTEGER = "Integer";
    @Override
    public ConstantInfo parse(ByteCodeContext byteCodeContext) {
        // 0.��������ֵ����
        ConstantIntegerInfo constantInfo = new ConstantIntegerInfo();
        constantInfo.setTag(ConstantType.CONSTANT_INTEGER_TAG.getIntValue());
        constantInfo.setTagString(CONSTANT_INTEGER);
        constantInfo.setByteNum(DecompileConstants.CONSTANT_INTEGER_BYTES);
        
        // 1.��ȡ��������Integer�ͳ�����ռ���ֽ�����
        byte[] valueBytes = byteCodeContext.getSpecifiedByteCodeArray(constantInfo.getByteNum());
        int value = Integer.valueOf(ByteUtils.bytesToHex(valueBytes), DecompileConstants.HEX_RADIX);
        constantInfo.setValue(value);
        
        return (ConstantInfo)constantInfo;
    }
}
