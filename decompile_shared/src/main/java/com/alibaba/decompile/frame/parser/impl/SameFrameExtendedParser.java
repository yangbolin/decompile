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
import com.alibaba.decompile.frame.SameFrameExtended;
import com.alibaba.decompile.frame.parser.FrameParser;

/**
 * @author yangbolin Jan 26, 2013 3:57:23 PM
 */
public class SameFrameExtendedParser implements FrameParser {
    private static final String NAME = "same_frame_extended";
    @Override
    public SMTPFrame parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory, int type) {
        SameFrameExtended frame = new SameFrameExtended();
        frame.setType(type);
        frame.setName(NAME);
        
        byte[] offsetBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.FRAME_OFFSET_BYTES);
        int offset = ByteUtils.bytesToInt(offsetBytes);
        frame.setOffsetDelta(offset);
        
        return (SMTPFrame)frame;
    }
}
