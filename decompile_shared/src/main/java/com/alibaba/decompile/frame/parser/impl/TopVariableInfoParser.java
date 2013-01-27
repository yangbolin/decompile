/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.frame.parser.impl;

import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.factory.DecompileFactory;
import com.alibaba.decompile.frame.info.TopVariableInfo;
import com.alibaba.decompile.frame.info.VerificationTypeInfo;
import com.alibaba.decompile.frame.parser.TypeInfoParser;

/**
 * @author yangbolin Jan 26, 2013 2:17:39 PM
 */
public class TopVariableInfoParser implements TypeInfoParser {

    private static final String NAME = "top";

    @Override
    public VerificationTypeInfo parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        TopVariableInfo typeInfo = new TopVariableInfo();
        typeInfo.setName(NAME);
        return (TopVariableInfo) typeInfo;
    }
}
