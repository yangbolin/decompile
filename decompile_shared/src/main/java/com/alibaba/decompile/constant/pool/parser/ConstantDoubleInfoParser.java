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
import com.alibaba.decompile.constant.pool.impl.ConstantDoubleInfo;
import com.alibaba.decompile.context.ByteCodeContext;

/**
 * <pre>
 * 类ParseConstantDoubleInfo.java的实现描述：常量池中的Double型数字的解析
 * </pre>
 * 
 * @author yangbolin Jan 2, 2013 4:46:06 PM
 */
public class ConstantDoubleInfoParser implements ConstantInfoParser {
    
    private static final String CONSTANT_DOUBLE = "Double";

    @Override
    public ConstantInfo parse(ByteCodeContext byteCodeContext) {
        // 0.创建返回值对象
        ConstantDoubleInfo constantInfo = new ConstantDoubleInfo();
        constantInfo.setTag(ConstantType.CONSTANT_DOUBLE_TAG.getIntValue());
        constantInfo.setTagString(CONSTANT_DOUBLE);
        constantInfo.setByteNum(DecompileConstants.CONSTANT_DOUBLE_BYTES);
        
        // 1.读取Double型常量所占的字节数组
        byte[] valueBytes = byteCodeContext.getSpecifiedByteCodeArray(constantInfo.getByteNum());
        constantInfo.setValue(ByteUtils.bytesToDouble(valueBytes));
        
        return (ConstantInfo)constantInfo;
    }
}
