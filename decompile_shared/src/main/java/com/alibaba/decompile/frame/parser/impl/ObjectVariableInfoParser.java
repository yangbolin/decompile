/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.frame.parser.impl;

import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.common.utils.ByteUtils;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.context.impl.ConstantPoolContext;
import com.alibaba.decompile.factory.DecompileFactory;
import com.alibaba.decompile.frame.info.ObjectVariableInfo;
import com.alibaba.decompile.frame.info.VerificationTypeInfo;
import com.alibaba.decompile.frame.parser.TypeInfoParser;

/**
 * @author yangbolin Jan 26, 2013 2:45:19 PM
 */
public class ObjectVariableInfoParser implements TypeInfoParser {

    private static final int INDEX_BYTES = 2;

    @Override
    public VerificationTypeInfo parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        ObjectVariableInfo typeInfo = new ObjectVariableInfo();
        ConstantPoolContext context = (ConstantPoolContext) decompileFactory.getDecompileContext(DecompileConstants.CONSTANT_POOL_CONTEXT);

        byte[] cpoolIndexBytes = byteCodeContext.getSpecifiedByteCodeArray(INDEX_BYTES);
        int cpoolIndex = ByteUtils.bytesToInt(cpoolIndexBytes);

        String name = context.getClassQualifiedName(cpoolIndex);
        typeInfo.setName(name);

        return (VerificationTypeInfo) typeInfo;
    }
}
