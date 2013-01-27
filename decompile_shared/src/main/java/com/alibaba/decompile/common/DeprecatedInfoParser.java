/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common;

import com.alibaba.decompile.attribute.info.AttributeInfo;
import com.alibaba.decompile.attribute.info.DeprecatedInfo;
import com.alibaba.decompile.common.utils.ByteUtils;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.factory.DecompileFactory;

/**
 * <pre>
 * 类FeildDeprecatedParser.java的实现描述：被声明为Deprecated的字段或者方法，
 * 对于字段或者方法而言，要么有这个属性，要么没有这个属性，所以二者的解析完全一样，为
 * 了倡导复用的理念，这里把二者的共性抽取出来
 * 
 * 注:在使用解析结果的时候可能出现NPE,对返回结果进行判空处理
 * </pre>
 * 
 * @author yangbolin Dec 23, 2012 4:23:25 PM
 */
public class DeprecatedInfoParser implements ArrtibuteParser {

    @Override
    public AttributeInfo parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.构造一个DeprecatedInfo类型的对象
        AttributeInfo  deprecatedInfo = new DeprecatedInfo();
        
        // 1.读取属性的长度
        byte[] attributeLengthBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.ATTRIBUTE_LENGTH_BYTES);
        
        // 2.转换属性的长度
        int attributeLength = ByteUtils.bytesToInt(attributeLengthBytes);
        if (attributeLength != 0) {
            System.out.println("The length of deprecated-attribute is not zero!");
            return null;
        }
        
        // 3.设置返回对象中属性的长度
        deprecatedInfo.setAttributeLength(attributeLength);
        
        return deprecatedInfo;
    }
}
