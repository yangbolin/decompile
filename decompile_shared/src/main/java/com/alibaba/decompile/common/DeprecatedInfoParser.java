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
 * ��FeildDeprecatedParser.java��ʵ��������������ΪDeprecated���ֶλ��߷�����
 * �����ֶλ��߷������ԣ�Ҫô��������ԣ�Ҫôû��������ԣ����Զ��ߵĽ�����ȫһ����Ϊ
 * �˳������õ��������Ѷ��ߵĹ��Գ�ȡ����
 * 
 * ע:��ʹ�ý��������ʱ����ܳ���NPE,�Է��ؽ�������пմ���
 * </pre>
 * 
 * @author yangbolin Dec 23, 2012 4:23:25 PM
 */
public class DeprecatedInfoParser implements ArrtibuteParser {

    @Override
    public AttributeInfo parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.����һ��DeprecatedInfo���͵Ķ���
        AttributeInfo  deprecatedInfo = new DeprecatedInfo();
        
        // 1.��ȡ���Եĳ���
        byte[] attributeLengthBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.ATTRIBUTE_LENGTH_BYTES);
        
        // 2.ת�����Եĳ���
        int attributeLength = ByteUtils.bytesToInt(attributeLengthBytes);
        if (attributeLength != 0) {
            System.out.println("The length of deprecated-attribute is not zero!");
            return null;
        }
        
        // 3.���÷��ض��������Եĳ���
        deprecatedInfo.setAttributeLength(attributeLength);
        
        return deprecatedInfo;
    }
}
