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
 * 类DecompileFactory.java的实现描述：反编译工厂
 * 
 * @author yangbolin Dec 7, 2012 9:25:42 AM
 */
public class DecompileFactory {
    /** JVM字节码上下文 **/
    private JVMByteCodeContext jvmByteCodeContext;
    
    /** 存储各个阶段解析出来的字节码上下文 **/
    private Map<String, DecompileContext> contextFactory = new HashMap<String, DecompileContext>();
    
    /** 增加一个阶段的字节码上下问 **/
    public void addDecompileContext(String name, DecompileContext context) {
        contextFactory.put(name, context);
    }
    
    /**
     * <pre>
     * 获取某一阶段的反编译上下文
     * 注意:
     * 在调用这个方法的时候，我们要清楚，这个方法的返回值可能会是空指针
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
