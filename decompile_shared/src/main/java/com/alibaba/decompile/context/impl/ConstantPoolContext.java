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
 * ��ConstantPoolContext.java��ʵ�������������ؽ���������������
 * ע��
 * �����ڳ������е������Ǵ�1��ʼ�ģ����������ǿ��԰�constantInfoList������һ�������أ�
 * �����������һ�����飬������±��Ǵ�0��ʼ�ģ���ʹ�õ�ʱ������Ҫע����һ�㣬����˵���
 * �����е�����ΪN����ô��Ӧ��������е���������N-1
 * </pre>
 * 
 * @author yangbolin Dec 7, 2012 5:27:08 PM
 */
public class ConstantPoolContext extends DecompileContext {

    /** ��������Ŀ **/
    private int                constantNum;

    /** �����б����� **/
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
     * ����һ��������Ϣ������������
     * </pre>
     * 
     * @param constantInfo
     */
    public void addConstantInfo(ConstantInfo constantInfo) {
        this.constantInfoList.add(constantInfo);
    }

    /**
     * <pre>
     * ������������ȡ����߽ӿڵ�ȫ�޶�����
     * ע��:
     * ��ʹ�����������ʱ��ע���ж�NULL
     * </pre>
     * 
     * @param index
     * @return
     */
    public String getClassQualifiedName(int index) {
        // 0.���������ҵ�������������߽ӿڵķ�������
        if (index < 1 || index > constantInfoList.size()) {
            return null;
        }
        ConstantClassInfo constantClassInfo = (ConstantClassInfo) constantInfoList.get(index - 1);
        int descriptor = constantClassInfo.getIndexValue();

        // 1.�����������ҵ�ȫ�޶�����String
        if (descriptor < 1 || descriptor > constantInfoList.size()) {
            return null;
        }

        // 2.����ȫ�޶������ַ���
        ConstantUTF8Info constantUTF8Info = (ConstantUTF8Info) constantInfoList.get(descriptor - 1);
        return constantUTF8Info.getUtf8String();
    }

    /**
     * <pre>
     * ���ݳ������е���������ȡ�������е�һ���ַ���
     * ע��:
     * ��ʹ�����������ʱ��ע��NPE���ж�
     * </pre>
     * 
     * @param index
     * @return
     */
    public String getUTF8tringByIndex(int index) {
        // 0.�жϳ������е������Ƿ��ڷ�Χ֮��
        if (index < 1 || index > constantInfoList.size()) {
            return null;
        }

        // 1.����index��ȡutf8��ʽ���ַ���
        ConstantUTF8Info constantUtf8Info = (ConstantUTF8Info) constantInfoList.get(index - 1);
        return constantUtf8Info.getUtf8String();
    }

    /**
     * <pre>
     * ����������ȡһ���������еĳ���
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
     * �ڿ���̨�����������Ϣ
     * </pre>
     */
    public void outPutConstantsPool() {
        for (int i = 0; i < this.constantInfoList.size(); ++i) {
            ConstantInfo constantInfo = this.constantInfoList.get(i);
            System.out.println(String.format("const #%d = %s", i + 1, constantInfo.toString()));
        }
    }
}
