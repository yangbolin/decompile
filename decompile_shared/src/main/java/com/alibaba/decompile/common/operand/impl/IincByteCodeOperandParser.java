/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common.operand.impl;

import com.alibaba.decompile.common.ByteCode;
import com.alibaba.decompile.common.ByteUtils;
import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.common.operand.ByteCodeOperandParser;
import com.alibaba.decompile.common.operand.IincByteCode;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.factory.DecompileFactory;

/**
 * <pre>
 * ��IincByteCodeOperandParser.java��ʵ��������iinc�ֽ���ָ��������Ľ���
 * ע:
 * ��ָ��ĵ���˼�ǽ�һ�����;ֲ�����������Ӧ��ֵ��Ȼ��洢�����ͱ����У���ô����
 * ָ�����Ҫ������������һ��������Ҫ�ܶ�λ�����ͱ���������һ����������ʾ�������
 * ������Ҫ���ӵ���ֵ��
 * ����������Դ����:
 * int i = 1;
 * i += 2;
 * javac������������ֽ���:
 * iinc 1, 2
 * ����1��ʾi�ֲ�������������2��ʾ��Ҫ��i���ӵ�������ֵ
 * ��Ӧ�Ķ����Ʊ�ʾ��ʽΪ:8401 02xx,����84��ʾiinc�ֽ����������01��02�Ͳ���
 * ������ˡ����ڱ���JDK64λ���ԵĽ�����£�Ϊ�˺����������ǿ���ʹ��m����ʾ��Ҫ
 * ������ֵ�����m��ȡֵС��128�������ɵ�iinc���ֽ��룬���m��ȡֵ���ڵ���128��
 * ��С�ڵ���65535�����ɵ���iinc_w�ֽ��룬���m��ֵ����65535�򲻻�����iinc����
 * iinc_w���ֽ���ָ����ɵľ���add��ص��ֽ����ˡ�
 * 
 * �鿴�������ļ����������iinc��iinc_w�أ����ڡ��������JVM���Ǳ�����û���ҵ�
 * iinc_w�����ֽ��룬����ITEYE��JVM�������з�������ѯһ���������
 * http://hllvm.group.iteye.com/group/topic/35386
 * 
 * �����ϸ����һ�¶������ļ����������iincָ���ֱ������84��ͷ�ģ����������iinc_w
 * ָ�������c484����ʾ�ֽ���ָ��iinc_w,�������ľֲ�������i�����Լ�mֵ���������ֽ���
 * ��ʾ��
 * 
 * ���������´���:
 * int i = 2;
 * i += 128;
 * ���ɵ��ֽ���ָ����:
 * iinc_w 1, 128
 * ��Ӧ�Ķ������ļ�����:
 * c484 0001 0080
 * ����Ĭ�Ͼֲ�����i��������1
 * 
 * ����ڽ���iinc�ֽ���ָ���ʱ��Ҫ��һ���ж�
 * 
 * ��ʵ�����c4����һ��wide�ֽ���ָ��
 * 
 * </pre>
 * 
 * @author yangbolin Dec 30, 2012 1:52:27 PM
 */
public class IincByteCodeOperandParser implements ByteCodeOperandParser {

    @Override
    public ByteCode parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.��������ֵ����
        IincByteCode byteCode = new IincByteCode();
        
        int totalBytes = DecompileConstants.BYTE_CODE_SYMBOL_CODE_BYTE;
        
        // 1.�жϲ�������ռ���ֽ���Ŀ 
        if (byteCodeContext.isHasWide()) {
            byteCode.setOperandBytes(DecompileConstants.OPERAND_TWO_BYTE);
            byteCode.setHasWide(true);
            byteCodeContext.setHasWide(false);      //  һ��ʹ�ú����ϻ�ԭ
            
            // ���ֽ���ǰ����wide�ֽ���
            totalBytes += DecompileConstants.BYTE_CODE_SYMBOL_CODE_BYTE;        
        } else {
            byteCode.setOperandBytes(DecompileConstants.OPERAND_ONE_BYTE);
        }
        
        // 2.��ȡ������֮���ر���������
        byte[] indexBytes = byteCodeContext.getSpecifiedByteCodeArray(byteCode.getOperandBytes());
        int index = Integer.valueOf(ByteUtils.bytesToHex(indexBytes), DecompileConstants.HEX_RADIX);
        byteCode.setIndex(index);
        
        totalBytes += byteCode.getOperandBytes();
        
        // 3.��ȡ��Ҫ���ӵĳ���ֵ
        byte[] constValueBytes = byteCodeContext.getSpecifiedByteCodeArray(byteCode.getOperandBytes());
        int constValue = Integer.valueOf(ByteUtils.bytesToHex(constValueBytes), DecompileConstants.HEX_RADIX);
        byteCode.setConstValue(constValue);
        
        totalBytes += byteCode.getOperandBytes();
        
        // 4.���õ�ǰ�ֽ�����ռ���ֽ���Ŀ
        byteCode.setTotalBytes(totalBytes);
        
        return (ByteCode)byteCode;
    }
}
