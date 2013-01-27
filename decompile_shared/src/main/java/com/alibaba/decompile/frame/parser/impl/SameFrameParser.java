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
import com.alibaba.decompile.frame.SMTPFrame;
import com.alibaba.decompile.frame.SameFrame;
import com.alibaba.decompile.frame.parser.FrameParser;

/**
 * @author yangbolin Jan 26, 2013 3:16:15 PM
 */
public class SameFrameParser implements FrameParser {

    private static final String NAME = "same_frame";
    @Override
    public SMTPFrame parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory, int type) {
        SameFrame frame = new SameFrame();
        frame.setType(type);
        frame.setName(NAME);
        frame.setOffsetDelta(type);
        return (SMTPFrame)frame;
    }
}
