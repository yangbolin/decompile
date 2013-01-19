/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.constant.pool;

import com.alibaba.decompile.context.impl.ConstantPoolContext;

/**
 * <pre>
 * ��ConstantInfoBackFill.java��ʵ������������һЩ������������Ϣ
 * </pre>
 * 
 * @author yangbolin Jan 3, 2013 2:39:00 PM
 */
public abstract class AbstractConstantInfoBackFiller {
    
    private ConstantInfoBackFillFactory backFillFactory;
    
    protected AbstractConstantInfoBackFiller(ConstantInfoBackFillFactory backFillFactory) {
        this.backFillFactory = backFillFactory;
    }
    
    public ConstantInfoBackFillFactory getBackFillFactory() {
        return backFillFactory;
    }

    public void setBackFillFactory(ConstantInfoBackFillFactory backFillFactory) {
        this.backFillFactory = backFillFactory;
    }


    /**
     * <pre>
     * �������һЩ������Ϣ
     * </pre>
     * 
     * @param context
     * @param constantInfo
     */
    protected abstract void backFill(ConstantPoolContext context, ConstantInfo constantInfo);
}
