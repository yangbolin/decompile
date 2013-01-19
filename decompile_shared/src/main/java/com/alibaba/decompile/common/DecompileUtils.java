/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common;

/**
 * 类DecompileUtils.java的实现描述：反编译工具函数
 * 
 * @author yangbolin Dec 14, 2012 11:31:15 AM
 */
public class DecompileUtils {
    /**
     * <pre>
     * 删除十六进制数字的0x前缀
     * </pre>
     * @param hexString
     * @return
     */
    public static String deleteHexPrefix(String hexString) {
        return hexString.substring(2);
    }
}
