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
 * 类IincByteCodeOperandParser.java的实现描述：iinc字节码指令操作数的解析
 * 注:
 * 该指令的的意思是将一个整型局部变量增加相应的值，然后存储到整型变量中，那么这条
 * 指令就需要两个操作数，一个操作数要能定位到整型变量，另外一个操作数表示这个整型
 * 变量需要增加的数值。
 * 假如有如下源代码:
 * int i = 1;
 * i += 2;
 * javac后会生成如下字节码:
 * iinc 1, 2
 * 其中1表示i局部变量的索引，2表示需要给i增加的整型数值
 * 对应的二进制表示形式为:8401 02xx,其中84表示iinc字节码的索引，01和02就不用
 * 多解释了。我在本地JDK64位尝试的结果如下：为了好描述，我们考虑使用m来表示需要
 * 增加数值，如果m的取值小于128，则生成的iinc的字节码，如果m的取值大于等于128并
 * 且小于等于65535，生成的是iinc_w字节码，如果m的值大于65535则不会生成iinc或者
 * iinc_w的字节码指令，生成的就是add相关的字节码了。
 * 
 * 查看二进制文件，如何区分iinc和iinc_w呢？我在【深入理解JVM】那本书中没有找到
 * iinc_w这条字节码，还在ITEYE的JVM交流组中发个帖咨询一下这个事情
 * http://hllvm.group.iteye.com/group/topic/35386
 * 
 * 最后仔细分析一下二进制文件发现如果是iinc指令，则直接是以84开头的，但是如果是iinc_w
 * 指令则会以c484来表示字节码指令iinc_w,接下来的局部变量的i索引以及m值都以两个字节来
 * 表示。
 * 
 * 假如有如下代码:
 * int i = 2;
 * i += 128;
 * 生成的字节码指令是:
 * iinc_w 1, 128
 * 对应的二进制文件流是:
 * c484 0001 0080
 * 这里默认局部变量i的索引是1
 * 
 * 因此在解析iinc字节码指令的时候要做一个判断
 * 
 * 其实这里的c4就是一个wide字节码指令
 * 
 * </pre>
 * 
 * @author yangbolin Dec 30, 2012 1:52:27 PM
 */
public class IincByteCodeOperandParser implements ByteCodeOperandParser {

    @Override
    public ByteCode parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        // 0.创建返回值对象
        IincByteCode byteCode = new IincByteCode();
        
        int totalBytes = DecompileConstants.BYTE_CODE_SYMBOL_CODE_BYTE;
        
        // 1.判断操作数所占的字节数目 
        if (byteCodeContext.isHasWide()) {
            byteCode.setOperandBytes(DecompileConstants.OPERAND_TWO_BYTE);
            byteCode.setHasWide(true);
            byteCodeContext.setHasWide(false);      //  一次使用后马上还原
            
            // 该字节码前面有wide字节码
            totalBytes += DecompileConstants.BYTE_CODE_SYMBOL_CODE_BYTE;        
        } else {
            byteCode.setOperandBytes(DecompileConstants.OPERAND_ONE_BYTE);
        }
        
        // 2.读取操作数之本地变量的索引
        byte[] indexBytes = byteCodeContext.getSpecifiedByteCodeArray(byteCode.getOperandBytes());
        int index = Integer.valueOf(ByteUtils.bytesToHex(indexBytes), DecompileConstants.HEX_RADIX);
        byteCode.setIndex(index);
        
        totalBytes += byteCode.getOperandBytes();
        
        // 3.读取需要增加的常量值
        byte[] constValueBytes = byteCodeContext.getSpecifiedByteCodeArray(byteCode.getOperandBytes());
        int constValue = Integer.valueOf(ByteUtils.bytesToHex(constValueBytes), DecompileConstants.HEX_RADIX);
        byteCode.setConstValue(constValue);
        
        totalBytes += byteCode.getOperandBytes();
        
        // 4.设置当前字节码所占的字节数目
        byteCode.setTotalBytes(totalBytes);
        
        return (ByteCode)byteCode;
    }
}
