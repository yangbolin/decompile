/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.frame;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.decompile.frame.info.VerificationTypeInfo;

/**
 * <pre>
 * ��AppendFrame.java��ʵ��������tagֵΪ[252-254]��offset_delta=offset_delta����ʾ������
 * ջΪ�գ�����ǰջ֡�еľֲ�������ǰһ֡�еľֲ�������frame_type-251���������Ҳ������frame_type - 251
 * ���verification_type_info����
 * </pre>
 * 
 * @author yangbolin Jan 25, 2013 7:55:06 PM
 */
public class AppendFrame extends SMTPFrame {

    /** �����б� **/
    private List<VerificationTypeInfo> typeInfoList = new ArrayList<VerificationTypeInfo>();

    public void addTypeInfo(VerificationTypeInfo typeInfo) {
        this.typeInfoList.add(typeInfo);
    }

    public List<VerificationTypeInfo> getTypeInfoList() {
        return typeInfoList;
    }

    public void setTypeInfoList(List<VerificationTypeInfo> typeInfoList) {
        this.typeInfoList = typeInfoList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString() + "\n");
        sb.append("\t[");
        for (VerificationTypeInfo typeInfo : this.typeInfoList) {
            sb.append(String.format(" %s ", typeInfo.toString()));
        }
        
        sb.append("]");
        
        return sb.toString();
    }
}
