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
 * 类LookupSwitchByteCodeOperandParser.java的实现描述：解析lookupswitch字节码指令的参数
 * 注:
 * 当switch语句的case分支对应value不是连续时，就会生成lookupswitch的字节码指令，这条指令和
 * tableswitch字节码指令一样，都是用来支持switch语句的，类似的该字节码指令也会有同样的对齐字
 * 节，解析方式和tableswitch的一样，不过这个字节码存储操作数的方式和tableswitch不一样，同样
 * 在使用的时候注意NPE的判断
 * </pre>
 * 
 * @author yangbolin Jan 2, 2013 2:45:42 PM
 */
public class LookupSwitchByteCodeOperandParser extends AbstractSwitchByteCodeOperandParser implements ByteCodeOperandParser {

    @Override
    public ByteCode parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.创建返回值对象
        LookupSwitchByteCode byteCode = new LookupSwitchByteCode();
        byteCode.setOperandBytes(DecompileConstants.OPERAND_FOUR_BYTE);
        
        // 1.读取填充的字节
        int paddingBytesNum = super.parsePaddingBytes(byteCodeContext);
        if (-1 == paddingBytesNum) {
            System.out.println("The padding bytes for lookupswitch is not zero！");
            return null;
        }
        
        // 2.解析default分支的跳转偏移地址
        byteCode.setOperandBytes(DecompileConstants.OPERAND_FOUR_BYTE);
        byteCode.setDefaultOffset(super.parseDefaultOffset(byteCodeContext));
        
        // 3.解析HashMap的记录数目
        byte[] branchesBytes = byteCodeContext.getSpecifiedByteCodeArray(byteCode.getOperandBytes());
        int branches = ByteUtils.bytesToInt(branchesBytes);
        byteCode.setBraches(branches);
        
        // 4.解析每一条HashMap的记录数目
        for (int i = 0; i < branches; ++i) {
            // 4.1 解析case分支的value
            byte[] caseValueBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.OPERAND_FOUR_BYTE);
            int caseValue = ByteUtils.bytesToInt(caseValueBytes);
            
            // 4.2 解析分支对应的跳转偏移量
            byte[] offsetBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.OPERAND_FOUR_BYTE);
            int offset = ByteUtils.bytesToInt(offsetBytes);
            
            byteCode.addOffsetMap(caseValue, offset);
        }
        
        return (ByteCode)byteCode;
    }
}
