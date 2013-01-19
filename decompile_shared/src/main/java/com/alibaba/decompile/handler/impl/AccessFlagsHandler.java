/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.handler.impl;

import com.alibaba.decompile.common.ByteUtils;
import com.alibaba.decompile.common.ClassAccessFlag;
import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.context.impl.AccessFlagsContext;
import com.alibaba.decompile.factory.DecompileFactory;
import com.alibaba.decompile.handler.DecompileHandler;

/**
 * ��AccessFlagsHandler.java��ʵ�������������Ȩ�޵Ĵ���
 * 
 * @author yangbolin Dec 11, 2012 9:46:26 AM
 */
public class AccessFlagsHandler extends DecompileHandler {
    /** ���ʱ�־�������� **/
    private AccessFlagsContext accessFlagsContext;
    
    @Override
    public void parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        System.out.println("***PARSE THE ACCESS PERMISSION OF CURRENT CLASS***");
        
        // 0.��ȡ����Ȩ�ޱ�־��ռ���ֽ�����
        byte[] classBytes = byteCodeContext.getClassByte();
        byte[] accessFlagBytes = new byte[DecompileConstants.ACCESS_FLAGS_BYTES];
        System.arraycopy(classBytes, byteCodeContext.getCurrentIndex(), accessFlagBytes, 0, DecompileConstants.ACCESS_FLAGS_BYTES);
        byteCodeContext.forwardCurrentIndexSteps(DecompileConstants.ACCESS_FLAGS_BYTES);
        
        int accessFlagsValue = Integer.valueOf(ByteUtils.bytesToHex(accessFlagBytes), DecompileConstants.HEX_RADIX);
        this.accessFlagsContext = new AccessFlagsContext();
        this.accessFlagsContext.setAccessFlagsValue(accessFlagsValue);
        
        // 1.��ÿһ�����ʱ�־�����жϣ��������Ƿ񱻰���������
        /**
         * ֮ǰ����д�˺ܶ�if��䣬�ж�ÿ��ö�����͵�ֵ���������ö�����͵�ֵ��û������صı�־λ�����Ӧ��
         * ����д��8��if��䣬�о��ܲ�ˬ����ΪҪ��ö��ֵ�ٶ�һ��������ζ���ұ���������һ��if��䣬������
         * ���������չ�Զ��Ծ��Ǹ�����
         */
        StringBuilder sb = new StringBuilder();
        for(ClassAccessFlag flag : ClassAccessFlag.values()) {
            if ((flag.getFlagValue() & accessFlagsValue) == 1 ) {
                accessFlagsContext.addAccessFlags(flag);
                sb.append(flag + " ");
            }
        }
        
        if (sb.length() == 0) {
            System.out.println("No decoration for current class");
        } else {
            System.out.println(sb.toString());
        }
        
        // 2.�����������ӵ������빤����
        decompileFactory.addDecompileContext(DecompileConstants.ACCESS_FLAGS_CONTEXT, this.accessFlagsContext);
        
        // 3.������һ�����������
        this.getNextHandler().parse(byteCodeContext, decompileFactory);
    }
}
