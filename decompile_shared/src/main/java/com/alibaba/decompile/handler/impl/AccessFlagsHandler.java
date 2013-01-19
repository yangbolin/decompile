/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.handler.impl;

import com.alibaba.decompile.common.ByteUtils;
import com.alibaba.decompile.common.ClassAccessFlag;
import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.context.impl.AccessFlagsContext;
import com.alibaba.decompile.factory.DecompileFactory;
import com.alibaba.decompile.handler.DecompileHandler;

/**
 * 类AccessFlagsHandler.java的实现描述：类访问权限的处理
 * 
 * @author yangbolin Dec 11, 2012 9:46:26 AM
 */
public class AccessFlagsHandler extends DecompileHandler {
    /** 访问标志的上下文 **/
    private AccessFlagsContext accessFlagsContext;
    
    @Override
    public void parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        System.out.println("***PARSE THE ACCESS PERMISSION OF CURRENT CLASS***");
        
        // 0.读取访问权限标志所占的字节数组
        byte[] classBytes = byteCodeContext.getClassByte();
        byte[] accessFlagBytes = new byte[DecompileConstants.ACCESS_FLAGS_BYTES];
        System.arraycopy(classBytes, byteCodeContext.getCurrentIndex(), accessFlagBytes, 0, DecompileConstants.ACCESS_FLAGS_BYTES);
        byteCodeContext.forwardCurrentIndexSteps(DecompileConstants.ACCESS_FLAGS_BYTES);
        
        int accessFlagsValue = Integer.valueOf(ByteUtils.bytesToHex(accessFlagBytes), DecompileConstants.HEX_RADIX);
        this.accessFlagsContext = new AccessFlagsContext();
        this.accessFlagsContext.setAccessFlagsValue(accessFlagsValue);
        
        // 1.对每一个访问标志进行判断，看看其是否被包含在其中
        /**
         * 之前这里写了很多if语句，判断每个枚举类型的值，看看这个枚举类型的值有没有有相关的标志位和其对应，
         * 但是写了8条if语句，感觉很不爽，因为要是枚举值再多一个，就意味着我必须再增加一个if语句，这样的
         * 代码对于扩展性而言就是个悲剧
         */
        StringBuilder sb = new StringBuilder();
        for(ClassAccessFlag flag : ClassAccessFlag.values()) {
            if ((flag.getFlagValue() & accessFlagsValue) == 1 ) {
                accessFlagsContext.addAccessFlags(flag);
                sb.append(flag + " ");
            }
        }
        
        if (sb.length() == 0) {
            System.out.println("No decoration for current class");
        } else {
            System.out.println(sb.toString());
        }
        
        // 2.把上下文增加到反编译工厂中
        decompileFactory.addDecompileContext(DecompileConstants.ACCESS_FLAGS_CONTEXT, this.accessFlagsContext);
        
        // 3.调用下一个句柄来处理
        this.getNextHandler().parse(byteCodeContext, decompileFactory);
    }
}
