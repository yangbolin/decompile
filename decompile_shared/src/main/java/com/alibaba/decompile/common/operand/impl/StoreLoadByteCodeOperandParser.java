/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common.operand.impl;

import com.alibaba.decompile.common.ByteCode;
import com.alibaba.decompile.common.operand.ByteCodeOperandParser;
import com.alibaba.decompile.common.operand.StoreLoadByteCode;
import com.alibaba.decompile.common.utils.ByteUtils;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.factory.DecompileFactory;

/**
 * <pre>
 * ��StoreLoadByteCodeOperandParser.java��ʵ���������ֽ���ָ������һ��������store��loadָ��������Ľ�����
 * ע��:
 * ��������������istore,iload, dstore,dload, fstore,fload, astore,aload,lstore,lload���ֽ���ָ������
 * ����ջ����ֵ�ͱ��ؾֲ����������ؾֲ�������Ҫһ��������ָ����ջ������ֵ��Ȼ��û�б�Ҫ��ָ���ˣ������Щָ���һ��
 * �����������������������ռ���ֽ���Ŀ��1���ֽڣ�Ҳ����˵���ֵ��FF����ʵ���ε���˼����˵��JAVA��һ�����������
 * �ܳ���256���ֲ���������ò��Ӧ����һ��JAVA���Թ淶��
 * 
 * ���ҿ���wideʱ���ŷ���JAVA��һ�������ж���ľֲ��������Դ���0XFF,����ʹ���������ָ������չ�ֲ�����������1���ֽ�
 * ��2���ֽ�,wideָ�������������Щstore��loadָ��ǰ�棬����ڽ�д��Щstore��loadָ���ʱ��Ҫ�Ȼ�˷�ж�һ���ֽ���
 * ǰ���Ƿ���wideָ��
 * 
 * ����Ļ�˷��һ�ֽ�����ԣ��������ǲ����û�˷��˼�룬ֱ�����ֽ�������������һ����־����ʾ���ɡ������Ҫ�������ֽ�����
 * ������ȥά������һ����־�ˡ�
 * 
 * </pre>
 * 
 * @author yangbolin Dec 30, 2012 4:08:39 PM
 */
public class StoreLoadByteCodeOperandParser implements ByteCodeOperandParser {

    /** �ֽ����������ռ���ֽ���Ϊ1 **/
    private static final int OPERAND_ONE_BYTE = 1;
    /** �ֽ����������ռ���ֽ���Ϊ2 **/
    private static final int OPERAND_TWO_BYTE = 2;

    @Override
    public ByteCode parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.��������ֵ����
        StoreLoadByteCode byteCode = new StoreLoadByteCode();
        
        // 1.�����ֽ����������е�hasWide��־��������ǰ�ֽ���ָ�������ռ���ֽ���Ŀ
        if (byteCodeContext.isHasWide()) {
            byteCode.setOperandBytes(OPERAND_TWO_BYTE);
            byteCode.setHasWide(true);
            byteCodeContext.setHasWide(false); // һ��ʹ�ù������ϻ�ԭ
        } else {
            byteCode.setOperandBytes(OPERAND_ONE_BYTE);
        }

        // 2.��ȡ��������ռ���ֽ�����
        byte[] operandBytes = byteCodeContext.getSpecifiedByteCodeArray(byteCode.getOperandBytes());
        
        // 3.ת������������
        int operand = ByteUtils.bytesToInt(operandBytes);

        // 4.�����ֽ��������
        byteCode.setOperand(operand);
        
        return (ByteCode) byteCode;
    }
}
