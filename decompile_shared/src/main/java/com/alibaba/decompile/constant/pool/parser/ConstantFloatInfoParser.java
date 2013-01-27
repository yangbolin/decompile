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
import com.alibaba.decompile.constant.pool.impl.ConstantFloatInfo;
import com.alibaba.decompile.context.ByteCodeContext;

/**
 * <pre>
 * ��ConstantFloatInfoParser.java��ʵ����������������Float�ͳ����Ľ���
 * </pre>
 * 
 * @author yangbolin Jan 2, 2013 4:48:49 PM
 */
public class ConstantFloatInfoParser implements ConstantInfoParser {

    private static final String CONSTANT_FLOAT = "Float";

    @Override
    public ConstantInfo parse(ByteCodeContext byteCodeContext) {
        // 0.��������ֵ����
        ConstantFloatInfo constantInfo = new ConstantFloatInfo();
        constantInfo.setTag(ConstantType.CONSTANT_FLOAT_TAG.getIntValue());
        constantInfo.setTagString(CONSTANT_FLOAT);
        constantInfo.setByteNum(DecompileConstants.CONSTANT_FLOAT_BYTES);
        
        // 1.��ȡ��������Float�ͳ�����ռ���ֽ�����
        byte[] valueBytes = byteCodeContext.getSpecifiedByteCodeArray(constantInfo.getByteNum());
        constantInfo.setValue(ByteUtils.bytesToFloat(valueBytes));

        return (ConstantInfo) constantInfo;
    }
}
