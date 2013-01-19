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
 * ��DecompileClient.java��ʵ������������������
 * ע:
 * ���￼��һ����λ�ȡ���ֶλ������ע�⣬Ŀǰ��û�з��������Ϣ���ֽ�������α�ʾ
 * </pre>
 * 
 * @author yangbolin Dec 7, 2012 9:27:52 AM
 */
public class DecompileClient {
    
    public static void main(String[] args) throws Exception {
        // 0.class�ļ�ת����byte����
        ReadClassFile rcf = new ReadClassFile("/home/yangbolin/ACM/JAVA/1003/MaxSum.class");
        
        // 1.�����ֽ���������
        ByteCodeContext bcc = new ByteCodeContext();
        bcc.setClassByte(rcf.getClassByte());
        
        // 2.��XML�ļ��ж�ȡ�ֽ�������
        ReadByteCodeFile readByteCodeFile = new ReadByteCodeFile("/bytecode/bytecode.xml");
        List<ByteCode> byteCodeList = readByteCodeFile.parse();
        JVMByteCodeContext jvmByteCodeContext = new JVMByteCodeContext();
        jvmByteCodeContext.setByteCodeList(byteCodeList);
        
        // 3.��ħ����ʼ����
        MagicHandler magicHandler = new MagicHandler();
        
        // 4.������ħ��֮������汾��
        VersionHandler versionHandler = new VersionHandler();
        magicHandler.setNextHandler(versionHandler);
        
        // 5.������汾��֮�����������
        ConstantPoolHandler constantPoolHandler = new ConstantPoolHandler();
        versionHandler.setNextHandler(constantPoolHandler);
        
        // 6.�����곣����֮�������ķ���Ȩ��
        AccessFlagsHandler accessFlagsHandler = new AccessFlagsHandler();
        constantPoolHandler.setNextHandler(accessFlagsHandler);
        
        // 7.��������ķ���Ȩ��֮�������ǰ���ȫ�޶������Լ������ȫ�޶�����
        ClassHandler classHandler = new ClassHandler();
        accessFlagsHandler.setNextHandler(classHandler);
        
        // 8.�����굱ǰ���Լ������ȫ�޶�����֮���ٽ����ӿڵ�ȫ�޶�����
        InterfacesHandler interfacesHandler = new InterfacesHandler();
        classHandler.setNextHandler(interfacesHandler);
        
        // 9.������ӿ�֮�󣬽����ֶ�
        FieldsHandler fieldsHandler = new FieldsHandler();
        interfacesHandler.setNextHandler(fieldsHandler);
        
        // 10.�������ֶ�֮�󣬽�������
        MethodsHandler methodsHandler = new MethodsHandler();
        fieldsHandler.setNextHandler(methodsHandler);
        
        DecompileFactory decompileFactory = new DecompileFactory();
        decompileFactory.setJvmByteCodeContext(jvmByteCodeContext);         //���ֽ������������õ������빤����
        
        magicHandler.parse(bcc, decompileFactory);
    }
}
