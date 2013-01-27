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

import com.alibaba.decompile.frame.info.Info;
import com.alibaba.decompile.frame.parser.TypeInfoParser;
import com.alibaba.decompile.frame.parser.impl.DoubleVariableInfoParser;
import com.alibaba.decompile.frame.parser.impl.FloatVariableInfoParser;
import com.alibaba.decompile.frame.parser.impl.IntegerVariableInfoParser;
import com.alibaba.decompile.frame.parser.impl.LongVariableInfoParser;
import com.alibaba.decompile.frame.parser.impl.NullVariableInfoParser;
import com.alibaba.decompile.frame.parser.impl.ObjectVariableInfoParser;
import com.alibaba.decompile.frame.parser.impl.TopVariableInfoParser;
import com.alibaba.decompile.frame.parser.impl.UninitializedThisVariableInfoParser;
import com.alibaba.decompile.frame.parser.impl.UninitializedVariableInfoParser;

/**
 * @author yangbolin Jan 26, 2013 3:07:19 PM
 */
public class TypeInfoParserFactory {
    private static Map<Integer,TypeInfoParser> parserMap = new HashMap<Integer, TypeInfoParser>();
    
    static {
        parserMap.put(Info.TOP.getValue(), new TopVariableInfoParser());
        parserMap.put(Info.INT.getValue(), new IntegerVariableInfoParser());
        parserMap.put(Info.FLOAT.getValue(), new FloatVariableInfoParser());
        parserMap.put(Info.LONG.getValue(), new LongVariableInfoParser());
        parserMap.put(Info.DOUBLE.getValue(), new DoubleVariableInfoParser());
        parserMap.put(Info.NULL.getValue(), new NullVariableInfoParser());
        parserMap.put(Info.UNINITIALIZEDTHIS.getValue(), new UninitializedThisVariableInfoParser());
        parserMap.put(Info.UNINITIALIZED.getValue(), new UninitializedVariableInfoParser());
        parserMap.put(Info.OBJECT.getValue(), new ObjectVariableInfoParser());
    }
    
    public static TypeInfoParser getSpecificParser(int type) {
        return parserMap.get(type);
    }
}
