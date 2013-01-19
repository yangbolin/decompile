/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.handler.impl;

import com.alibaba.decompile.common.ByteUtils;
import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.context.impl.ClassContext;
import com.alibaba.decompile.context.impl.ConstantPoolContext;
import com.alibaba.decompile.factory.DecompileFactory;
import com.alibaba.decompile.handler.DecompileHandler;

/**
 * 类ClassHandler.java的实现描述：当前类的解析
 * 
 * @author yangbolin Dec 11, 2012 1:42:46 PM
 */
public class ClassHandler extends DecompileHandler {
    
    private ClassContext classContext;

    @Override
    public void parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        
        System.out.println("***PARSE THE CURRENT CLASS AND SUPER CLASS***");
        
        // 0.读取字节数组
        byte[] thisClassBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.THIS_CLASS_QUALIFIED_NAME_BYTES);
        byte[] superClassBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.SUPER_CLASS_QUALIFIED_NAME_BYTES);
        
        int thisClassIndex = Integer.valueOf(ByteUtils.bytesToHex(thisClassBytes), DecompileConstants.HEX_RADIX);
        int superClassIndex = Integer.valueOf(ByteUtils.bytesToHex(superClassBytes), DecompileConstants.HEX_RADIX);
        
        this.classContext = new ClassContext();
        this.classContext.setThisClassIndex(thisClassIndex);
        this.classContext.setSuperClassIndex(superClassIndex);
        
        // 1.根据常量池中描述符的索引查找全限定名
        ConstantPoolContext constantPoolContext = (ConstantPoolContext)decompileFactory.getDecompileContext(DecompileConstants.CONSTANT_POOL_CONTEXT);
        if (constantPoolContext == null) {
            System.out.println("Can't get the ConstantPoolContext while parsing ClassContext!");
            return;
        } 
        
        String thisClassQualifiedName = constantPoolContext.getClassQualifiedName(thisClassIndex);
        if (thisClassQualifiedName == null) {
            System.out.println("Can't get the qualified name of this class!");
            return;
        }
        
        String superClassQualifiedName = constantPoolContext.getClassQualifiedName(superClassIndex);
        if (superClassQualifiedName == null) {
            System.out.println("This class has not super class!");
        }
        
        // 2.设置当前类或者父类的全限定名称
        this.classContext.setThisClassQualifiedName(thisClassQualifiedName);
        this.classContext.setSuperClassQualifiedName(superClassQualifiedName);
        
        // 3.把上下文设置到反编译的工厂中
        decompileFactory.addDecompileContext(DecompileConstants.CLASS_CONTEXT, this.classContext);
        
        System.out.println(String.format("The current class is\t#%d\t#%s\nThe super class is\t#%d\t#%s", 
                                         thisClassIndex, thisClassQualifiedName, superClassIndex, superClassQualifiedName));
        
        // 4.s调用下一个处理句柄
        this.getNextHandler().parse(byteCodeContext, decompileFactory);
    }
}
