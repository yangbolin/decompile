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
import com.alibaba.decompile.constant.pool.impl.ConstantFieldRefInfo;
import com.alibaba.decompile.context.ByteCodeContext;

/**
 * <pre>
 * 类ConstantFieldRefParser.java的实现描述：常量池中字段常量的解析
 * </pre>
 * 
 * @author yangbolin Jan 2, 2013 4:48:25 PM
 */
public class ConstantFieldRefInfoParser implements ConstantInfoParser {

    private static final String CONSTAN_FIELD = "Field";

    @Override
    public ConstantInfo parse(ByteCodeContext byteCodeContext) {
        // 0.创建返回值对象
        ConstantFieldRefInfo constantInfo = new ConstantFieldRefInfo();
        constantInfo.setTag(ConstantType.CONSTANT_FIELD_REF_TAG.getIntValue());
        constantInfo.setTagString(CONSTAN_FIELD);
        constantInfo.setClassIndexByteNum(DecompileConstants.CONSTANT_METHOD_CLASS_BYTES);
        constantInfo.setDescriptorByteNum(DecompileConstants.CONSTANT_METHOD_DESCRIPTOR_BYTES);
        
        // 1.读取方法所在的类在常量池中的索引所占的字节数组
        byte[] classIndexBytes = byteCodeContext.getSpecifiedByteCodeArray(constantInfo.getClassIndexByteNum());
        int classIndex = Integer.valueOf(ByteUtils.bytesToHex(classIndexBytes), DecompileConstants.HEX_RADIX);
        constantInfo.setClassIndexValue(classIndex);
        
        // 2.读取方法描述符在常量池中所占的字节数组
        byte[] descriptorIndexBytes = byteCodeContext.getSpecifiedByteCodeArray(constantInfo.getDescriptorByteNum());
        int descriptor = Integer.valueOf(ByteUtils.bytesToHex(descriptorIndexBytes), DecompileConstants.HEX_RADIX);
        constantInfo.setDescriptorValue(descriptor);
        
        return (ConstantInfo)constantInfo;
    }
}
