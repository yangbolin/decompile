/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common.operand.impl;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.decompile.common.ByteCode;
import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.common.operand.ByteCodeOperandParser;
import com.alibaba.decompile.common.operand.NewarrayByteCode;
import com.alibaba.decompile.common.utils.ByteUtils;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.factory.DecompileFactory;

/**
 * <pre>
 * 类NewarrayByteCodeOperandParser.java的实现描述：对应newarray字节码操作数的解析器
 * </pre>
 * 
 * @author yangbolin Jan 6, 2013 8:24:27 PM
 */
public class NewarrayByteCodeOperandParser implements ByteCodeOperandParser {

    /** newarray对应类型的Hash表 **/
    private static Map<Integer, String> typeMap = new HashMap<Integer, String>();
    
    static {
        typeMap.put(4, "bool");
        typeMap.put(5, "char");
        typeMap.put(6, "float");
        typeMap.put(7, "double");
        typeMap.put(8, "byte");
        typeMap.put(9, "short");
        typeMap.put(10, "int");
        typeMap.put(11, "long");
    }

    @Override
    public ByteCode parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.创建返回值对象
        NewarrayByteCode byteCode = new NewarrayByteCode();
        byteCode.setOperandBytes(DecompileConstants.OPERAND_ONE_BYTE);

        // 1.读取类型对应数字所占的字节数组
        byte[] typeBytes = byteCodeContext.getSpecifiedByteCodeArray(byteCode.getOperandBytes());
        int type = ByteUtils.bytesToInt(typeBytes);
        byteCode.setTypeString(typeMap.get(type));

        return (ByteCode) byteCode;
    }
}
