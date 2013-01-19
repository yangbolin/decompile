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
 * ��ParseConstantPool.java��ʵ���������������г����Ľ����ӿ�
 * </pre>
 * @author yangbolin Jan 2, 2013 4:42:48 PM
 */
public interface ConstantInfoParser {
    /**
     * <pre>
     * ��������
     * </pre>
     * @param byteCodeContext
     * @return
     */
    public ConstantInfo parse(ByteCodeContext byteCodeContext);
}
