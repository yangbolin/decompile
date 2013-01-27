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
 * ��FieldSyntheticParser.java��ʵ����������ʾ�ֶλ��߷����Ǳ������Զ����ɵ�
 * ע��
 * �����ֶε��Ƿ��Ǳ������Զ����ɵ�������ʵ����һ��boolֵ������˵�ֶ�Ҫô
 * �Ǳ������Զ����ɵģ�Ҫô�ֶβ��Ǳ������Զ�����,ֻҪ�ֶε����Ա��������
 * ���ԣ���˵���ֶ��Ǳ������Զ����ɵģ�Ҫ���ֶε����Ա���û��������ԣ���
 * ˵���ֶβ��Ǳ������Զ����ɵģ����Ը����Ե����Գ�����Ȼû�д��ڵı�Ҫ����
 * ������Եĳ��ȱ���Ϊ0�����Գ�����һ��u4���͵ġ�
 * </pre>
 * 
 * @author yangbolin Dec 23, 2012 4:24:04 PM
 */
public class SyntheticInfoParser implements ArrtibuteParser {

    @Override
    public AttributeInfo parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.����һ����ʾ�ֶ��Ƿ��Ǳ������Զ����ɵ����Զ���
        AttributeInfo attributeInfo = new SyntheticInfo();

        // 1.��ȡ���Գ�����ռ���ֽ�������
        byte[] attributeLengthBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.ATTRIBUTE_LENGTH_BYTES);

        // 2.���ֽ���ת�������͵ĳ���
        int attributeLength = ByteUtils.bytesToInt(attributeLengthBytes);
        if (attributeLength != 0) {
            System.out.println("The length of synthetic-attribute is not zero!");
            return null;
        }

        // 3.�������Եĳ���
        attributeInfo.setAttributeLength(attributeLength);

        return attributeInfo;
    }
}
