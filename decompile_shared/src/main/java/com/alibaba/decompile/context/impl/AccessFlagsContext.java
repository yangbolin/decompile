/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.context.impl;

import java.util.HashSet;
import java.util.Set;
import com.alibaba.decompile.common.ClassAccessFlag;
import com.alibaba.decompile.context.DecompileContext;

/**
 * 类AccessFlagsContext.java的实现描述：访问权限上下文
 * 
 * @author yangbolin Dec 11, 2012 9:47:59 AM
 */
public class AccessFlagsContext extends DecompileContext {
    /** 类访问标志的集合 **/
    private Set<ClassAccessFlag> accessFlagsSet = new HashSet<ClassAccessFlag>();
    
    /** 类访问标志构成的整型值，这个整型数对应的二进制的每一位表示一个访问标志是否存在**/
    private int accessFlagsValue;
    
    public Set<ClassAccessFlag> getAccessFlagsSet() {
        return accessFlagsSet;
    }
    
    public void setAccessFlagsSet(Set<ClassAccessFlag> accessFlagsSet) {
        this.accessFlagsSet = accessFlagsSet;
    }
    
    public int getAccessFlagsValue() {
        return accessFlagsValue;
    }
    
    public void setAccessFlagsValue(int accessFlagsValue) {
        this.accessFlagsValue = accessFlagsValue;
    }

    /**
     * <pre>
     * 增加一个访问标志
     * </pre>
     * @param flag
     */
    public void addAccessFlags(ClassAccessFlag flag) {
        this.accessFlagsSet.add(flag);
    }
}
