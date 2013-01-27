/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.attach.factory;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.decompile.attach.parser.InnerClassesParser;
import com.alibaba.decompile.attach.parser.SourceFileParser;
import com.alibaba.decompile.common.ArrtibuteParser;

/**
 * <pre>
 * 类AttachAttributeParserFactory.java的实现描述：附加属性的解析器工厂
 * </pre>
 * 
 * @author yangbolin Jan 27, 2013 4:56:15 PM
 */
public class AttachAttributeParserFactory {

    private static String                       SOURCE_FILE   = "SourceFile";
    private static String                       INNER_CLASSES = "InnerClasses";

    private static Map<String, ArrtibuteParser> parserMap     = new HashMap<String, ArrtibuteParser>();

    static {
        parserMap.put(SOURCE_FILE, new SourceFileParser());
        parserMap.put(INNER_CLASSES, new InnerClassesParser());
    }

    public static ArrtibuteParser getSpecificParser(String name) {
        return parserMap.get(name);
    }
}
