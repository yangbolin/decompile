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
 * 类ParseConstantClassInfo.java的实现描述：常量池中类或者接口的符号引用
 * </pre>
 * 
 * @author yangbolin Jan 2, 2013 4:45:06 PM
 */
public class ConstantClassInfoParser implements ConstantInfoParser {

    private static final String CONSTANT_CLASS = "class";

    @Override
    public ConstantInfo parse(ByteCodeContext byteCodeContext) {
        // 0.创建返回值对象
        ConstantClassInfo constantInfo = new ConstantClassInfo();
        constantInfo.setTag(ConstantType.CONSTANT_CLASS_TAG.getIntValue());
        constantInfo.setTagString(CONSTANT_CLASS);
        
        // 1.设置类或接口索引所占的字节数目
        constantInfo.setIndexByteNum(DecompileConstants.CONSTANT_CLASS_BYTES);
        
        // 2.读取类或接口索引所占的字节数组
        byte[] indexBytes = byteCodeContext.getSpecifiedByteCodeArray(constantInfo.getIndexByteNum());
        
        // 3. bytes to int
        int index = Integer.valueOf(ByteUtils.bytesToHex(indexBytes), DecompileConstants.HEX_RADIX);
        constantInfo.setIndexValue(index);
        
        return (ConstantInfo) constantInfo;
    }
}
