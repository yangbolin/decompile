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
 * 类AttributeInfoNames.java的实现描述：属性表中一些属性名称的枚举
 * </pre>
 * 
 * @author yangbolin Dec 13, 2012 1:37:37 PM
 */
public enum AttributeInfoName {
    /** 使用在方法表中，表示JAVA代码编译成的字节码指令 **/
    CODE("Code"),
    /** 使用在字段表中，表示final关键字定义的常量 **/
    CONSTANTVALUE("ConstantValue"),
    /** 使用在类，方法表，字段表中，表示被声明为deprecated的方法和字段 **/
    DEPRECATED("Deprecated"),
    /** 使用在方法表中，表示方法抛出的异常 **/
    EXCEPTIONS("Exceptions"),
    /** 使用在类文件中，表示内部类列表 **/
    INNERCLASS("InnerClass"),
    /** 使用在Code属性中，表示JAVA源代码的行号与字节码指令的对应关系 **/
    LINENUMBERTABLE("LineNumberTable"),
    /** 使用在Code属性中，表示方法的局部变量描述 **/
    LOCALVARIABLETABLE("LocalVariableTable"),
    /** 使用在类文件中，表示源文件的名称 **/
    SOURCEFILE("SourceFile"),
    /** 使用在类，方法表，字段表中，表示方法或者字段是编译器自动生成的 **/
    Synthetic("SYNTHETIC");

    /** 属性枚举对应的属性名称 **/
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
