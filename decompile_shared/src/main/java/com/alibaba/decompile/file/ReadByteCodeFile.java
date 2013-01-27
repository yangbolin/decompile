/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.file;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.alibaba.decompile.common.ByteCode;
import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.common.utils.DecompileUtils;

/**
 * 类ReadByteCodeFile.java的实现描述：读取字节码的XML文件
 * 
 * @author yangbolin Dec 14, 2012 10:22:11 AM
 */
public class ReadByteCodeFile {

    /** 文件名称 **/
    private String              fileName;
    /** 字节码在XML文档中的标记 **/
    private static final String BYTE_CODE = "bytecode";
    /** 字节码的编码 **/
    private static final String CODE        = "code";
    /** 字节码的助记符 **/
    private static final String SYMBOL      = "symbol";
    /** 字节码的注释 **/
    private static final String COMMENT     = "comment";
    /** 字节码的操作数 **/
    private static final String OPERAND     = "operand";

    public ReadByteCodeFile(String fileName){
        this.fileName = fileName;
    }

    /**
     * <pre>
     * 解析字节码的XML文件，返回一个按照code排过序的字节码列表
     * </pre>
     * 
     * @return
     */
    public List<ByteCode> parse() throws Exception {

        List<ByteCode> byteCodeList = new ArrayList<ByteCode>();

        InputStream inputStream = this.getClass().getResourceAsStream(this.fileName);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();  

        Document document = builder.parse(inputStream);  
        Element element = document.getDocumentElement();

        NodeList byteCodes = element.getElementsByTagName(BYTE_CODE);

        for (int i = 0; i < byteCodes.getLength(); ++i) {
            Element byteCodeElement = (Element)byteCodes.item(i);
            ByteCode byteCode = new ByteCode();

            NodeList childNodes = byteCodeElement.getChildNodes(); 

            for(int j = 0; j < childNodes.getLength(); ++j) {
                if (childNodes.item(j).getNodeType()==Node.ELEMENT_NODE) {
                    // 读取code属性
                    if (CODE.equals(childNodes.item(j).getNodeName())) {
                        String code = childNodes.item(j).getFirstChild().getNodeValue();
                        code = DecompileUtils.deleteHexPrefix(code);
                        byteCode.setCode(Integer.valueOf(code, DecompileConstants.HEX_RADIX));
                    // 读取symbol属性
                    } else if (SYMBOL.equals(childNodes.item(j).getNodeName())) {
                        byteCode.setSymbol(childNodes.item(j).getFirstChild().getNodeValue());
                    // 读取comment属性
                    } else if (COMMENT.equals(childNodes.item(j).getNodeName())) {
                        byteCode.setComment(childNodes.item(j).getFirstChild().getNodeValue());
                    // 读取operand属性
                    } else if (OPERAND.equals(childNodes.item(j).getNodeName())) {
                        byteCode.setType(Integer.valueOf(childNodes.item(j).getFirstChild().getNodeValue()));
                    }
                }
            }

            byteCodeList.add(byteCode);
        }

        return byteCodeList;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
