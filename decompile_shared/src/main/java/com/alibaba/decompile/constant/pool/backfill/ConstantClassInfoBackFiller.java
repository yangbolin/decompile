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
 * 类ConstantClassInfoBackFill.java的实现描述：常量池中class的描述信息回填
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
        // 0.转换成ConstantClassInfo
        ConstantClassInfo constantClassInfo = (ConstantClassInfo)constantInfo;
        
        // 1.获取class在常量池中的索引
        int index = constantClassInfo.getIndexValue();
        
        // 2.根据index找到UTF类型的字符串
        ConstantUTF8Info constantUTF8Info = (ConstantUTF8Info)context.getConstantInfoList().get(index - 1);
        
        // 3.设置常量池中class的描述信息
        constantInfo.setStringDescription(constantUTF8Info.getUtf8String());
    }

}
