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
import com.alibaba.decompile.context.impl.VersionContext;
import com.alibaba.decompile.factory.DecompileFactory;
import com.alibaba.decompile.handler.DecompileHandler;

/**
 * 类VersionHandler.java的实现描述：版本解析
 * 
 * @author yangbolin Dec 10, 2012 10:07:34 AM
 */
public class VersionHandler extends DecompileHandler {

    @Override
    public void parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        System.out.println("***PARSE VERSION***");
        // 0.次版本号对应的字节数组
        byte[] minorVersionBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.VERSION_NUM_BYTES);
        
        // 1.主版本号对应的字节数组
        byte[] majorVersionBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.VERSION_NUM_BYTES);
        
        // 2.把字节转换成整数
        int minorVersion = ByteUtils.bytesToInt(majorVersionBytes);
        int majorVersion = ByteUtils.bytesToInt(minorVersionBytes);
        
        // 3.设置版本号上下文
        VersionContext versionContext = new VersionContext();
        versionContext.setMinorVersion(minorVersion);
        versionContext.setMajorVersion(majorVersion);
        
        // 4.把版本号上下文设置到上下文工厂中
        decompileFactory.addDecompileContext(DecompileConstants.VERSION_CONTEXT, versionContext);
        
        System.out.println(String.format("The major version is %d and the minor version is %d", versionContext.getMajorVersion(), versionContext.getMinorVersion()));
        
        // 5.调用下一个处理的句柄
        this.getNextHandler().parse(byteCodeContext, decompileFactory);
    }
}
