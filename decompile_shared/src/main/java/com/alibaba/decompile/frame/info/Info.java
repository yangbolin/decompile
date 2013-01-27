/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.frame.info;

/**
 * @author yangbolin Jan 26, 2013 2:08:11 PM
 */
public enum Info {
    TOP(0),
    INT(1),
    FLOAT(2),
    LONG(3),
    DOUBLE(4),
    NULL(5),
    UNINITIALIZEDTHIS(6),
    OBJECT(7),
    UNINITIALIZED(8);
    
    int value;
    
    Info(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
}
