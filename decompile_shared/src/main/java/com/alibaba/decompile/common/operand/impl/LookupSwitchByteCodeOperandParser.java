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
import com.alibaba.decompile.common.operand.AbstractSwitchByteCodeOperandParser;
import com.alibaba.decompile.common.operand.ByteCodeOperandParser;
import com.alibaba.decompile.common.operand.LookupSwitchByteCode;
import com.alibaba.decompile.common.utils.ByteUtils;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.factory.DecompileFactory;

/**
 * <pre>
 * ��LookupSwitchByteCodeOperandParser.java��ʵ������������lookupswitch�ֽ���ָ��Ĳ���
 * ע:
 * ��switch����case��֧��Ӧvalue��������ʱ���ͻ�����lookupswitch���ֽ���ָ�����ָ���
 * tableswitch�ֽ���ָ��һ������������֧��switch���ģ����Ƶĸ��ֽ���ָ��Ҳ����ͬ���Ķ�����
 * �ڣ�������ʽ��tableswitch��һ������������ֽ���洢�������ķ�ʽ��tableswitch��һ����ͬ��
 * ��ʹ�õ�ʱ��ע��NPE���ж�
 * </pre>
 * 
 * @author yangbolin Jan 2, 2013 2:45:42 PM
 */
public class LookupSwitchByteCodeOperandParser extends AbstractSwitchByteCodeOperandParser implements ByteCodeOperandParser {

    @Override
    public ByteCode parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.��������ֵ����
        LookupSwitchByteCode byteCode = new LookupSwitchByteCode();
        byteCode.setOperandBytes(DecompileConstants.OPERAND_FOUR_BYTE);
        
        // 1.��ȡ�����ֽ�
        int paddingBytesNum = super.parsePaddingBytes(byteCodeContext);
        if (-1 == paddingBytesNum) {
            System.out.println("The padding bytes for lookupswitch is not zero��");
            return null;
        }
        
        // 2.����default��֧����תƫ�Ƶ�ַ
        byteCode.setOperandBytes(DecompileConstants.OPERAND_FOUR_BYTE);
        byteCode.setDefaultOffset(super.parseDefaultOffset(byteCodeContext));
        
        // 3.����HashMap�ļ�¼��Ŀ
        byte[] branchesBytes = byteCodeContext.getSpecifiedByteCodeArray(byteCode.getOperandBytes());
        int branches = ByteUtils.bytesToInt(branchesBytes);
        byteCode.setBraches(branches);
        
        // 4.����ÿһ��HashMap�ļ�¼��Ŀ
        for (int i = 0; i < branches; ++i) {
            // 4.1 ����case��֧��value
            byte[] caseValueBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.OPERAND_FOUR_BYTE);
            int caseValue = ByteUtils.bytesToInt(caseValueBytes);
            
            // 4.2 ������֧��Ӧ����תƫ����
            byte[] offsetBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.OPERAND_FOUR_BYTE);
            int offset = ByteUtils.bytesToInt(offsetBytes);
            
            byteCode.addOffsetMap(caseValue, offset);
        }
        
        return (ByteCode)byteCode;
    }
}
