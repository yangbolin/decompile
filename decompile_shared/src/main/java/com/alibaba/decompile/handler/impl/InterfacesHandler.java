/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.handler.impl;

import java.util.List;

import com.alibaba.decompile.common.ByteUtils;
import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.context.impl.ConstantPoolContext;
import com.alibaba.decompile.context.impl.InterfacesContext;
import com.alibaba.decompile.factory.DecompileFactory;
import com.alibaba.decompile.handler.DecompileHandler;

/**
 * ��InterfacesHandler.java��ʵ����������ǰ����ʵ�ֵĽӿڻ��ߵ�ǰ�ӿ���ʵ�ֵĽӿڴ�����
 * 
 * @author yangbolin Dec 11, 2012 4:20:10 PM
 */
public class InterfacesHandler extends DecompileHandler {
    /** �ӿ������� **/
    private InterfacesContext intefacesContext;
    
    @Override
    public void parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        
        System.out.println("***PARSE INTERFACES IMPLEMENTED***");
        
        // 0.��ȡ��ص��ֽ�����
        byte[] countBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.INTERFACES_COUNT_BYTES);
        
        this.intefacesContext = new InterfacesContext();
        
        int count = Integer.valueOf(ByteUtils.bytesToHex(countBytes), DecompileConstants.HEX_RADIX);
        this.intefacesContext.setCount(count);
        
        ConstantPoolContext constantPoolContext = (ConstantPoolContext)decompileFactory.getDecompileContext(DecompileConstants.CONSTANT_POOL_CONTEXT);
        
        // 1.���ζ�ȡÿһ���ӿ�
        for (int i = 0; i < count; ++i) {
            byte[] qualifiedNameBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.INTERFACE_QUALIFIED_NAME_BYTES);

            int index = Integer.valueOf(ByteUtils.bytesToHex(qualifiedNameBytes), DecompileConstants.HEX_RADIX);
            this.intefacesContext.addIndex(index);
            String qualifiedName = constantPoolContext.getClassQualifiedName(index);
            if (qualifiedName != null) {
                this.intefacesContext.addQualifiedName(qualifiedName);
            } else {
                System.out.println(String.format("Can't get the qualified name from constan pool for interface index %d", index));
                return;
            }
        }
        
        // 2.�ѽӿ����������õ�����֮��
        decompileFactory.addDecompileContext(DecompileConstants.INTERFACES_CONTEXT, this.intefacesContext);
        
        if (count == 0) {
            System.out.println("There is no interface implemented!");
        } else {
            List<Integer> indexList = this.intefacesContext.getIndexList();
            List<String> qualifiedNameList = this.intefacesContext.getQualifiedNameList();
            int size = indexList.size();
            
            for (int i = 0; i < size; ++i) {
                System.out.println(String.format("interface\t#%d\t#%s", indexList.get(i), qualifiedNameList.get(i)));
            }
        }
        
        // 3.0 ������һ��������
        this.getNextHandler().parse(byteCodeContext, decompileFactory);
    }
}
