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
import com.alibaba.decompile.factory.DecompileFactory;
import com.alibaba.decompile.frame.SMTPFrame;
import com.alibaba.decompile.frame.SameLocals1StackItemFrame;
import com.alibaba.decompile.frame.factory.TypeInfoParserFactory;
import com.alibaba.decompile.frame.info.VerificationTypeInfo;
import com.alibaba.decompile.frame.parser.FrameParser;

/**
 * @author yangbolin Jan 26, 2013 3:27:41 PM
 */
public class SameLocals1StackItemFrameParser implements FrameParser {

    private static final String NAME = "same_locals_1_stack_item_frame";

    @Override
    public SMTPFrame parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory, int type) {
        SameLocals1StackItemFrame frame = new SameLocals1StackItemFrame();
        frame.setType(type);
        frame.setOffsetDelta(type - 64);
        frame.setName(NAME);
        
        byte[] typeInfoBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.FRAME_TYPE_INFO_BYTES);
        int typeInfo = ByteUtils.bytesToInt(typeInfoBytes);
        
        VerificationTypeInfo verificationTypeInfo = TypeInfoParserFactory.getSpecificParser(typeInfo).parse(byteCodeContext, decompileFactory);
        verificationTypeInfo.setTag(typeInfo);
        frame.setVerificationTypeInfo(verificationTypeInfo);
        
        return (SMTPFrame)frame;
    }
}
