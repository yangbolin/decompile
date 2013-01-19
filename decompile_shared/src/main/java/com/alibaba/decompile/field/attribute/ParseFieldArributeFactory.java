/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.field.attribute;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.decompile.common.ArrtibuteParser;
import com.alibaba.decompile.common.DeprecatedInfoParser;
import com.alibaba.decompile.common.SyntheticInfoParser;
import com.alibaba.decompile.field.attribute.impl.FieldConstantValueParser;

/**
 * 类FieldArribute.java的实现描述：字段属性
 * 
 * @author yangbolin Dec 23, 2012 4:12:23 PM
 */
public class ParseFieldArributeFactory {

    private static final String                CONSTANT_VALUE   = "ConstantValue";
    private static final String                DEPRECATED       = "Deprecated";
    private static final String                SYNTHETIC        = "Synthetic";

    private static Map<String, ArrtibuteParser> attributeSpecMap = new HashMap<String, ArrtibuteParser>();

    static {
        attributeSpecMap.put(CONSTANT_VALUE, new FieldConstantValueParser());
        attributeSpecMap.put(DEPRECATED, new DeprecatedInfoParser());
        attributeSpecMap.put(SYNTHETIC, new SyntheticInfoParser());
    }

    /**
     * <pre>
     * 按照名称获取一个指定的属性解析器
     * </pre>
     * 
     * @param name
     * @return
     */
    public static ArrtibuteParser getSpecParser(String name) {
        return attributeSpecMap.get(name);
    }
}
