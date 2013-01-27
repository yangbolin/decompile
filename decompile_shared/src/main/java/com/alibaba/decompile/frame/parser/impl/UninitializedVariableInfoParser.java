/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.frame.parser.impl;

import com.alibaba.decompile.common.utils.ByteUtils;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.factory.DecompileFactory;
import com.alibaba.decompile.frame.info.UninitializedVariableInfo;
import com.alibaba.decompile.frame.info.VerificationTypeInfo;
import com.alibaba.decompile.frame.parser.TypeInfoParser;

/**
 * @author yangbolin Jan 26, 2013 3:02:47 PM
 */
public class UninitializedVariableInfoParser implements TypeInfoParser {

    private static final String NAME         = "uninitialized";
    private static final int    OFFSET_BYTES = 2;

    @Override
    public VerificationTypeInfo parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        UninitializedVariableInfo typeInfo = new UninitializedVariableInfo();
        typeInfo.setName(NAME);
        
        byte[] offsetBytes = byteCodeContext.getSpecifiedByteCodeArray(OFFSET_BYTES);
        int offset = ByteUtils.bytesToInt(offsetBytes);
        typeInfo.setOffset(offset);
        
        return (VerificationTypeInfo)typeInfo;
    }
}
