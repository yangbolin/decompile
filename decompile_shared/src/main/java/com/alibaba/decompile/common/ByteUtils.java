/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common;

/**
 * 类ByteUtils.java的实现描述：字节操作的相关工具
 * 
 * @author yangbolin Dec 7, 2012 9:15:06 AM
 */
public class ByteUtils {
    /**
     * <pre>
     * 将一个字节转换成十六进制的字符串
     * </pre>
     * @param b
     * @return
     */
    public static String byteToHex(byte b) {
        return Integer.toHexString(b & 0xFF);
    }

    /**
     * <pre>
     * 将一个字节数组转换成一个十六进制的字符串
     * </pre>
     * @param bytes
     * @return
     */
    public static String bytesToHex(byte [] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; ++i) {
            sb.append(byteToHex(bytes[i]));
        }

        return sb.toString();
    }

    /**
     * <pre>
     * 把字节数组转换成浮点数
     * </pre>
     * @param bytes
     * @return
     */
    public static float bytesToFloat(byte[] bytes) {
        int l;
        l = bytes[0];
        l &= 0xff;
        l |= ((long) bytes[1] << 8);
        l &= 0xffff;
        l |= ((long) bytes[2] << 16);
        l &= 0xffffff;
        l |= ((long) bytes[3] << 24);
        return Float.intBitsToFloat(l);
    }

    /**
     * <pre>
     * 把字节数组转换成double类型的变量
     * </pre>
     * @param bytes
     * @return
     */
    public static double bytesToDouble(byte[] bytes) {
        long l;
        l = bytes[0];
        l &= 0xff;
        l |= ((long) bytes[1] << 8);
        l &= 0xffff;
        l |= ((long) bytes[2] << 16);
        l &= 0xffffff;
        l |= ((long) bytes[3] << 24);
        l &= 0xffffffffl;
        l |= ((long) bytes[4] << 32);
        l &= 0xffffffffffl;
        l |= ((long) bytes[5] << 40);
        l &= 0xffffffffffffl;
        l |= ((long) bytes[6] << 48);
        l &= 0xffffffffffffffl;
        l |= ((long) bytes[7] << 56);
        return Double.longBitsToDouble(l);
    }
    
    /**
     * <pre>
     * 把字节数组转换成long型数字
     * </pre>
     * @param bytes
     * @return
     */
    public static long bytesToLong(byte[] bytes) {
        return ((((long) bytes[7] & 0xff) << 56)  
                | (((long) bytes[6] & 0xff) << 48)  
                | (((long) bytes[5] & 0xff) << 40)  
                | (((long) bytes[4] & 0xff) << 32)  
                | (((long) bytes[3] & 0xff) << 24)  
                | (((long) bytes[2] & 0xff) << 16)  
                | (((long) bytes[1] & 0xff) << 8) 
                | (((long) bytes[0] & 0xff) << 0));
    }
}
