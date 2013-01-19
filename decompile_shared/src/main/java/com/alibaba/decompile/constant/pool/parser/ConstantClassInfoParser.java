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
import com.alibaba.decompile.constant.pool.impl.ConstantClassInfo;
import com.alibaba.decompile.context.ByteCodeContext;

/**
 * <pre>
 * ��ParseConstantClassInfo.java��ʵ��������������������߽ӿڵķ�������
 * </pre>
 * 
 * @author yangbolin Jan 2, 2013 4:45:06 PM
 */
public class ConstantClassInfoParser implements ConstantInfoParser {

    private static final String CONSTANT_CLASS = "class";

    @Override
    public ConstantInfo parse(ByteCodeContext byteCodeContext) {
        // 0.��������ֵ����
        ConstantClassInfo constantInfo = new ConstantClassInfo();
        constantInfo.setTag(ConstantType.CONSTANT_CLASS_TAG.getIntValue());
        constantInfo.setTagString(CONSTANT_CLASS);
        
        // 1.�������ӿ�������ռ���ֽ���Ŀ
        constantInfo.setIndexByteNum(DecompileConstants.CONSTANT_CLASS_BYTES);
        
        // 2.��ȡ���ӿ�������ռ���ֽ�����
        byte[] indexBytes = byteCodeContext.getSpecifiedByteCodeArray(constantInfo.getIndexByteNum());
        
        // 3. bytes to int
        int index = Integer.valueOf(ByteUtils.bytesToHex(indexBytes), DecompileConstants.HEX_RADIX);
        constantInfo.setIndexValue(index);
        
        return (ConstantInfo) constantInfo;
    }
}
