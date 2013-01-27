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
import com.alibaba.decompile.frame.FullFrame;
import com.alibaba.decompile.frame.SMTPFrame;
import com.alibaba.decompile.frame.factory.TypeInfoParserFactory;
import com.alibaba.decompile.frame.info.VerificationTypeInfo;
import com.alibaba.decompile.frame.parser.FrameParser;

/**
 * @author yangbolin Jan 26, 2013 4:29:30 PM
 */
public class FullFrameParser implements FrameParser {

    private static final String NAME                        = "full_name";
    private static final int    NUMBER_OF_LOCAS_BYTES       = 2;
    private static final int    NUMBER_OF_STACK_ITEMS_BYTES = 2;

    @Override
    public SMTPFrame parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory, int type) {
        FullFrame frame = new FullFrame();
        frame.setType(type);
        frame.setName(NAME);

        byte[] offsetBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.FRAME_OFFSET_BYTES);
        int offset = ByteUtils.bytesToInt(offsetBytes);
        frame.setOffsetDelta(offset);

        byte[] numberOfLocalsBytes = byteCodeContext.getSpecifiedByteCodeArray(NUMBER_OF_LOCAS_BYTES);
        int numberOfLocals = ByteUtils.bytesToInt(numberOfLocalsBytes);
        frame.setNumberOfLocals(numberOfLocals);
        for (int i = 0; i < numberOfLocals; ++i) {
            byte[] typeInfoBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.FRAME_TYPE_INFO_BYTES);
            int typeInfo = ByteUtils.bytesToInt(typeInfoBytes);
            VerificationTypeInfo verificationTypeInfo = TypeInfoParserFactory.getSpecificParser(typeInfo).parse(byteCodeContext,
                                                                                                                decompileFactory);
            verificationTypeInfo.setTag(typeInfo);
            frame.addLocalTypeInfo(verificationTypeInfo);
        }

        byte[] numberOfStackItemsBytes = byteCodeContext.getSpecifiedByteCodeArray(NUMBER_OF_STACK_ITEMS_BYTES);
        int numberOfStackItems = ByteUtils.bytesToInt(numberOfStackItemsBytes);
        frame.setNumberOfStackItems(numberOfStackItems);
        for (int i = 0; i < numberOfStackItems; ++i) {
            byte[] typeInfoBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.FRAME_TYPE_INFO_BYTES);
            int typeInfo = ByteUtils.bytesToInt(typeInfoBytes);
            VerificationTypeInfo verificationTypeInfo = TypeInfoParserFactory.getSpecificParser(typeInfo).parse(byteCodeContext,
                                                                                                                decompileFactory);
            verificationTypeInfo.setTag(typeInfo);
            frame.addStackTypeInfo(verificationTypeInfo);
        }

        return (SMTPFrame) frame;
    }
}
