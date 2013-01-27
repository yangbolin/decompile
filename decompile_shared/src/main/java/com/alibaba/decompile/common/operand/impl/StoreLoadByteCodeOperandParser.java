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
 * 类StoreLoadByteCodeOperandParser.java的实现描述：字节码指令总有一个参数的store和load指令操作数的解析器
 * 注意:
 * 经过分析，发现istore,iload, dstore,dload, fstore,fload, astore,aload,lstore,lload等字节码指令用来
 * 操作栈顶数值和本地局部变量，本地局部变量需要一个索引来指定，栈顶的数值显然就没有必要来指定了，因此这些指令都有一个
 * 操作数，并且这个操作数所占的字节数目是1个字节，也就是说最大值是FF，其实深层次的意思就是说在JAVA中一个方法中最多
 * 能出现256个局部变量，这貌似应该是一个JAVA语言规范。
 * 
 * 当我看到wide时，才发现JAVA中一个方法中定义的局部变量可以大于0XFF,可以使用这个附件指令来扩展局部变量索引从1个字节
 * 到2个字节,wide指令均可作用在这些store和load指令前面，因此在节写这些store和load指令的时候要先回朔判断一下字节码
 * 前面是否有wide指令
 * 
 * 上面的回朔是一种解决策略，但是我们不采用回朔的思想，直接在字节码上下文中用一个标志来表示即可。这就需要我们在字节码上
 * 下文中去维护这样一个标志了。
 * 
 * </pre>
 * 
 * @author yangbolin Dec 30, 2012 4:08:39 PM
 */
public class StoreLoadByteCodeOperandParser implements ByteCodeOperandParser {

    /** 字节码操作数所占的字节数为1 **/
    private static final int OPERAND_ONE_BYTE = 1;
    /** 字节码操作数所占的字节数为2 **/
    private static final int OPERAND_TWO_BYTE = 2;

    @Override
    public ByteCode parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.创建返回值对象
        StoreLoadByteCode byteCode = new StoreLoadByteCode();
        
        // 1.根据字节码上下文中的hasWide标志来决定当前字节码指令参数所占的字节数目
        if (byteCodeContext.isHasWide()) {
            byteCode.setOperandBytes(OPERAND_TWO_BYTE);
            byteCode.setHasWide(true);
            byteCodeContext.setHasWide(false); // 一次使用过后马上还原
        } else {
            byteCode.setOperandBytes(OPERAND_ONE_BYTE);
        }

        // 2.读取操作数所占的字节数组
        byte[] operandBytes = byteCodeContext.getSpecifiedByteCodeArray(byteCode.getOperandBytes());
        
        // 3.转换成整型数字
        int operand = ByteUtils.bytesToInt(operandBytes);

        // 4.设置字节码操作数
        byteCode.setOperand(operand);
        
        return (ByteCode) byteCode;
    }
}
