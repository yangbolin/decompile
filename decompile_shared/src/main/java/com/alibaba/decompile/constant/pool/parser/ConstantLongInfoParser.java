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
import com.alibaba.decompile.constant.pool.impl.ConstantLongInfo;
import com.alibaba.decompile.context.ByteCodeContext;

/**
 * <pre>
 * 类ConstantLongInfoParser.java的实现描述：解析常量池中的Long型常量
 * </pre>
 * 
 * @author yangbolin Jan 2, 2013 4:50:19 PM
 */
public class ConstantLongInfoParser implements ConstantInfoParser {

    private static final String CONSTANT_LONG = "Long";

    @Override
    public ConstantInfo parse(ByteCodeContext byteCodeContext) {
        // 0.创建返回值对象
        ConstantLongInfo constantInfo = new ConstantLongInfo();
        constantInfo.setTag(ConstantType.CONSTANT_LONG_TAG.getIntValue());
        constantInfo.setTagString(CONSTANT_LONG);
        constantInfo.setByteNum(DecompileConstants.CONSTANT_LONG_BYTES);
        
        // 1.读取Long型常量在常量池中所占的字节数组
        byte[] valueBytes = byteCodeContext.getSpecifiedByteCodeArray(constantInfo.getByteNum());
        int value = Integer.valueOf(ByteUtils.bytesToHex(valueBytes), DecompileConstants.HEX_RADIX);
        constantInfo.setValue(value);
        
        return (ConstantInfo)constantInfo;
    }
}
