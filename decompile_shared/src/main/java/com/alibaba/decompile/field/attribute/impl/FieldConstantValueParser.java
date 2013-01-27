/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.field.attribute.impl;

import com.alibaba.decompile.attribute.info.AttributeInfo;
import com.alibaba.decompile.attribute.info.ConstantValueInfo;
import com.alibaba.decompile.common.ArrtibuteParser;
import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.common.utils.ByteUtils;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.context.impl.ConstantPoolContext;
import com.alibaba.decompile.factory.DecompileFactory;

/**
 * <pre>
 * 类ConstantValue.java的实现描述：final关键字定义的常量值
 * 注意:
 * 如果字段有设置final属性，那么对应的ConstantValueInfo中属性长度字段一定是2，
 * 因为表示属性长度的一个u2类型的数据结构
 * </pre>
 * 
 * @author yangbolin Dec 23, 2012 4:21:58 PM
 */
public class FieldConstantValueParser implements ArrtibuteParser {

    @Override
    public AttributeInfo parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.创建返回值的对象
        AttributeInfo attributeInfo = new ConstantValueInfo();

        // 1.读取属性长度
        byte[] attributeLengthBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.ATTRIBUTE_LENGTH_BYTES);

        // 2.计算属性的长度
        int attributeLength = ByteUtils.bytesToInt(attributeLengthBytes);
        if (attributeLength != 2) {
            System.out.println("The length of constantvalue attribute is not equal to 2");
            return null;
        }
        attributeInfo.setAttributeLength(attributeLength);
        
        // 4.读取一个常量池中的索引
        byte[] constantValueIndexBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.CONSTANT_VALUE_INDEX_BYTES);
        
        int constantValueIndex = ByteUtils.bytesToInt(constantValueIndexBytes);
        ((ConstantValueInfo)attributeInfo).setConstantValueIndex(constantValueIndex);
        
        // 5.获取常量池中对应的字面常量
        ConstantPoolContext constantPoolContext = (ConstantPoolContext)decompileFactory.getDecompileContext(DecompileConstants.CONSTANT_POOL_CONTEXT);
        String constantValueString = constantPoolContext.getUTF8tringByIndex(constantValueIndex);
        ((ConstantValueInfo)attributeInfo).setConstantValueString(constantValueString);
        
        return attributeInfo;
    }
}
