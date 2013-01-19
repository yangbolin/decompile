/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common.operand.impl;

import com.alibaba.decompile.common.ByteCode;
import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.common.operand.ByteCodeOperandParser;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.factory.DecompileFactory;

/**
 * <pre>
 * 类NoOperantByteCodeParser.java的实现描述：没有参数的字节码解析器
 * 注意:
 * 这里无参字节码解析器的存在就是为了保证代码的统一，实现接口的方法后不做
 * 任何处理，只返回一个待填充的字节码空壳子 
 * </pre>
 * @author yangbolin Dec 30, 2012 9:30:54 AM
 */
public class NoOperandByteCodeParser implements ByteCodeOperandParser {

    @Override
    public ByteCode parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        ByteCode byteCode = new ByteCode();
        
        byteCode.setTotalBytes(DecompileConstants.BYTE_CODE_SYMBOL_CODE_BYTE);
        
        return byteCode;
    }
}
