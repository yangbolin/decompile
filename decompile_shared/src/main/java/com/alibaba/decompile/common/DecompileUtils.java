/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common;

/**
 * ��DecompileUtils.java��ʵ�������������빤�ߺ���
 * 
 * @author yangbolin Dec 14, 2012 11:31:15 AM
 */
public class DecompileUtils {
    /**
     * <pre>
     * ɾ��ʮ���������ֵ�0xǰ׺
     * </pre>
     * @param hexString
     * @return
     */
    public static String deleteHexPrefix(String hexString) {
        return hexString.substring(2);
    }
}
