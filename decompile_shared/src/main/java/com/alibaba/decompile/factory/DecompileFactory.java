/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.factory;

import java.util.HashMap;
import java.util.Map;
import com.alibaba.decompile.context.DecompileContext;
import com.alibaba.decompile.context.JVMByteCodeContext;

/**
 * ��DecompileFactory.java��ʵ�������������빤��
 * 
 * @author yangbolin Dec 7, 2012 9:25:42 AM
 */
public class DecompileFactory {
    /** JVM�ֽ��������� **/
    private JVMByteCodeContext jvmByteCodeContext;
    
    /** �洢�����׶ν����������ֽ��������� **/
    private Map<String, DecompileContext> contextFactory = new HashMap<String, DecompileContext>();
    
    /** ����һ���׶ε��ֽ��������� **/
    public void addDecompileContext(String name, DecompileContext context) {
        contextFactory.put(name, context);
    }
    
    /**
     * <pre>
     * ��ȡĳһ�׶εķ�����������
     * ע��:
     * �ڵ������������ʱ������Ҫ�������������ķ���ֵ���ܻ��ǿ�ָ��
     * </pre>
     * @param name
     * @return
     */
    public DecompileContext getDecompileContext(String name) {
        return contextFactory.get(name);
    }

    public JVMByteCodeContext getJvmByteCodeContext() {
        return jvmByteCodeContext;
    }

    public void setJvmByteCodeContext(JVMByteCodeContext jvmByteCodeContext) {
        this.jvmByteCodeContext = jvmByteCodeContext;
    }

    public Map<String, DecompileContext> getContextFactory() {
        return contextFactory;
    }

    public void setContextFactory(Map<String, DecompileContext> contextFactory) {
        this.contextFactory = contextFactory;
    }
}
