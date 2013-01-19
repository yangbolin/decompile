/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.handler;

import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.factory.DecompileFactory;

/**
 * ��DecompileHandler.java��ʵ��������������ĳ������
 * 
 * @author yangbolin Dec 7, 2012 9:16:26 AM
 */
public abstract class DecompileHandler {

    /** ��һ�׶εķ����봦�� **/
    private DecompileHandler nextHandler;
    
    public abstract void parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory);

    public DecompileHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(DecompileHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
