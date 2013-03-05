/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.attribute.info;

import java.util.ArrayList;
import java.util.List;
import com.alibaba.decompile.frame.SMTPFrame;

/**
 * @author yangbolin Jan 26, 2013 4:53:33 PM
 */
public class StackMapTableInfo extends AttributeInfo {

    /** frame的数目 **/
    private int             numberOfEntries;
    /** frame的列表 **/
    private List<SMTPFrame> frameList = new ArrayList<SMTPFrame>();

    public void addFrame(SMTPFrame frame) {
        this.frameList.add(frame);
    }

    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    public void setNumberOfEntries(int numberOfEntries) {
        this.numberOfEntries = numberOfEntries;
    }

    public List<SMTPFrame> getFrameList() {
        return frameList;
    }

    public void setFrameList(List<SMTPFrame> frameList) {
        this.frameList = frameList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("StackMapTableInfo: number_of_entries = %d\n", this.numberOfEntries));
        for (SMTPFrame frame : this.frameList) {
            sb.append(frame.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
