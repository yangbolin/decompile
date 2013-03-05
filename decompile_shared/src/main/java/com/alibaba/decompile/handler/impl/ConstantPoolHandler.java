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
import com.alibaba.decompile.constant.pool.ConstantInfo;
import com.alibaba.decompile.constant.pool.ConstantInfoBackFillFactory;
import com.alibaba.decompile.constant.pool.ConstantInfoParser;
import com.alibaba.decompile.constant.pool.ConstantInfoParserFactory;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.context.impl.ConstantPoolContext;
import com.alibaba.decompile.factory.DecompileFactory;
import com.alibaba.decompile.handler.DecompileHandler;

/**
 * <pre>
 * 类ConstantPoolHandler.java的实现描述：常量区的处理
 * 注:
 * 解析结束之后再扫描一遍常量池列表，把一些信息回填
 * </pre>
 * 
 * @author yangbolin Dec 7, 2012 5:22:49 PM
 */
public class ConstantPoolHandler extends DecompileHandler {

    /** 常量池上下文 **/
    private ConstantPoolContext constantPoolContext;

    /** 常量池中常量解析工厂 **/
    private ConstantInfoParserFactory parserFactory;
    
    /** 常量描述信息回填工厂 **/
    private ConstantInfoBackFillFactory backFillFactory;

    public ConstantPoolHandler() {
        this.constantPoolContext = new ConstantPoolContext();
        this.parserFactory = new ConstantInfoParserFactory();
        this.backFillFactory = new ConstantInfoBackFillFactory();
    }

    @Override
    public void parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {

        System.out.println("***PARSE CONSTANT POOL***");

        // 0.读取常量池中常量的数目
        byte[] classBytes = byteCodeContext.getClassByte();
        byte[] constantNumBytes = new byte[DecompileConstants.CONSTANT_NUM_BYTES];
        System.arraycopy(classBytes, byteCodeContext.getCurrentIndex(), constantNumBytes, 0,
                         DecompileConstants.CONSTANT_NUM_BYTES);
        byteCodeContext.forwardCurrentIndexSteps(DecompileConstants.CONSTANT_NUM_BYTES);

        // 1.常量池上下文的初始化
        this.constantPoolContext = new ConstantPoolContext();
        this.constantPoolContext.setConstantNum(ByteUtils.bytesToInt(constantNumBytes));

        System.out.println(String.format("The num of constant in constant-pool is %d, and the index is from 1 to %d",
                                         this.constantPoolContext.getConstantNum(),
                                         this.constantPoolContext.getConstantNum() - 1));

        // 2.依次处理常量
        int num = this.constantPoolContext.getConstantNum();
        boolean finished = true;
        for (int i = 1; i < num; ++i) {

            byte[] tageIndexBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.CONSTANT_TAG_BYTE);
            int tagIndex = ByteUtils.bytesToInt(tageIndexBytes);

            ConstantInfoParser constantInfoParser = this.parserFactory.getParser(tagIndex);
            if (null == constantInfoParser) {
                System.out.println(String.format("The tag %d is not illegal!", tagIndex));
                finished = true;
                break;
            } else {
                ConstantInfo constantInfo = constantInfoParser.parse(byteCodeContext);
                this.constantPoolContext.addConstantInfo(constantInfo);
            }
        }

        if (finished == true) {
            this.backFillFactory.backFill(this.constantPoolContext);
            
            decompileFactory.addDecompileContext(DecompileConstants.CONSTANT_POOL_CONTEXT, this.constantPoolContext);
            
            this.constantPoolContext.outPutConstantsPool();
            
            if (this.getNextHandler() != null) {
                this.getNextHandler().parse(byteCodeContext, decompileFactory);
            }
        }
    }


    public ConstantPoolContext getConstantPoolContext() {
        return constantPoolContext;
    }

    public void setConstantPoolContext(ConstantPoolContext constantPoolContext) {
        this.constantPoolContext = constantPoolContext;
    }
}
