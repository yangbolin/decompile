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
import com.alibaba.decompile.constant.pool.impl.ConstantMethodInfo;
import com.alibaba.decompile.constant.pool.impl.ConstantNameAndTypeInfo;
import com.alibaba.decompile.context.impl.ConstantPoolContext;

/**
 * <pre>
 * 类ConstantMethodInfoBackFill.java的实现描述：常量池中类方法信息的回填
 * </pre>
 * 
 * @author yangbolin Jan 3, 2013 3:48:11 PM
 */
public class ConstantMethodInfoBackFiller extends AbstractConstantInfoBackFiller {

    public ConstantMethodInfoBackFiller(ConstantInfoBackFillFactory backFillFactory){
        super(backFillFactory);
    }
    
    @Override
    public void backFill(ConstantPoolContext context, ConstantInfo constantInfo) {
        // 0.转换成ConstantMethodInfo类型的常量对象
        ConstantMethodInfo constantMethodInfo = (ConstantMethodInfo) constantInfo;

        // 1.获取类索引
        int index = constantMethodInfo.getClassIndexValue();

        // 2.在常量池中获取一个ConstantInfoClass类型的常量
        ConstantClassInfo constantClassInfo = (ConstantClassInfo) context.getConstantInfoList().get(index - 1);
        if (constantClassInfo.getStringDescription() == null) {
            ConstantClassInfoBackFiller backFiller = (ConstantClassInfoBackFiller)this.getBackFillFactory().getSpecBackFill(constantClassInfo.getTag());
            backFiller.backFill(context, constantClassInfo);
        }

        // 3.获取描述符
        int descriptor = constantMethodInfo.getDescriptorValue();

        // 4.在常量池中获取一个NameAndType类型的常量
        ConstantNameAndTypeInfo constantNameAndTypeInfo = (ConstantNameAndTypeInfo) context.getConstantInfoList().get(descriptor - 1);
        if(constantNameAndTypeInfo.getStringDescription() == null) {
            ConstantNameAndTypeInfoBackFiller backFiller = (ConstantNameAndTypeInfoBackFiller)this.getBackFillFactory().getSpecBackFill(constantNameAndTypeInfo.getTag());
            backFiller.backFill(context, constantNameAndTypeInfo);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(constantClassInfo.getStringDescription());
        sb.append(".");
        sb.append(constantNameAndTypeInfo.getStringDescription());
        
        constantInfo.setStringDescription(sb.toString());
    }
}
