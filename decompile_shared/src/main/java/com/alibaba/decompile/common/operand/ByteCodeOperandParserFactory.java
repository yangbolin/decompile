/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common.operand;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.decompile.common.operand.impl.AnewarrayByteCodeOperandParser;
import com.alibaba.decompile.common.operand.impl.IincByteCodeOperandParser;
import com.alibaba.decompile.common.operand.impl.InvokeMethodByteCodeOperandParser;
import com.alibaba.decompile.common.operand.impl.LookupSwitchByteCodeOperandParser;
import com.alibaba.decompile.common.operand.impl.MultianewarrayByteCodeOperandParser;
import com.alibaba.decompile.common.operand.impl.NewByteCodeOperandParser;
import com.alibaba.decompile.common.operand.impl.NoOperandByteCodeParser;
import com.alibaba.decompile.common.operand.impl.OnlyClassIndexByteCodeOperandParser;
import com.alibaba.decompile.common.operand.impl.OperateFieldByteCodeOperandParser;
import com.alibaba.decompile.common.operand.impl.RetByteCodeOperandParser;
import com.alibaba.decompile.common.operand.impl.SkipByteCodeOperandParser;
import com.alibaba.decompile.common.operand.impl.StoreLoadByteCodeOperandParser;
import com.alibaba.decompile.common.operand.impl.TableSwitchByteCodeOperandParser;

/**
 * <pre>
 * 类ByteCodeParserFactory.java的实现描述：字节码解析器的工厂
 * </pre>
 * 
 * @author yangbolin Dec 30, 2012 9:31:21 AM
 */
public class ByteCodeOperandParserFactory {

    private static Map<Integer, ByteCodeOperandParser> parserMap = new HashMap<Integer, ByteCodeOperandParser>();

    static {
        parserMap.put(ByteCodeOperandType.NONE.getIntValue(), new NoOperandByteCodeParser());
        parserMap.put(ByteCodeOperandType.SPECIAL_STORE_LOAD.getIntValue(), new StoreLoadByteCodeOperandParser());
        parserMap.put(ByteCodeOperandType.SPECIAL_IINC.getIntValue(), new IincByteCodeOperandParser());
        parserMap.put(ByteCodeOperandType.SPECIAL_SKIP.getIntValue(), new SkipByteCodeOperandParser());
        parserMap.put(ByteCodeOperandType.SPECIAL_RET.getIntValue(), new RetByteCodeOperandParser());
        parserMap.put(ByteCodeOperandType.SPECIAL_TABLESWITCH.getIntValue(), new TableSwitchByteCodeOperandParser());
        parserMap.put(ByteCodeOperandType.SPECIAL_LOOKUPSWITCH.getIntValue(), new LookupSwitchByteCodeOperandParser());
        parserMap.put(ByteCodeOperandType.SPECIAL_OPERATEFIELD.getIntValue(), new OperateFieldByteCodeOperandParser());
        parserMap.put(ByteCodeOperandType.SPECIAL_INVOKE_METHOD.getIntValue(), new InvokeMethodByteCodeOperandParser());
        parserMap.put(ByteCodeOperandType.SPECIAL_NEW.getIntValue(), new NewByteCodeOperandParser());
        parserMap.put(ByteCodeOperandType.SPECIAL_NEWARRAY.getIntValue(), new NewByteCodeOperandParser());
        parserMap.put(ByteCodeOperandType.SPECIAL_ANEWARRAY.getIntValue(), new AnewarrayByteCodeOperandParser());
        parserMap.put(ByteCodeOperandType.SPECIAL_MULTIANEWARRAY.getIntValue(),
                      new MultianewarrayByteCodeOperandParser());
        parserMap.put(ByteCodeOperandType.SPECAIL_ONLYCLASSINDEX.getIntValue(), new OnlyClassIndexByteCodeOperandParser());
        parserMap.put(ByteCodeOperandType.SPECIAL_SKIPWIDEBYTE.getIntValue(), new SkipByteCodeOperandParser());
    }

    /**
     * <pre>
     * 获取指定名称的解析器
     * </pre>
     * 
     * @param name
     * @return
     */
    public ByteCodeOperandParser getSpecParser(int type) {
        return parserMap.get(type);
    }
}
