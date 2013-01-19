/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.handler.impl;

import java.util.List;

import com.alibaba.decompile.common.ByteUtils;
import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.context.impl.ConstantPoolContext;
import com.alibaba.decompile.context.impl.InterfacesContext;
import com.alibaba.decompile.factory.DecompileFactory;
import com.alibaba.decompile.handler.DecompileHandler;

/**
 * 类InterfacesHandler.java的实现描述：当前类所实现的接口或者当前接口所实现的接口处理句柄
 * 
 * @author yangbolin Dec 11, 2012 4:20:10 PM
 */
public class InterfacesHandler extends DecompileHandler {
    /** 接口上下文 **/
    private InterfacesContext intefacesContext;
    
    @Override
    public void parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        
        System.out.println("***PARSE INTERFACES IMPLEMENTED***");
        
        // 0.读取相关的字节数组
        byte[] countBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.INTERFACES_COUNT_BYTES);
        
        this.intefacesContext = new InterfacesContext();
        
        int count = Integer.valueOf(ByteUtils.bytesToHex(countBytes), DecompileConstants.HEX_RADIX);
        this.intefacesContext.setCount(count);
        
        ConstantPoolContext constantPoolContext = (ConstantPoolContext)decompileFactory.getDecompileContext(DecompileConstants.CONSTANT_POOL_CONTEXT);
        
        // 1.依次读取每一个接口
        for (int i = 0; i < count; ++i) {
            byte[] qualifiedNameBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.INTERFACE_QUALIFIED_NAME_BYTES);

            int index = Integer.valueOf(ByteUtils.bytesToHex(qualifiedNameBytes), DecompileConstants.HEX_RADIX);
            this.intefacesContext.addIndex(index);
            String qualifiedName = constantPoolContext.getClassQualifiedName(index);
            if (qualifiedName != null) {
                this.intefacesContext.addQualifiedName(qualifiedName);
            } else {
                System.out.println(String.format("Can't get the qualified name from constan pool for interface index %d", index));
                return;
            }
        }
        
        // 2.把接口上下文设置到工厂之中
        decompileFactory.addDecompileContext(DecompileConstants.INTERFACES_CONTEXT, this.intefacesContext);
        
        if (count == 0) {
            System.out.println("There is no interface implemented!");
        } else {
            List<Integer> indexList = this.intefacesContext.getIndexList();
            List<String> qualifiedNameList = this.intefacesContext.getQualifiedNameList();
            int size = indexList.size();
            
            for (int i = 0; i < size; ++i) {
                System.out.println(String.format("interface\t#%d\t#%s", indexList.get(i), qualifiedNameList.get(i)));
            }
        }
        
        // 3.0 调用下一个处理句柄
        this.getNextHandler().parse(byteCodeContext, decompileFactory);
    }
}
