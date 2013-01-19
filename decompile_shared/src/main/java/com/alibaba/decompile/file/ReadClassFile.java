/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import com.alibaba.decompile.common.DecompileConstants;

/**
 * ��ReadClassFile.java��ʵ����������ȡclass�ļ�����
 * 
 * @author yangbolin Dec 7, 2012 9:29:43 AM
 */
public class ReadClassFile {

    /** class�ļ�·�� **/
    private String           fileName;
    /** class�ļ����ֽ����� **/
    private byte[]           classByte;

    public ReadClassFile(String fileName){
        this.fileName = fileName;
        this.convertToBytes();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getClassByte() {
        return classByte;
    }

    public void setClassByte(byte[] classByte) {
        this.classByte = classByte;
    }

    /**
     * <pre>
     * ���¶�ȡ�����ֽ�����׷�ӵ�ԭ�����ֽ��������
     * </pre>
     * @param bytes
     */
    public void appendToClassBytes(byte[] bytes) {
        if (this.classByte == null) {
            this.classByte = new byte[bytes.length];
            System.arraycopy(bytes, 0, this.classByte, 0, bytes.length);
        } else {
            byte[] temp  = new byte[this.classByte.length + bytes.length];
            System.arraycopy(this.classByte, 0, temp, 0, this.classByte.length);
            System.arraycopy(bytes, 0, temp, this.classByte.length, bytes.length);
            this.classByte = temp;
        }
    }
    /**
     * <pre>
     * ��class�ļ�ת�����ֽ�����
     * </pre>
     */
    private void convertToBytes() {
        File classFile = new File(fileName);
        InputStream in = null;
        try {
            in = new FileInputStream(classFile);
            byte[] bytes = new byte[DecompileConstants.READ_CLASS_FILE_UNIT_BYTE];
            while ((in.read(bytes)) != -1) {
                this.appendToClassBytes(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
