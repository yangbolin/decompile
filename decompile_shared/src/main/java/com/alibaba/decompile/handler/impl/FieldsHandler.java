/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.decompile.handler.impl;

import java.util.List;
import java.util.Set;
import com.alibaba.decompile.attribute.info.AttributeInfo;
import com.alibaba.decompile.attribute.info.ConstantValueInfo;
import com.alibaba.decompile.attribute.info.DeprecatedInfo;
import com.alibaba.decompile.attribute.info.SyntheticInfo;
import com.alibaba.decompile.common.ByteUtils;
import com.alibaba.decompile.common.DecompileConstants;
import com.alibaba.decompile.common.FieldAccessFlag;
import com.alibaba.decompile.context.ByteCodeContext;
import com.alibaba.decompile.context.impl.ConstantPoolContext;
import com.alibaba.decompile.context.impl.FieldsContext;
import com.alibaba.decompile.factory.DecompileFactory;
import com.alibaba.decompile.field.Field;
import com.alibaba.decompile.field.attribute.ParseFieldArributeFactory;
import com.alibaba.decompile.handler.DecompileHandler;

/**
 * <pre>
 * ��FieldsHandler.java��ʵ������������JAVA�ֽ����е��ֶ�
 * </pre>
 * 
 * @author yangbolin Dec 16, 2012 3:14:18 PM
 */
public class FieldsHandler extends DecompileHandler {
    
    /** �ֶ������� **/
    private FieldsContext fieldsContext;
    
    @Override
    public void parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        System.out.println("***PARSE FIELD IN CURRENT CLASSS***");
        
        // 0.��ȡ�ֶε���Ŀ
        byte[] fieldCountBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.FIELDS_COUNT_BYTES);
        
        this.fieldsContext = new FieldsContext();
        
        // 1.���ֶε���Ŀ���õ��ֶ���������
        int fieldCount = Integer.valueOf(ByteUtils.bytesToHex(fieldCountBytes), DecompileConstants.HEX_RADIX);
        this.fieldsContext.setFieldCount(fieldCount);
        
        // 2.���δ��ֽ����ļ��ж�ȡÿһ���ֶ�
        for (int i = 0; i < fieldCount; ++i) {
            Field field = this.parseFiled(byteCodeContext, decompileFactory);
            this.fieldsContext.addField(field);
        }
        
        // 3.���ֶ������ķŵ������빤����
        decompileFactory.addDecompileContext(DecompileConstants.FIELDS_CONTEXT, this.fieldsContext);
        
        // 4.���ֶε������Ϣ�ڿ���̨��ӡ����
        this.printAllField();
        
        // 5.������һ��������
        this.getNextHandler().parse(byteCodeContext, decompileFactory);
    }
    
    /**
     * <pre>
     * ����ÿһ���ֶ�
     * </pre>
     * 
     * @param byteCodeContext
     */
    private Field parseFiled(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        Field field = new Field();
        
        // 0.�ֶη��ʱ�ǵĴ�����ʵ�����ֶεķ���Ȩ��
        byte[] fieldAccessFlagsBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.ACCESS_FLAGS_BYTES);
        
        int fieldAccessFlags = Integer.valueOf(ByteUtils.bytesToHex(fieldAccessFlagsBytes), DecompileConstants.HEX_RADIX);
        for (FieldAccessFlag accessFlag : FieldAccessFlag.values()) {
            if ((fieldAccessFlags & accessFlag.getFlagValue()) != 0) {
                field.addAccessFlag(accessFlag);
            }
        }
        
        ConstantPoolContext constantPoolContext = (ConstantPoolContext)decompileFactory.getDecompileContext(DecompileConstants.CONSTANT_POOL_CONTEXT);
        
        // 1.�ֶ�������������
        byte[] nameIndexBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.FIELD_NAME_INDEX_COUNT);
        field.setNameIndex(Integer.valueOf(ByteUtils.bytesToHex(nameIndexBytes), DecompileConstants.HEX_RADIX));
        field.setFieldName(constantPoolContext.getUTF8tringByIndex(field.getNameIndex()));
        
        // 2.�ֶ��������Ĵ���
        byte[] descriptorIndexBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.FIELD_DESCRIPTOR_INDEX_BYTES);
        field.setDescriptorIndex(Integer.valueOf(ByteUtils.bytesToHex(descriptorIndexBytes), DecompileConstants.HEX_RADIX));
        field.setDescriptorName(constantPoolContext.getUTF8tringByIndex(field.getDescriptorIndex()));
        
        // 3.�ֶε����Ա�����������ֶε����Ա��п��ܴ洢��һЩ�ֶε��������ԣ������������ֶ���final���͵ģ�final��־�ͻ�������ֶε����Ա���
        byte[] attributesCountBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.FIELD_ATTRIBUTES_COUNT_BYTES);
        
        // 4.���ֽ���ת���ɱ�ʾ������Ŀ����������
        int attributeCount = Integer.valueOf(ByteUtils.bytesToHex(attributesCountBytes), DecompileConstants.HEX_RADIX);
        field.setAttributeCount(attributeCount);
        
        // 5.�����ֶε�����
        for (int i = 0; i < attributeCount; ++i) {
            // 5.1�����������Ƶ�index�ڳ��������ҵ���������
            byte[] attributeNameIndexBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.ATTRIBUTE_NAME_INDEX_BYTES);
            int attributeNameIndex = Integer.valueOf(ByteUtils.bytesToHex(attributeNameIndexBytes), DecompileConstants.HEX_RADIX);
            
            String attributeName = constantPoolContext.getUTF8tringByIndex(attributeNameIndex);
            
            // 5.2�����������Ƶ��ò�ͬ�Ľ������������ֶε�����
            AttributeInfo attributeInfo = ParseFieldArributeFactory.getSpecParser(attributeName).parse(byteCodeContext, decompileFactory);
            attributeInfo.setAttributeNameIndex(attributeNameIndex);
            attributeInfo.setAttributeName(attributeName);
            field.addAttribute(attributeInfo);
        }
        return field;
    }
    
    private void printAllField() {
        
        int fieldCount = this.fieldsContext.getFieldCount();
        List<Field> fieldList = this.fieldsContext.getFieldList();
        
        for (int i = 0; i < fieldCount; ++i) {
            Field field = fieldList.get(i);
            // �ֶα��
            System.out.println(String.format("#%d field:", i));
            System.out.println(String.format("\tThe fieldName is: %s\t#%d, The descriptorName is: %s\t#%d", 
                                             field.getFieldName(), field.getNameIndex(), 
                                             field.getDescriptorName(), field.getDescriptorIndex()));
            
            // �ֶεķ���Ȩ��
            Set<FieldAccessFlag> accessFlagsSet = field.getAccessFlagsSet();
            System.out.print("\tThe accesss flag is: ");
            for (FieldAccessFlag accessFlag : accessFlagsSet) {
                System.out.println(accessFlag.name());
            }
            
            // �ֶε�������Ŀ
            int attributeCount = field.getAttributeCount();
            if (attributeCount == 0) {
                continue;
            }
            
            Set<AttributeInfo> attributeSet = field.getAttributeSet();
            
            // ����ֶε�ÿ������
            for (AttributeInfo attributeInfo : attributeSet) {
                // �ֶ��Ƿ�����Ϊfinal����
                if (attributeInfo instanceof ConstantValueInfo) {
                    System.out.println(String.format("\t%s\t%s\t#%d", attributeInfo.getAttributeName(),
                                                     ((ConstantValueInfo)attributeInfo).getConstantValueString(),
                                                     ((ConstantValueInfo)attributeInfo).getConstantValueIndex()));
                }
                
                // �ֶ��Ƿ�����Ϊdeprecated
                if (attributeInfo instanceof DeprecatedInfo) {
                    System.out.println("\tDeprecated");
                }
                
                // �ֶ��Ƿ��Ǳ������Զ����ɵ�
                if (attributeInfo instanceof SyntheticInfo) {
                    System.out.println("\tSynthetic");
                }
            }
        }
    }
}
