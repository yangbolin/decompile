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
import com.alibaba.decompile.constant.pool.impl.ConstantStringInfo;
import com.alibaba.decompile.context.ByteCodeContext;

/**
 * <pre>
 * ��ConstantStringInfoParser.java��ʵ����������������String���ͳ����Ľ���
 * </pre>
 * 
 * @author yangbolin Jan 2, 2013 4:51:39 PM
 */
public class ConstantStringInfoParser implements ConstantInfoParser {

    private static final String CONSTANT_STRING = "String";

    @Override
    public ConstantInfo parse(ByteCodeContext byteCodeContext) {
        // 0.��������ֵ����
        ConstantStringInfo constantInfo = new ConstantStringInfo();
        constantInfo.setTag(ConstantType.CONSTANT_STRING_TAG.getIntValue());
        constantInfo.setTagString(CONSTANT_STRING);
        constantInfo.setIndexByteNum(DecompileConstants.CONSTANT_STRING_BYTES);
        
        // 1.��ȡString���͵ĳ����ڳ������е�������ռ���ֽ�����
        byte[] indexBytes = byteCodeContext.getSpecifiedByteCodeArray(constantInfo.getIndexByteNum());
        int index = Integer.valueOf(ByteUtils.bytesToHex(indexBytes), DecompileConstants.HEX_RADIX);
        constantInfo.setIndexValue(index);
        
        return (ConstantInfo)constantInfo;
    }

}
