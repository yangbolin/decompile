/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.frame.factory;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.decompile.frame.StackMapTableFrameType;
import com.alibaba.decompile.frame.parser.FrameParser;
import com.alibaba.decompile.frame.parser.impl.AppendFrameParser;
import com.alibaba.decompile.frame.parser.impl.ChopFrameParser;
import com.alibaba.decompile.frame.parser.impl.FullFrameParser;
import com.alibaba.decompile.frame.parser.impl.SameFrameExtendedParser;
import com.alibaba.decompile.frame.parser.impl.SameFrameParser;
import com.alibaba.decompile.frame.parser.impl.SameLocals1StackItemFrameExtendedParser;
import com.alibaba.decompile.frame.parser.impl.SameLocals1StackItemFrameParser;

/**
 * @author yangbolin Jan 26, 2013 2:05:05 PM
 */
public class FrameParserFactory {
    public static Map<String, FrameParser> parserMap = new HashMap<String, FrameParser>();
    
    static {
       parserMap.put(StackMapTableFrameType.SAME_FRAME.getValue(), new SameFrameParser());
       parserMap.put(StackMapTableFrameType.SAME_LOCALS_1_STACK_ITEM_FRAME.getValue(), new SameLocals1StackItemFrameParser());
       parserMap.put(StackMapTableFrameType.SAME_LOCALS_1_STACK_ITEM_FRAME_EXTENDED.getValue(), new SameLocals1StackItemFrameExtendedParser());
       parserMap.put(StackMapTableFrameType.CHOP_FRAME.getValue(), new ChopFrameParser());
       parserMap.put(StackMapTableFrameType.SAME_FRAME_EXTENDED.getValue(), new SameFrameExtendedParser());
       parserMap.put(StackMapTableFrameType.APPEND_FRAME.getValue(), new AppendFrameParser());
       parserMap.put(StackMapTableFrameType.FULL_FRAME.getValue(), new FullFrameParser());
    }
    
    public static FrameParser getSpecificParaser(String name) {
        return parserMap.get(name);
    }
}
