/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.handler.impl;

import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.common.utils.ByteUtils;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.context.impl.MagicContext;
import com.alibaba.decompile.factory.DecompileFactory;
import com.alibaba.decompile.handler.DecompileHandler;

/**
 * 类MagicHandler.java的实现描述：Class文件的魔数处理
 * 
 * @author yangbolin Dec 7, 2012 10:36:02 AM
 */
public class MagicHandler extends DecompileHandler {
    /** 魔数上下文 **/
    private MagicContext magicContext;
    
    public MagicHandler() {
        magicContext = new MagicContext();
    }
    
    @Override
    public void parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        
        System.out.println("***PARSE MAGIC NUM***");
        
        byte[] magicBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.MAGIC_NUM_BYTES);
        
        Integer magic = ByteUtils.bytesToInt(magicBytes);
        
        String magicNum = Integer.toHexString(magic).toUpperCase();
        
        if (magicNum.equals(DecompileConstants.MAGIC_NUM)) {
            
            magicContext.setMagicNum(magicNum);
            decompileFactory.addDecompileContext(DecompileConstants.MAGIC_CONTEXT, magicContext);
            
            System.out.println("The file MAGIC is: " + this.magicContext.getMagicNum());    // 把魔数打印出来 
            
            //调用下一个处理句柄
            this.getNextHandler().parse(byteCodeContext, decompileFactory);
            
        } else {
            System.out.println("This file is not class byte file!");
        }
    }
}
