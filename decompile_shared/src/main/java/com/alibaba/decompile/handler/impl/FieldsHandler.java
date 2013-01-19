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
 * 类FieldsHandler.java的实现描述：处理JAVA字节码中的字段
 * </pre>
 * 
 * @author yangbolin Dec 16, 2012 3:14:18 PM
 */
public class FieldsHandler extends DecompileHandler {
    
    /** 字段上下文 **/
    private FieldsContext fieldsContext;
    
    @Override
    public void parse(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        System.out.println("***PARSE FIELD IN CURRENT CLASSS***");
        
        // 0.读取字段的数目
        byte[] fieldCountBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.FIELDS_COUNT_BYTES);
        
        this.fieldsContext = new FieldsContext();
        
        // 1.把字段的数目设置到字段上下文中
        int fieldCount = Integer.valueOf(ByteUtils.bytesToHex(fieldCountBytes), DecompileConstants.HEX_RADIX);
        this.fieldsContext.setFieldCount(fieldCount);
        
        // 2.依次从字节码文件中读取每一个字段
        for (int i = 0; i < fieldCount; ++i) {
            Field field = this.parseFiled(byteCodeContext, decompileFactory);
            this.fieldsContext.addField(field);
        }
        
        // 3.把字段上下文放到反编译工厂中
        decompileFactory.addDecompileContext(DecompileConstants.FIELDS_CONTEXT, this.fieldsContext);
        
        // 4.把字段的相关信息在控制台打印出来
        this.printAllField();
        
        // 5.调用下一个处理句柄
        this.getNextHandler().parse(byteCodeContext, decompileFactory);
    }
    
    /**
     * <pre>
     * 解析每一个字段
     * </pre>
     * 
     * @param byteCodeContext
     */
    private Field parseFiled(ByteCodeContext byteCodeContext, DecompileFactory decompileFactory) {
        Field field = new Field();
        
        // 0.字段访问标记的处理，其实就是字段的访问权限
        byte[] fieldAccessFlagsBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.ACCESS_FLAGS_BYTES);
        
        int fieldAccessFlags = Integer.valueOf(ByteUtils.bytesToHex(fieldAccessFlagsBytes), DecompileConstants.HEX_RADIX);
        for (FieldAccessFlag accessFlag : FieldAccessFlag.values()) {
            if ((fieldAccessFlags & accessFlag.getFlagValue()) != 0) {
                field.addAccessFlag(accessFlag);
            }
        }
        
        ConstantPoolContext constantPoolContext = (ConstantPoolContext)decompileFactory.getDecompileContext(DecompileConstants.CONSTANT_POOL_CONTEXT);
        
        // 1.字段名称索引处理
        byte[] nameIndexBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.FIELD_NAME_INDEX_COUNT);
        field.setNameIndex(Integer.valueOf(ByteUtils.bytesToHex(nameIndexBytes), DecompileConstants.HEX_RADIX));
        field.setFieldName(constantPoolContext.getUTF8tringByIndex(field.getNameIndex()));
        
        // 2.字段描述符的处理
        byte[] descriptorIndexBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.FIELD_DESCRIPTOR_INDEX_BYTES);
        field.setDescriptorIndex(Integer.valueOf(ByteUtils.bytesToHex(descriptorIndexBytes), DecompileConstants.HEX_RADIX));
        field.setDescriptorName(constantPoolContext.getUTF8tringByIndex(field.getDescriptorIndex()));
        
        // 3.字段的属性表解析，关于字段的属性表中可能存储了一些字段的其他属性，比如如果这个字段是final类型的，final标志就会出现在字段的属性表中
        byte[] attributesCountBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.FIELD_ATTRIBUTES_COUNT_BYTES);
        
        // 4.把字节码转换成表示属性数目的整型数字
        int attributeCount = Integer.valueOf(ByteUtils.bytesToHex(attributesCountBytes), DecompileConstants.HEX_RADIX);
        field.setAttributeCount(attributeCount);
        
        // 5.解析字段的属性
        for (int i = 0; i < attributeCount; ++i) {
            // 5.1根据属性名称的index在常量池中找到属性名称
            byte[] attributeNameIndexBytes = byteCodeContext.getSpecifiedByteCodeArray(DecompileConstants.ATTRIBUTE_NAME_INDEX_BYTES);
            int attributeNameIndex = Integer.valueOf(ByteUtils.bytesToHex(attributeNameIndexBytes), DecompileConstants.HEX_RADIX);
            
            String attributeName = constantPoolContext.getUTF8tringByIndex(attributeNameIndex);
            
            // 5.2根据属性名称调用不同的解析器来解析字段的属性
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
            // 字段编号
            System.out.println(String.format("#%d field:", i));
            System.out.println(String.format("\tThe fieldName is: %s\t#%d, The descriptorName is: %s\t#%d", 
                                             field.getFieldName(), field.getNameIndex(), 
                                             field.getDescriptorName(), field.getDescriptorIndex()));
            
            // 字段的访问权限
            Set<FieldAccessFlag> accessFlagsSet = field.getAccessFlagsSet();
            System.out.print("\tThe accesss flag is: ");
            for (FieldAccessFlag accessFlag : accessFlagsSet) {
                System.out.println(accessFlag.name());
            }
            
            // 字段的属性数目
            int attributeCount = field.getAttributeCount();
            if (attributeCount == 0) {
                continue;
            }
            
            Set<AttributeInfo> attributeSet = field.getAttributeSet();
            
            // 输出字段的每个属性
            for (AttributeInfo attributeInfo : attributeSet) {
                // 字段是否被设置为final类型
                if (attributeInfo instanceof ConstantValueInfo) {
                    System.out.println(String.format("\t%s\t%s\t#%d", attributeInfo.getAttributeName(),
                                                     ((ConstantValueInfo)attributeInfo).getConstantValueString(),
                                                     ((ConstantValueInfo)attributeInfo).getConstantValueIndex()));
                }
                
                // 字段是否被设置为deprecated
                if (attributeInfo instanceof DeprecatedInfo) {
                    System.out.println("\tDeprecated");
                }
                
                // 字段是否是编译器自动生成的
                if (attributeInfo instanceof SyntheticInfo) {
                    System.out.println("\tSynthetic");
                }
            }
        }
    }
}
