/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.frame;

/**
 * <pre>
 * 类StackMapTableFrameType.java的实现描述：StackMapTable中每一项的类型的枚举
 * 
 * 注:
 * http://www.blogjava.net/DLevin/archive/2011/09/05/358034.html
 * </pre>
 * 
 * @author yangbolin Jan 25, 2013 7:00:49 PM
 */
public enum StackMapTableFrameType {
    /** 0-63 **/
    SAME_FRAME("same_frame"), 
    /** 64-127 **/
    SAME_LOCALS_1_STACK_ITEM_FRAME("same_locals_1_stack_item_frame"),
    /** 247 **/
    SAME_LOCALS_1_STACK_ITEM_FRAME_EXTENDED("same_locals_1_stack_item_frame_extended"), 
    /** 248-250 **/
    CHOP_FRAME("chop_frame"),
    /** 251 **/
    SAME_FRAME_EXTENDED("same_frame_extended"), 
    /** 252-254 **/
    APPEND_FRAME("append_frame"), 
    /** 255 **/
    FULL_FRAME("full_frame");

    String value;

    StackMapTableFrameType(String value){
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
}
