/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.constant.pool;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.decompile.constant.pool.parser.ConstantClassInfoParser;
import com.alibaba.decompile.constant.pool.parser.ConstantDoubleInfoParser;
import com.alibaba.decompile.constant.pool.parser.ConstantFieldRefInfoParser;
import com.alibaba.decompile.constant.pool.parser.ConstantFloatInfoParser;
import com.alibaba.decompile.constant.pool.parser.ConstantIntegerInfoParser;
import com.alibaba.decompile.constant.pool.parser.ConstantInterfaceMethodInfoParser;
import com.alibaba.decompile.constant.pool.parser.ConstantLongInfoParser;
import com.alibaba.decompile.constant.pool.parser.ConstantMethodInfoParser;
import com.alibaba.decompile.constant.pool.parser.ConstantNameAndTypeInfoParser;
import com.alibaba.decompile.constant.pool.parser.ConstantStringInfoParser;
import com.alibaba.decompile.constant.pool.parser.ConstantUTF8InfoParser;

/**
 * <pre>
 * 类ConstantInfoParserFactory.java的实现描述：常量池中常量的解析工厂
 * </pre>
 * 
 * @author yangbolin Jan 2, 2013 5:04:18 PM
 */
public class ConstantInfoParserFactory {
    /** 常量池中解析器集合 **/
    private static Map<Integer, ConstantInfoParser> parserMap = new HashMap<Integer, ConstantInfoParser>();
    
    static {
        parserMap.put(ConstantType.CONSTANT_CLASS_TAG.getIntValue(), new ConstantClassInfoParser());
        parserMap.put(ConstantType.CONSTANT_DOUBLE_TAG.getIntValue(), new ConstantDoubleInfoParser());
        parserMap.put(ConstantType.CONSTANT_FIELD_REF_TAG.getIntValue(), new ConstantFieldRefInfoParser());
        parserMap.put(ConstantType.CONSTANT_FLOAT_TAG.getIntValue(), new ConstantFloatInfoParser());
        parserMap.put(ConstantType.CONSTANT_INTEGER_TAG.getIntValue(), new ConstantIntegerInfoParser());
        parserMap.put(ConstantType.CONSTANT_INTERFACE_METHOD_REF_TAG.getIntValue(), new ConstantInterfaceMethodInfoParser());
        parserMap.put(ConstantType.CONSTANT_LONG_TAG.getIntValue(), new ConstantLongInfoParser());
        parserMap.put(ConstantType.CONSTANT_METHOD_REF_TAG.getIntValue(), new ConstantMethodInfoParser());
        parserMap.put(ConstantType.CONSTANT_NAME_ADN_TYPE_TAG.getIntValue(), new ConstantNameAndTypeInfoParser());
        parserMap.put(ConstantType.CONSTANT_STRING_TAG.getIntValue(), new ConstantStringInfoParser());
        parserMap.put(ConstantType.CONSTANT_UTF8_STR_TAG.getIntValue(), new ConstantUTF8InfoParser());
    }
    
    /**
     * <pre>
     * 根据type获取一个常量解析器
     * </pre>
     * @param type
     * @return
     */
    public ConstantInfoParser getParser(int type) {
        return parserMap.get(type);
    }
}
