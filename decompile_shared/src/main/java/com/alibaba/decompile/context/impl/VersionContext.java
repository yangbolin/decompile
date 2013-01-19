/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.context.impl;

import com.alibaba.decompile.context.DecompileContext;

/**
 * ��VersionContext.java��ʵ���������汾�ŵĽ��� 
 * 
 * @author yangbolin Dec 10, 2012 10:03:47 AM
 */
public class VersionContext extends DecompileContext {
    private int minorVersion;       /** �ΰ汾�� **/
    private int majorVersion;       /** ���汾�� **/
    
    public int getMinorVersion() {
        return minorVersion;
    }
    
    public void setMinorVersion(int minorVersion) {
        this.minorVersion = minorVersion;
    }
    
    public int getMajorVersion() {
        return majorVersion;
    }
    
    public void setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion;
    }
}
