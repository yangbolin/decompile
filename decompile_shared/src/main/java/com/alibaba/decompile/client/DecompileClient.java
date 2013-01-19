/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.client;

import java.util.List;

import com.alibaba.decompile.common.ByteCode;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.context.JVMByteCodeContext;
import com.alibaba.decompile.factory.DecompileFactory;
import com.alibaba.decompile.file.ReadByteCodeFile;
import com.alibaba.decompile.file.ReadClassFile;
import com.alibaba.decompile.handler.impl.AccessFlagsHandler;
import com.alibaba.decompile.handler.impl.ClassHandler;
import com.alibaba.decompile.handler.impl.ConstantPoolHandler;
import com.alibaba.decompile.handler.impl.FieldsHandler;
import com.alibaba.decompile.handler.impl.InterfacesHandler;
import com.alibaba.decompile.handler.impl.MagicHandler;
import com.alibaba.decompile.handler.impl.MethodsHandler;
import com.alibaba.decompile.handler.impl.VersionHandler;

/**
 * <pre>
 * 类DecompileClient.java的实现描述：反编译的入口
 * 注:
 * 这里考虑一下如何获取到字段或者类的注解，目前还没有发现这个信息在字节码中如何表示
 * </pre>
 * 
 * @author yangbolin Dec 7, 2012 9:27:52 AM
 */
public class DecompileClient {
    
    public static void main(String[] args) throws Exception {
        // 0.class文件转换成byte数组
        ReadClassFile rcf = new ReadClassFile("/home/yangbolin/ACM/JAVA/1003/MaxSum.class");
        
        // 1.构建字节码上下文
        ByteCodeContext bcc = new ByteCodeContext();
        bcc.setClassByte(rcf.getClassByte());
        
        // 2.从XML文件中读取字节码数据
        ReadByteCodeFile readByteCodeFile = new ReadByteCodeFile("/bytecode/bytecode.xml");
        List<ByteCode> byteCodeList = readByteCodeFile.parse();
        JVMByteCodeContext jvmByteCodeContext = new JVMByteCodeContext();
        jvmByteCodeContext.setByteCodeList(byteCodeList);
        
        // 3.从魔数开始解析
        MagicHandler magicHandler = new MagicHandler();
        
        // 4.解析完魔数之后解析版本号
        VersionHandler versionHandler = new VersionHandler();
        magicHandler.setNextHandler(versionHandler);
        
        // 5.解析完版本号之后解析常量区
        ConstantPoolHandler constantPoolHandler = new ConstantPoolHandler();
        versionHandler.setNextHandler(constantPoolHandler);
        
        // 6.解析完常量区之后解析类的访问权限
        AccessFlagsHandler accessFlagsHandler = new AccessFlagsHandler();
        constantPoolHandler.setNextHandler(accessFlagsHandler);
        
        // 7.解析完类的访问权限之后解析当前类的全限定名称以及父类的全限定名称
        ClassHandler classHandler = new ClassHandler();
        accessFlagsHandler.setNextHandler(classHandler);
        
        // 8.解析完当前类以及父类的全限定名称之后再解析接口的全限定名称
        InterfacesHandler interfacesHandler = new InterfacesHandler();
        classHandler.setNextHandler(interfacesHandler);
        
        // 9.解析完接口之后，解析字段
        FieldsHandler fieldsHandler = new FieldsHandler();
        interfacesHandler.setNextHandler(fieldsHandler);
        
        // 10.解析完字段之后，解析方法
        MethodsHandler methodsHandler = new MethodsHandler();
        fieldsHandler.setNextHandler(methodsHandler);
        
        DecompileFactory decompileFactory = new DecompileFactory();
        decompileFactory.setJvmByteCodeContext(jvmByteCodeContext);         //把字节码上下文设置到反编译工厂中
        
        magicHandler.parse(bcc, decompileFactory);
    }
}
