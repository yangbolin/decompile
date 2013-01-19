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
 * 类TableSwitchByteCodeOperandParser.java的实现描述：tableswitch字节码指令操作数解析器
 * 注:
 * 关于tableswitch字节码，为了对齐，会有0-3字节的填充，这个之前被自己误解了，认为64位的OS不会填
 * 充字节来补齐。那这里有一个问题就冒出来了，如何就算填充的字节数呢？我字节码上下文中，我们保存了一
 * 个变量currentIndex，这个变量的意思就是说当前已经从字节码文件中读取了多少字节，使用currentIndex % 4
 * 便可得知需要对齐的字节数目是0or1or2or3
 * 
 * 在使用这个解析器时注意判断NPE
 * </pre>
 * 
 * @author yangbolin Jan 2, 2013 10:03:43 AM
 */
public class TableSwitchByteCodeOperandParser extends AbstractSwitchByteCodeOperandParser implements ByteCodeOperandParser {

    @Override
    public ByteCode parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.创建返回值对象
        TableSwitchByteCode byteCode = new TableSwitchByteCode();
        
        int totalBytes = DecompileConstants.BYTE_CODE_SYMBOL_CODE_BYTE;

        // 1.读取填充字节
        int paddingBytesNum = super.parsePaddingBytes(byteCodeContext);
        if (-1 == paddingBytesNum) {
            System.out.println("The padding bytes for tableswitch is not zero！");
            return null;
        }

        totalBytes += paddingBytesNum;
        
        // 2.读取default分支的偏移量数组
        byteCode.setOperandBytes(DecompileConstants.OPERAND_FOUR_BYTE);
        byteCode.setDefaultOffset(super.parseDefaultOffset(byteCodeContext));

        // 3.读取case分支最小值所占的字节数组
        byte[] lowBytes = byteCodeContext.getSpecifiedByteCodeArray(byteCode.getOperandBytes());
        int low = Integer.valueOf(ByteUtils.bytesToHex(lowBytes), DecompileConstants.HEX_RADIX);
        byteCode.setLow(low);
        totalBytes += byteCode.getOperandBytes();

        // 4.读取case分支最大值所占的字节数组
        byte[] highBytes = byteCodeContext.getSpecifiedByteCodeArray(byteCode.getOperandBytes());
        int high = Integer.valueOf(ByteUtils.bytesToHex(highBytes), DecompileConstants.HEX_RADIX);
        byteCode.setHigh(high);
        totalBytes += byteCode.getOperandBytes();

        // 5.读取各个case分支对应的跳转偏移量
        int totalCases = high - low + 1;
        for (int i = 0; i < totalCases; ++i) {
            byte[] offsetBytes = byteCodeContext.getSpecifiedByteCodeArray(byteCode.getOperandBytes());
            int offset = Integer.valueOf(ByteUtils.bytesToHex(offsetBytes), DecompileConstants.HEX_RADIX);
            byteCode.addOffset(offset);
            totalBytes += byteCode.getOperandBytes();
        }

        // 6.设置当前字节码所占的字节总数
        byteCode.setTotalBytes(totalBytes);
        
        return (ByteCode) byteCode;
    }
}
