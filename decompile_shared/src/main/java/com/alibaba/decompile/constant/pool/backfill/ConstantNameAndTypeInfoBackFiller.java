/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.constant.pool.backfill;

import com.alibaba.decompile.constant.pool.AbstractConstantInfoBackFiller;
import com.alibaba.decompile.constant.pool.ConstantInfo;
import com.alibaba.decompile.constant.pool.ConstantInfoBackFillFactory;
import com.alibaba.decompile.constant.pool.impl.ConstantNameAndTypeInfo;
import com.alibaba.decompile.constant.pool.impl.ConstantUTF8Info;
import com.alibaba.decompile.context.impl.ConstantPoolContext;

/**
 * <pre>
 * ��ConstantNameAndTypeBackFill.java��ʵ���������ֶλ��߷����Ĳ��ַ������õ�������Ϣ����
 * </pre>
 * 
 * @author yangbolin Jan 3, 2013 4:01:15 PM
 */
public class ConstantNameAndTypeInfoBackFiller extends AbstractConstantInfoBackFiller {

    public ConstantNameAndTypeInfoBackFiller(ConstantInfoBackFillFactory backFillFactory){
        super(backFillFactory);
    }
    
    @Override
    public void backFill(ConstantPoolContext context, ConstantInfo constantInfo) {
        // 0.ת����ConstantNameAndType���͵ĳ���
        ConstantNameAndTypeInfo constantNameAndTypeInfo = (ConstantNameAndTypeInfo)constantInfo;
        
        // 1.��ȡ�ֶλ��߷��������ڳ������е�����
        int index = constantNameAndTypeInfo.getNameIndexValue();
        
        // 2.����������ȡ��������һ��UTF8���͵ĳ���
        ConstantUTF8Info constantUTF8Info1 = (ConstantUTF8Info)context.getConstantInfoList().get(index - 1);
        
        // 3.��ȡ���������ֶε�������
        int descriptor = constantNameAndTypeInfo.getDescriptorValue();
        
        // 4.������������ȡһ��UTF8���͵ĳ���
        ConstantUTF8Info constantUTF8Info2 = (ConstantUTF8Info)context.getConstantInfoList().get(descriptor - 1);
        
        StringBuilder sb = new StringBuilder();
        sb.append(constantUTF8Info1.getUtf8String());
        sb.append(":");
        sb.append(constantUTF8Info2.getUtf8String());
        
        constantInfo.setStringDescription(sb.toString());
    }

}
