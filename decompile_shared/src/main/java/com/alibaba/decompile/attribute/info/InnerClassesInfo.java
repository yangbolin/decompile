/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.attribute.info;

import java.util.ArrayList;
import java.util.List;
import com.alibaba.decompile.attribute.InnerClass;

/**
 * <pre>
 * 类InnerClass.java的实现描述：使用在类文件中，表示内部类的列表
 * </pre>
 * 
 * @author yangbolin Dec 13, 2012 2:29:01 PM
 */
public class InnerClassesInfo extends AttributeInfo {

    /** 内部类的数目 **/
    private int              numberOfClasses;
    /** 内部类列表 **/
    private List<InnerClass> classList = new ArrayList<InnerClass>();

    public void addInnerClass(InnerClass innerClass) {
        this.classList.add(innerClass);
    }

    public int getNumberOfClasses() {
        return numberOfClasses;
    }

    public void setNumberOfClasses(int numberOfClasses) {
        this.numberOfClasses = numberOfClasses;
    }

    public List<InnerClass> getClassList() {
        return classList;
    }

    public void setClassList(List<InnerClass> classList) {
        this.classList = classList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("InnerClasses: number_of_inner_classes = %d\n", this.numberOfClasses));
        for (InnerClass innerClass : this.classList) {
            sb.append(innerClass.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
