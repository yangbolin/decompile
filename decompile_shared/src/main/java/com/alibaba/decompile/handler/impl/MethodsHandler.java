/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.handler.impl;

import com.alibaba.decompile.attribute.info.AttributeInfo;
import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.common.MethodAccessFlag;
import com.alibaba.decompile.common.utils.ByteUtils;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.context.impl.ConstantPoolContext;
import com.alibaba.decompile.context.impl.MethodsContext;
import com.alibaba.decompile.factory.DecompileFactory;
import com.alibaba.decompile.handler.DecompileHandler;
import com.alibaba.decompile.method.Method;
import com.alibaba.decompile.method.attribute.ParseMethodAttributeFactory;

/**
 * 类MethodsHandler.java的实现描述：从字节码中解析方法
 * 
 * @author yangbolin Dec 26, 2012 8:20:05 PM
 */
public class MethodsHandler extends DecompileHandler {

    /** 方法上下文 **/
    private MethodsContext methodsContext;

    @Override
    public void parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        
        System.out.println("***PARSE METHOD IN CURRENT CLASSS***");
        
        // 0.创建方法上下文获取常量池上下文方便使用
        this.methodsContext = new MethodsContext();
        ConstantPoolContext constantPoolContext = (ConstantPoolContext) decompileFactory.getDecompileContext(DecompileConstants.CONSTANT_POOL_CONTEXT);

        // 1.读取表示方法数目的字节码数组
        byte[] methodsCountBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.METHODS_COUNT_BYTES);

        int methodsCount = ByteUtils.bytesToInt(methodsCountBytes);
        this.methodsContext.setMemthodsCount(methodsCount);

        // 2.依次解析每个方法
        for (int i = 0; i < methodsCount; ++i) {
            Method method = new Method();

            // 2.1解析方法的访问权限
            byte[] accessFlagsBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.METHODS_COUNT_BYTES);
            int accessFlags = ByteUtils.bytesToInt(accessFlagsBytes);

            for (MethodAccessFlag methodAccessFlag : MethodAccessFlag.values()) {
                if ((methodAccessFlag.getFlagValue() & accessFlags) != 0) {
                    method.addAccessFlag(methodAccessFlag);
                }
            }

            // 2.2 解析方法名称的索引
            byte[] nameIndexBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.METHOD_NAME_INDEX_BYTES);
            int nameIndex = ByteUtils.bytesToInt(nameIndexBytes);

            String methodName = constantPoolContext.getUTF8tringByIndex(nameIndex);
            method.setNameIndex(nameIndex);
            method.setMethodName(methodName);

            // 2.3 解析方法的描述符
            byte[] descriptorIndexBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.METHOD_DESCRIPTOR_BYTES);
            int descriptorIndex = ByteUtils.bytesToInt(descriptorIndexBytes);
            String descriptorName = constantPoolContext.getUTF8tringByIndex(descriptorIndex);
            method.setDescriptorIndex(descriptorIndex);
            method.setDescriptorName(descriptorName);

            // 2.4 解析方法的附加属性数目
            byte[] attributeCountBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.METHOD_ATTRIBUTE_COUNT_BYTES);
            int attributeCount = ByteUtils.bytesToInt(attributeCountBytes);
            method.setAttributeCount(attributeCount);

            // 2.5 依次解析方法的每一个附加属性
            for (int j = 0; j < attributeCount; ++j) {
                // 2.5.0 解析属性的名称
                byte[] attributeNameIndexBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.ATTRIBUTE_NAME_INDEX_BYTES);
                int attributeNameIndex = ByteUtils.bytesToInt(attributeNameIndexBytes);
                String attributeName = constantPoolContext.getUTF8tringByIndex(attributeNameIndex);

                // 2.5.1 解析方法的累加属性
                AttributeInfo attributeInfo = ParseMethodAttributeFactory.getSpecParser(attributeName).parse(byteCodeContext,
                                                                                                             decompileFactory);

                attributeInfo.setAttributeNameIndex(attributeNameIndex);
                attributeInfo.setAttributeName(attributeName);

                // 2.5.2 设置方的累加属性
                method.addAttributeInfo(attributeInfo);
            }
            
            this.methodsContext.addMethod(method);
        }
        
        // 3.方法信息的输出
        System.out.println(this.methodsContext.toString());
        
        // 4.调用下一个处理句柄
        this.getNextHandler().parse(byteCodeContext, decompileFactory);
    }
}
