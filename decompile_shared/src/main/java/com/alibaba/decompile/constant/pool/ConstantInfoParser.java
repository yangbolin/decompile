/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.constant.pool;

import com.alibaba.decompile.context.ByteCodeContext;

/**
 * <pre>
 * 类ParseConstantPool.java的实现描述：常量池中常量的解析接口
 * </pre>
 * @author yangbolin Jan 2, 2013 4:42:48 PM
 */
public interface ConstantInfoParser {
    /**
     * <pre>
     * 解析常量
     * </pre>
     * @param byteCodeContext
     * @return
     */
    public ConstantInfo parse(ByteCodeContext byteCodeContext);
}
