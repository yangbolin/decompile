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
 * 类ConstantNameAndTypeBackFill.java的实现描述：字段或者方法的部分符号引用的描述信息回填
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
        // 0.转换成ConstantNameAndType类型的常量
        ConstantNameAndTypeInfo constantNameAndTypeInfo = (ConstantNameAndTypeInfo)constantInfo;
        
        // 1.获取字段或者方法名称在常量池中的索引
        int index = constantNameAndTypeInfo.getNameIndexValue();
        
        // 2.根据索引获取常量池中一个UTF8类型的常量
        ConstantUTF8Info constantUTF8Info1 = (ConstantUTF8Info)context.getConstantInfoList().get(index - 1);
        
        // 3.获取方法或者字段的描述符
        int descriptor = constantNameAndTypeInfo.getDescriptorValue();
        
        // 4.根据描述符获取一个UTF8类型的常量
        ConstantUTF8Info constantUTF8Info2 = (ConstantUTF8Info)context.getConstantInfoList().get(descriptor - 1);
        
        StringBuilder sb = new StringBuilder();
        sb.append(constantUTF8Info1.getUtf8String());
        sb.append(":");
        sb.append(constantUTF8Info2.getUtf8String());
        
        constantInfo.setStringDescription(sb.toString());
    }

}
