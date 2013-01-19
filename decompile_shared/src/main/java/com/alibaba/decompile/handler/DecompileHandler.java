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
 * 类DecompileHandler.java的实现描述：反编译的抽象基类
 * 
 * @author yangbolin Dec 7, 2012 9:16:26 AM
 */
public abstract class DecompileHandler {

    /** 下一阶段的反编译处理 **/
    private DecompileHandler nextHandler;
    
    public abstract void parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory);

    public DecompileHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(DecompileHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
