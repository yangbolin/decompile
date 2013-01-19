/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common;

import com.alibaba.decompile.attribute.info.AttributeInfo;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.factory.DecompileFactory;

/**
 * 类ArrtibuteParse.java的实现描述：字段或者方法附加属性的解析接口
 * 
 * @author yangbolin Dec 26, 2012 9:37:40 PM
 */
public interface ArrtibuteParser {

    /**
     * <pre>
     * 解析出字段的一些附件属性
     * </pre>
     * 
     * @param bytecodeContext
     * @param decompileFactory
     * @return
     */
    public AttributeInfo parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory);
}
