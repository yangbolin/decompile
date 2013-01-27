/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common;

import com.alibaba.decompile.attribute.info.AttributeInfo;
import com.alibaba.decompile.attribute.info.SyntheticInfo;
import com.alibaba.decompile.common.utils.ByteUtils;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.factory.DecompileFactory;

/**
 * <pre>
 * 类FieldSyntheticParser.java的实现描述：表示字段或者方法是编译器自动生成的
 * 注：
 * 关于字段的是否是编译器自动生成的属性其实就是一个bool值，就是说字段要么
 * 是编译器自动生成的，要么字段不是编译器自动生成,只要字段的属性表中有这个
 * 属性，就说明字段是编译器自动生成的，要是字段的属性表中没有这个属性，就
 * 说明字段不是编译器自动生成的，所以该属性的属性长度显然没有存在的必要，即
 * 这个属性的长度必须为0，属性长度是一个u4类型的。
 * </pre>
 * 
 * @author yangbolin Dec 23, 2012 4:24:04 PM
 */
public class SyntheticInfoParser implements ArrtibuteParser {

    @Override
    public AttributeInfo parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.创建一个表示字段是否是编译器自动生成的属性对象
        AttributeInfo attributeInfo = new SyntheticInfo();

        // 1.读取属性长度所占的字节码数组
        byte[] attributeLengthBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.ATTRIBUTE_LENGTH_BYTES);

        // 2.把字节码转换成整型的长度
        int attributeLength = ByteUtils.bytesToInt(attributeLengthBytes);
        if (attributeLength != 0) {
            System.out.println("The length of synthetic-attribute is not zero!");
            return null;
        }

        // 3.保存属性的长度
        attributeInfo.setAttributeLength(attributeLength);

        return attributeInfo;
    }
}
