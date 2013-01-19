/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.constant.pool.backfill;

import com.alibaba.decompile.constant.pool.ConstantInfo;
import com.alibaba.decompile.constant.pool.AbstractConstantInfoBackFiller;
import com.alibaba.decompile.constant.pool.ConstantInfoBackFillFactory;
import com.alibaba.decompile.constant.pool.impl.ConstantStringInfo;
import com.alibaba.decompile.constant.pool.impl.ConstantUTF8Info;
import com.alibaba.decompile.context.impl.ConstantPoolContext;

/**
 * <pre>
 * 类ConstantStringInfoBackFill.java的实现描述：字符串类型常量的回填
 * </pre>
 * 
 * @author yangbolin Jan 3, 2013 2:53:16 PM
 */
public class ConstantStringInfoBackFiller extends AbstractConstantInfoBackFiller {

    public ConstantStringInfoBackFiller(ConstantInfoBackFillFactory backFillFactory){
        super(backFillFactory);
    }
    
    @Override
    public void backFill(ConstantPoolContext context, ConstantInfo constantInfo) {
        // 0.convert to ConstantStringInfo
        ConstantStringInfo constantStringInfo = (ConstantStringInfo)constantInfo;
        
        // 1.获取String类型的字符串在常量池中的索引
        int index = constantStringInfo.getIndexValue();
        
        // 2.获取常量池中一个UTF8类型的常量
        ConstantUTF8Info constantUTF8Info = (ConstantUTF8Info)context.getConstantInfoList().get(index - 1);
        
        // 3.描述信息的回填
        constantInfo.setStringDescription(constantUTF8Info.getUtf8String());
    }
}
