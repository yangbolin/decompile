/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common.operand.impl;

import com.alibaba.decompile.common.ByteCode;
import com.alibaba.decompile.common.ByteUtils;
import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.common.operand.AbstractSwitchByteCodeOperandParser;
import com.alibaba.decompile.common.operand.ByteCodeOperandParser;
import com.alibaba.decompile.common.operand.TableSwitchByteCode;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.factory.DecompileFactory;

/**
 * <pre>
 * ��TableSwitchByteCodeOperandParser.java��ʵ��������tableswitch�ֽ���ָ�������������
 * ע:
 * ����tableswitch�ֽ��룬Ϊ�˶��룬����0-3�ֽڵ���䣬���֮ǰ���Լ�����ˣ���Ϊ64λ��OS������
 * ���ֽ������롣��������һ�������ð�����ˣ���ξ��������ֽ����أ����ֽ����������У����Ǳ�����һ
 * ������currentIndex�������������˼����˵��ǰ�Ѿ����ֽ����ļ��ж�ȡ�˶����ֽڣ�ʹ��currentIndex % 4
 * ��ɵ�֪��Ҫ������ֽ���Ŀ��0or1or2or3
 * 
 * ��ʹ�����������ʱע���ж�NPE
 * </pre>
 * 
 * @author yangbolin Jan 2, 2013 10:03:43 AM
 */
public class TableSwitchByteCodeOperandParser extends AbstractSwitchByteCodeOperandParser implements ByteCodeOperandParser {

    @Override
    public ByteCode parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.��������ֵ����
        TableSwitchByteCode byteCode = new TableSwitchByteCode();
        
        int totalBytes = DecompileConstants.BYTE_CODE_SYMBOL_CODE_BYTE;

        // 1.��ȡ����ֽ�
        int paddingBytesNum = super.parsePaddingBytes(byteCodeContext);
        if (-1 == paddingBytesNum) {
            System.out.println("The padding bytes for tableswitch is not zero��");
            return null;
        }

        totalBytes += paddingBytesNum;
        
        // 2.��ȡdefault��֧��ƫ��������
        byteCode.setOperandBytes(DecompileConstants.OPERAND_FOUR_BYTE);
        byteCode.setDefaultOffset(super.parseDefaultOffset(byteCodeContext));

        // 3.��ȡcase��֧��Сֵ��ռ���ֽ�����
        byte[] lowBytes = byteCodeContext.getSpecifiedByteCodeArray(byteCode.getOperandBytes());
        int low = Integer.valueOf(ByteUtils.bytesToHex(lowBytes), DecompileConstants.HEX_RADIX);
        byteCode.setLow(low);
        totalBytes += byteCode.getOperandBytes();

        // 4.��ȡcase��֧���ֵ��ռ���ֽ�����
        byte[] highBytes = byteCodeContext.getSpecifiedByteCodeArray(byteCode.getOperandBytes());
        int high = Integer.valueOf(ByteUtils.bytesToHex(highBytes), DecompileConstants.HEX_RADIX);
        byteCode.setHigh(high);
        totalBytes += byteCode.getOperandBytes();

        // 5.��ȡ����case��֧��Ӧ����תƫ����
        int totalCases = high - low + 1;
        for (int i = 0; i < totalCases; ++i) {
            byte[] offsetBytes = byteCodeContext.getSpecifiedByteCodeArray(byteCode.getOperandBytes());
            int offset = Integer.valueOf(ByteUtils.bytesToHex(offsetBytes), DecompileConstants.HEX_RADIX);
            byteCode.addOffset(offset);
            totalBytes += byteCode.getOperandBytes();
        }

        // 6.���õ�ǰ�ֽ�����ռ���ֽ�����
        byteCode.setTotalBytes(totalBytes);
        
        return (ByteCode) byteCode;
    }
}
