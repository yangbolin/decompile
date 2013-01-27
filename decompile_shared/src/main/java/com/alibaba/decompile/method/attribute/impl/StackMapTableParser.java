/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.method.attribute.impl;

import com.alibaba.decompile.attribute.info.AttributeInfo;
import com.alibaba.decompile.attribute.info.StackMapTableInfo;
import com.alibaba.decompile.common.ArrtibuteParser;
import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.common.utils.ByteUtils;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.factory.DecompileFactory;
import com.alibaba.decompile.frame.SMTPFrame;
import com.alibaba.decompile.frame.StackMapTableFrameType;
import com.alibaba.decompile.frame.factory.FrameParserFactory;

/**
 * @author yangbolin Jan 26, 2013 4:51:52 PM
 */
public class StackMapTableParser implements ArrtibuteParser {

    @Override
    public AttributeInfo parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {

        // 0.创建返回值对象
        StackMapTableInfo stackMapTableInfo = new StackMapTableInfo();

        // 1.读取属性所占的字节长度
        byte[] attributeLengthBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.ATTRIBUTE_LENGTH_BYTES);
        int attributeLength = ByteUtils.bytesToInt(attributeLengthBytes);
        stackMapTableInfo.setAttributeLength(attributeLength);

        // 2.读取frame的数目
        byte[] frameEntriesBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.FRAME_ENTRIES_BYTES);
        int frameEntries = ByteUtils.bytesToInt(frameEntriesBytes);
        stackMapTableInfo.setNumberOfEntries(frameEntries);

        // 3. 依次去读取每一个frame
        for (int i = 0; i < frameEntries; ++i) {
            byte[] typeBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.FRAME_TAG_BYTES);
            int type = ByteUtils.bytesToInt(typeBytes);
            SMTPFrame frame = null;

            if (type >= 0 && type <= 63) {
                frame = FrameParserFactory.getSpecificParaser(StackMapTableFrameType.SAME_FRAME.getValue()).parse(byteCodeContext,
                                                                                                             decompileFactory,
                                                                                                             type);
            } else if (type >= 64 && type <= 127) {
                frame = FrameParserFactory.getSpecificParaser(StackMapTableFrameType.SAME_LOCALS_1_STACK_ITEM_FRAME.getValue()).parse(byteCodeContext,
                                                                                                                      decompileFactory,
                                                                                                                      type);
            } else if (type == 247) {
                frame = FrameParserFactory.getSpecificParaser(StackMapTableFrameType.SAME_LOCALS_1_STACK_ITEM_FRAME_EXTENDED.getValue()).parse(byteCodeContext,
                                                                                                                               decompileFactory,
                                                                                                                               type);
            } else if (type >= 248 && type <= 250) {
                frame = FrameParserFactory.getSpecificParaser(StackMapTableFrameType.CHOP_FRAME.getValue()).parse(byteCodeContext,
                                                                                                  decompileFactory,
                                                                                                  type);
            } else if (type == 251) {
                frame = FrameParserFactory.getSpecificParaser(StackMapTableFrameType.SAME_FRAME_EXTENDED.getValue()).parse(byteCodeContext,
                                                                                                           decompileFactory,
                                                                                                           type);
            } else if (type >= 252 && type <= 254) {
                frame = FrameParserFactory.getSpecificParaser(StackMapTableFrameType.APPEND_FRAME.getValue()).parse(byteCodeContext,
                                                                                                    decompileFactory,
                                                                                                    type);
            } else if (type == 255) {
                frame = FrameParserFactory.getSpecificParaser(StackMapTableFrameType.FULL_FRAME.getValue()).parse(byteCodeContext,
                                                                                                  decompileFactory,
                                                                                                  type);
            }
            
            frame.setType(type);
            stackMapTableInfo.addFrame(frame);
        }

        return (AttributeInfo) stackMapTableInfo;
    }
}
