/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.frame.parser;

import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.factory.DecompileFactory;
import com.alibaba.decompile.frame.info.VerificationTypeInfo;

/**
 * @author yangbolin Jan 26, 2013 2:12:28 PM
 */
public interface TypeInfoParser {

    public VerificationTypeInfo parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory);
}
