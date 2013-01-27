/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common.utils;

import com.alibaba.decompile.common.DescriptorType;
import com.alibaba.decompile.method.MethodArgs;

/**
 * <pre>
 * 类MethodUtils.java的实现描述：解析方法时需要的一些工具函数
 * </pre>
 * 
 * @author yangbolin Jan 27, 2013 3:06:07 PM
 */
public class MethodUtils {

    /**
     * <pre>
     * 根据方法的描述符获取方法参数的数目
     * </pre>
     * 
     * @param descriptor
     * @return
     */
    public static MethodArgs getArgsSizeByDescriptor(String descriptor) {

        MethodArgs methodArgs = new MethodArgs();

        // 0.解析左右括号之间的字符串
        int start = descriptor.indexOf("(");
        int end = descriptor.indexOf(")");
        String argsSizeString = descriptor.substring(start + 1, end);

        if (argsSizeString == null || argsSizeString.isEmpty()) {
            methodArgs.setNum(0);
            methodArgs.setTypeDescriptor("");
            return methodArgs;
        }

        int argsSize = 0;
        StringBuilder sb = new StringBuilder();

        StringBuilder arrayDescriptor = new StringBuilder();
        String last = "";
        // 1.计算参数数目,拼接参数描述符
        for (int i = 0; i < argsSizeString.length(); ++i) {
            if (argsSizeString.charAt(i) == 'L') {
                argsSize += 1;
                int nextLindex = argsSizeString.indexOf(";", i);
                if (nextLindex >= 0) {
                    if (last.equals("[")) {
                        sb.append(arrayDescriptor.toString());
                        arrayDescriptor = new StringBuilder();
                    }
                    if (i == 0 || last.equals("[")) {
                        sb.append(getType(argsSizeString.substring(i, nextLindex)));
                    } else {
                        sb.append(", " + getType(argsSizeString.substring(i, nextLindex)));
                    }
                    i = nextLindex;
                }
            } else if (argsSizeString.charAt(i) == '[') {
                arrayDescriptor.append("[");
            } else {
                argsSize += 1;
                if (i == 0) {
                    sb.append(getType(String.valueOf(argsSizeString.charAt(i))));
                } else {
                    sb.append(", " + getType(String.valueOf(argsSizeString.charAt(i))));
                }
            }

            last = String.valueOf(argsSizeString.charAt(i));
        }

        methodArgs.setNum(argsSize);
        methodArgs.setTypeDescriptor(sb.toString());

        return methodArgs;
    }

    public static String getType(String s) {
        if (DescriptorType.BOOLEAN.getValue().equals(s)) {
            return "boolean";
        } else if (DescriptorType.BYTE.getValue().equals(s)) {
            return "byte";
        } else if (DescriptorType.CHAR.getValue().equals(s)) {
            return "char";
        } else if (DescriptorType.DOUBLE.getValue().equals(s)) {
            return "double";
        } else if (DescriptorType.FLOAT.getValue().equals(s)) {
            return "float";
        } else if (DescriptorType.INT.getValue().equals(s)) {
            return "int";
        } else if (DescriptorType.LONG.getValue().equals(s)) {
            return "long";
        } else if (DescriptorType.SHORT.getValue().equals(s)) {
            return "short";
        } else {
            return s;
        }
    }
}
