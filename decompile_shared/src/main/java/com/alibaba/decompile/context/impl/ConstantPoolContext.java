/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.context.impl;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.decompile.constant.pool.ConstantInfo;
import com.alibaba.decompile.constant.pool.impl.ConstantClassInfo;
import com.alibaba.decompile.constant.pool.impl.ConstantUTF8Info;
import com.alibaba.decompile.context.DecompileContext;

/**
 * <pre>
 * 类ConstantPoolContext.java的实现描述：常量池解析出来的上下文
 * 注：
 * 常量在常量池中的索引是从1开始的，在这里我们可以把constantInfoList看作是一个常量池，
 * 这个常量池是一个数组，数组的下标是从0开始的，在使用的时候我们要注意这一点，就是说如果
 * 常量中的索引为N，那么对应这个数组中的索引就是N-1
 * </pre>
 * 
 * @author yangbolin Dec 7, 2012 5:27:08 PM
 */
public class ConstantPoolContext extends DecompileContext {

    /** 常量的数目 **/
    private int                constantNum;

    /** 常量列表数组 **/
    private List<ConstantInfo> constantInfoList = new ArrayList<ConstantInfo>();

    public int getConstantNum() {
        return constantNum;
    }

    public void setConstantNum(int constantNum) {
        this.constantNum = constantNum;
    }

    public List<ConstantInfo> getConstantInfoList() {
        return constantInfoList;
    }

    public void setConstantInfoList(List<ConstantInfo> constantInfoList) {
        this.constantInfoList = constantInfoList;
    }

    /**
     * <pre>
     * 增加一个常量信息到常量数组中
     * </pre>
     * 
     * @param constantInfo
     */
    public void addConstantInfo(ConstantInfo constantInfo) {
        this.constantInfoList.add(constantInfo);
    }

    /**
     * <pre>
     * 根据描述符获取类或者接口的全限定名称
     * 注意:
     * 在使用这个方法的时候注意判断NULL
     * </pre>
     * 
     * @param index
     * @return
     */
    public String getClassQualifiedName(int index) {
        // 0.根据索引找到常量池中类或者接口的符号引用
        if (index < 1 || index > constantInfoList.size()) {
            return null;
        }
        ConstantClassInfo constantClassInfo = (ConstantClassInfo) constantInfoList.get(index - 1);
        int descriptor = constantClassInfo.getIndexValue();

        // 1.根据描述符找到全限定名的String
        if (descriptor < 1 || descriptor > constantInfoList.size()) {
            return null;
        }

        // 2.返回全限定名的字符串
        ConstantUTF8Info constantUTF8Info = (ConstantUTF8Info) constantInfoList.get(descriptor - 1);
        return constantUTF8Info.getUtf8String();
    }

    /**
     * <pre>
     * 根据常量池中的索引来获取常量池中的一个字符串
     * 注意:
     * 在使用这个方法的时候注意NPE的判断
     * </pre>
     * 
     * @param index
     * @return
     */
    public String getUTF8tringByIndex(int index) {
        // 0.判断常量池中的索引是否在范围之内
        if (index < 1 || index > constantInfoList.size()) {
            return null;
        }

        // 1.根据index获取utf8格式的字符串
        ConstantUTF8Info constantUtf8Info = (ConstantUTF8Info) constantInfoList.get(index - 1);
        return constantUtf8Info.getUtf8String();
    }

    /**
     * <pre>
     * 根据索引获取一个常量池中的常量
     * </pre>
     * 
     * @param index
     * @return
     */
    public ConstantInfo getConstantInfoByIndex(int index) {
        return this.constantInfoList.get(index);
    }

    /**
     * <pre>
     * 在控制台输出常量池信息
     * </pre>
     */
    public void outPutConstantsPool() {
        for (int i = 0; i < this.constantInfoList.size(); ++i) {
            ConstantInfo constantInfo = this.constantInfoList.get(i);
            System.out.println(String.format("const #%d = %s", i + 1, constantInfo.toString()));
        }
    }
}
