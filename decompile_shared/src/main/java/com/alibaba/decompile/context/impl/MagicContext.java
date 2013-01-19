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
 * ��MagicVersionContext.java��ʵ��������class�ļ�ħ��������
 * 
 * @author yangbolin Dec 7, 2012 10:39:52 AM
 */
public class MagicContext extends DecompileContext {
    /** ħ�� **/
    private String magicNum;

    public String getMagicNum() {
        return magicNum;
    }

    public void setMagicNum(String magicNum) {
        this.magicNum = magicNum;
    }
}
