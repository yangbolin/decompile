/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common.operand;

import com.alibaba.decompile.common.ByteCode;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.factory.DecompileFactory;

/**
 * <pre>
 * 类AbstractByteCodeParser.java的实现描述：字节码解析器接口
 * </pre>
 * 
 * @author yangbolin Dec 30, 2012 9:22:42 AM
 */
public interface ByteCodeOperandParser {
    
    /**
     * <pre>
     * 字节码解析器的抽象类
     * </pre>
     * 
     * @param byteCodeContext
     * @return
     */
    public ByteCode parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory);
}
