/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.common;

/**
 * <pre>
 * ��AttributeInfoNames.java��ʵ�����������Ա���һЩ�������Ƶ�ö��
 * </pre>
 * 
 * @author yangbolin Dec 13, 2012 1:37:37 PM
 */
public enum AttributeInfoName {
    /** ʹ���ڷ������У���ʾJAVA�������ɵ��ֽ���ָ�� **/
    CODE("Code"),
    /** ʹ�����ֶα��У���ʾfinal�ؼ��ֶ���ĳ��� **/
    CONSTANTVALUE("ConstantValue"),
    /** ʹ�����࣬�������ֶα��У���ʾ������Ϊdeprecated�ķ������ֶ� **/
    DEPRECATED("Deprecated"),
    /** ʹ���ڷ������У���ʾ�����׳����쳣 **/
    EXCEPTIONS("Exceptions"),
    /** ʹ�������ļ��У���ʾ�ڲ����б� **/
    INNERCLASS("InnerClass"),
    /** ʹ����Code�����У���ʾJAVAԴ������к����ֽ���ָ��Ķ�Ӧ��ϵ **/
    LINENUMBERTABLE("LineNumberTable"),
    /** ʹ����Code�����У���ʾ�����ľֲ��������� **/
    LOCALVARIABLETABLE("LocalVariableTable"),
    /** ʹ�������ļ��У���ʾԴ�ļ������� **/
    SOURCEFILE("SourceFile"),
    /** ʹ�����࣬�������ֶα��У���ʾ���������ֶ��Ǳ������Զ����ɵ� **/
    Synthetic("SYNTHETIC");

    /** ����ö�ٶ�Ӧ���������� **/
    private String name;

    AttributeInfoName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
