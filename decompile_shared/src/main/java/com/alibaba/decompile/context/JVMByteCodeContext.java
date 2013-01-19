/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.context;

import java.util.ArrayList;
import java.util.List;
import com.alibaba.decompile.common.ByteCode;

/**
 * ��JVMByteCodeContext.java��ʵ��������JVM�ֽ���������
 * @author yangbolin Dec 14, 2012 10:09:09 AM
 */
public class JVMByteCodeContext {
    
    /** �ֽ����б� **/
    private List<ByteCode> byteCodeList = new ArrayList<ByteCode>();
    
    /**
     * <pre>
     * ���ֽ����б�������һ���ֽ���
     * </pre>
     * @param byteCode
     */
    public void addByteCode(ByteCode byteCode) {
        this.byteCodeList.add(byteCode);
    }
    
    /**
     * <pre>
     * ����code�����ֽ����б���ж��ֲ���
     * ע��:
     * ����������ܷ��ؿ�ֵ����ʹ�õ�ʱ��Ҫע���ж�NPE
     * </pre>
     * @param code
     * @return
     */
    public ByteCode findByteCodeByCode(int code) {
        int low = 0;
        int high = this.byteCodeList.size() - 1;
        ByteCode byteCode = null;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            byteCode = this.byteCodeList.get(mid);
            if (byteCode.getCode() == code) {
                return byteCode;
            } else if (byteCode.getCode() < code) {
                low = mid + 1;
            } else if (byteCode.getCode() > code) {
                high = mid - 1;
            }
        }
        return null;
    }
    
    public List<ByteCode> getByteCodeList() {
        return byteCodeList;
    }
    
    public void setByteCodeList(List<ByteCode> byteCodeList) {
        this.byteCodeList = byteCodeList;
    }
}
