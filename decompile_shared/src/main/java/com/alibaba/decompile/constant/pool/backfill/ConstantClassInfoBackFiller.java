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
import com.alibaba.decompile.constant.pool.impl.ConstantClassInfo;
import com.alibaba.decompile.constant.pool.impl.ConstantUTF8Info;
import com.alibaba.decompile.context.impl.ConstantPoolContext;

/**
 * <pre>
 * ��ConstantClassInfoBackFill.java��ʵ����������������class��������Ϣ����
 * </pre>
 * 
 * @author yangbolin Jan 3, 2013 2:43:14 PM
 */
public class ConstantClassInfoBackFiller extends AbstractConstantInfoBackFiller {

    public ConstantClassInfoBackFiller(ConstantInfoBackFillFactory backFillFactory) {
        super(backFillFactory);
    }
    
    @Override
    public void backFill(ConstantPoolContext context, ConstantInfo constantInfo) {
        // 0.ת����ConstantClassInfo
        ConstantClassInfo constantClassInfo = (ConstantClassInfo)constantInfo;
        
        // 1.��ȡclass�ڳ������е�����
        int index = constantClassInfo.getIndexValue();
        
        // 2.����index�ҵ�UTF���͵��ַ���
        ConstantUTF8Info constantUTF8Info = (ConstantUTF8Info)context.getConstantInfoList().get(index - 1);
        
        // 3.���ó�������class��������Ϣ
        constantInfo.setStringDescription(constantUTF8Info.getUtf8String());
    }

}
