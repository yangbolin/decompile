/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.constant.pool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.decompile.constant.pool.backfill.ConstantClassInfoBackFiller;
import com.alibaba.decompile.constant.pool.backfill.ConstantFieldRefInfoBackFiller;
import com.alibaba.decompile.constant.pool.backfill.ConstantInterfaceMethodInfoBackFiller;
import com.alibaba.decompile.constant.pool.backfill.ConstantMethodInfoBackFiller;
import com.alibaba.decompile.constant.pool.backfill.ConstantNameAndTypeInfoBackFiller;
import com.alibaba.decompile.constant.pool.backfill.ConstantStringInfoBackFiller;
import com.alibaba.decompile.context.impl.ConstantPoolContext;

/**
 * <pre>
 * 类ConstantInfoBackFillFactory.java的实现描述：常量信息回填的工厂
 * </pre>
 * 
 * @author yangbolin Jan 3, 2013 4:11:08 PM
 */
public class ConstantInfoBackFillFactory {

    private Map<Integer, AbstractConstantInfoBackFiller> backFillMap = new HashMap<Integer, AbstractConstantInfoBackFiller>();

    public ConstantInfoBackFillFactory(){
        backFillMap.put(ConstantType.CONSTANT_CLASS_TAG.getIntValue(), new ConstantClassInfoBackFiller(this));
        backFillMap.put(ConstantType.CONSTANT_FIELD_REF_TAG.getIntValue(), new ConstantFieldRefInfoBackFiller(this));
        backFillMap.put(ConstantType.CONSTANT_INTERFACE_METHOD_REF_TAG.getIntValue(),
                        new ConstantInterfaceMethodInfoBackFiller(this));
        backFillMap.put(ConstantType.CONSTANT_METHOD_REF_TAG.getIntValue(), new ConstantMethodInfoBackFiller(this));
        backFillMap.put(ConstantType.CONSTANT_NAME_ADN_TYPE_TAG.getIntValue(), new ConstantNameAndTypeInfoBackFiller(this));
        backFillMap.put(ConstantType.CONSTANT_STRING_TAG.getIntValue(), new ConstantStringInfoBackFiller(this));
    }

    /**
     * <pre>
     * 常量池中常量信息回填
     * </pre>
     * 
     * @param context
     */
    public void backFill(ConstantPoolContext context) {
        // 0.获取常量池列表
        List<ConstantInfo> constantInfoList = context.getConstantInfoList();

        // 2.回填String
        for (ConstantInfo constantInfo : constantInfoList) {
            AbstractConstantInfoBackFiller constantBackFill = backFillMap.get(constantInfo.getTag());
            if (constantBackFill != null) {
                constantBackFill.backFill(context, constantInfo);
            }
        }
    }

    /**
     * <pre>
     * 获取特定的回填
     * </pre>
     * 
     * @param type
     * @return
     */
    public AbstractConstantInfoBackFiller getSpecBackFill(int type) {
        return this.backFillMap.get(type);
    }
}
