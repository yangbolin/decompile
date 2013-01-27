/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common.operand.impl;

import com.alibaba.decompile.common.ByteCode;
import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.common.operand.ByteCodeOperandParser;
import com.alibaba.decompile.common.operand.SkipByteCode;
import com.alibaba.decompile.common.utils.ByteUtils;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.factory.DecompileFactory;

/**
 * <pre>
 * ��SkipByteCodeOperandParser.java��ʵ������������JVM��תָ��Ĳ���
 * ע��
 * �������������ֻ�����ƫ������ʵ�ʵ���ת��ַӦ���ǻ���ַ+ƫ��������תָ��
 * ����ĵ�ַ���ǻ���ַ��������תָ���ĵ�ַ��M,ƫ������N,��ô���յ���ת
 * ��ַ����M+N
 * </pre>
 * 
 * @author yangbolin Jan 1, 2013 5:04:02 PM
 */
public class SkipByteCodeOperandParser implements ByteCodeOperandParser {

    @Override
    public ByteCode parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.��������ֵ����
        SkipByteCode byteCode = new SkipByteCode();
        
        // 1.��ȡ��תƫ������ռ���ֽ�����
        byteCode.setOperandBytes(DecompileConstants.OPERAND_TWO_BYTE);
        byte[] offsetBytes = byteCodeContext.getSpecifiedByteCodeArray(byteCode.getOperandBytes());
        
        // 2.���ֽ�����ת������������
        int offset = ByteUtils.bytesToInt(offsetBytes);
        
        byteCode.setOffset(offset);
        
        return (ByteCode)byteCode;
    }
}
