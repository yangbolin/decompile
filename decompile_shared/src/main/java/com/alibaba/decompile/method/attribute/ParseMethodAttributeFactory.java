/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.method.attribute;

import java.util.HashMap;
import java.util.Map;
import com.alibaba.decompile.common.ArrtibuteParser;
import com.alibaba.decompile.common.DeprecatedInfoParser;
import com.alibaba.decompile.common.SyntheticInfoParser;
import com.alibaba.decompile.method.attribute.impl.LineNumberTableParser;
import com.alibaba.decompile.method.attribute.impl.LocalVariableTableParser;
import com.alibaba.decompile.method.attribute.impl.MethodCodeParser;
import com.alibaba.decompile.method.attribute.impl.MethodExceptionsParser;

/**
 * <pre>
 * ��MethodAttributeFactory.java��ʵ���������������Թ���
 * </pre>
 * 
 * @author yangbolin Dec 26, 2012 9:33:18 PM
 */
public class ParseMethodAttributeFactory {

    private static final String                 CODE               = "Code";
    private static final String                 DEPRECATED         = "Deprecated";
    private static final String                 EXCEPTIONS         = "Exceptions";
    private static final String                 SYNTHETIC          = "Synthetic";
    private static final String                 LINENUMBERTABLE    = "LineNumberTable";
    private static final String                 LOCALVARIABLETABLE = "LocalVariableTable";

    /** һ��map���͵����ݽṹ���洢���������Խ����� **/
    private static Map<String, ArrtibuteParser> attributeSpecMap   = new HashMap<String, ArrtibuteParser>();

    static {
        attributeSpecMap.put(CODE, new MethodCodeParser());
        attributeSpecMap.put(DEPRECATED, new DeprecatedInfoParser());
        attributeSpecMap.put(EXCEPTIONS, new MethodExceptionsParser());
        attributeSpecMap.put(SYNTHETIC, new SyntheticInfoParser());
        attributeSpecMap.put(LINENUMBERTABLE, new LineNumberTableParser());
        attributeSpecMap.put(LOCALVARIABLETABLE, new LocalVariableTableParser());
    }

    public static ArrtibuteParser getSpecParser(String name) {
        return attributeSpecMap.get(name);
    }
}
