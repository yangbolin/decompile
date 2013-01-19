package com.alibaba.decompile.common;

/**
 * 类Constants.java的实现描述：一些常量的定义
 * 
 * @author yangbolin Dec 7, 2012 10:51:08 AM
 */
public interface DecompileConstants {

    /** 魔数的字节长度 **/
    int    MAGIC_NUM_BYTES                            = 4;
    /** 每次读取class文件的字节数目 **/
    int    READ_CLASS_FILE_UNIT_BYTE                  = 100;
    /** Class文件的魔数字符串 **/
    String MAGIC_NUM                                  = "CAFEBABE";
    /** 魔数上下文 **/
    String MAGIC_CONTEXT                              = "magic_context";
    /** class文件中版本号需要的字节数 **/
    int    VERSION_NUM_BYTES                          = 2;
    /** 版本号的上下文 **/
    String VERSION_CONTEXT                            = "version_context";
    /** 常量池上下文 **/
    String CONSTANT_POOL_CONTEXT                      = "constant_pool_context";
    /** 访问权限上下文 **/
    String ACCESS_FLAGS_CONTEXT                       = "access_flag_context";
    /** 当前类以及超类全限定名的上下文 **/
    String CLASS_CONTEXT                              = "class_context";
    /** 接口上下文 **/
    String INTERFACES_CONTEXT                         = "interfaces_context";
    /** 字段上下文 **/
    String FIELDS_CONTEXT                             = "fields_context";
    /** 常量池中常量的数目所占的字节数目 **/
    int    CONSTANT_NUM_BYTES                         = 2;
    /** 十六进制 **/
    int    HEX_RADIX                                  = 16;
    /** 常量池中对应UTF8缩略码的字符串TAG **/
    int    CONSTANT_UTF8_STR_TAG                      = 1;
    /** 常量池中整型字面量的TAG **/
    int    CONSTANT_INTEGER_TAG                       = 3;
    /** 常量池中浮点型字面量的TAG **/
    int    CONSTANT_FLOAT_TAG                         = 4;
    /** 常量池中长整型字面量的TAG **/
    int    CONSTANT_LONG_TAG                          = 5;
    /** 常量池中双精度浮点型的字面常量TAG **/
    int    CONSTANT_DOUBLE_TAG                        = 6;
    /** 常量池中类或接口的符号引用TAG **/
    int    CONSTANT_CLASS_TAG                         = 7;
    /** 常量池中字符串类型字面量TAG **/
    int    CONSTANT_STRING_TAG                        = 8;
    /** 常量池中字段符号引用TAG **/
    int    CONSTANT_FIELD_REF_TAG                     = 9;
    /** 常量池中类方法的符号引用TAG **/
    int    CONSTANT_METHOD_REF_TAG                    = 10;
    /** 常量池中接口方法的符号引用TAG **/
    int    CONSTANT_INTERFACE_METHOD_REF_TAG          = 11;
    /** 常量池中字段和方法的部分符号引用TAG **/
    int    CONSTANT_NAME_ADN_TYPE_TAG                 = 12;
    /** 常量池中的0号索引 **/
    int    CONSTANT_ZERO_INDEX                        = 0;
    /** 常量池中UTF8类型的字符串常量的长度所占字节数目 **/
    int    CONSTANT_UTF8STRING_LENGTH_BYTES           = 2;
    /** 常量池中整型数字所占的字节数 **/
    int    CONSTANT_INTEGER_BYTES                     = 4;
    /** 常量池中浮点类型数字所占的字节数 **/
    int    CONSTANT_FLOAT_BYTES                       = 8;
    /** 常量池中Double类型的数字所占的字节数 **/
    int    CONSTANT_DOUBLE_BYTES                      = 8;
    /** 常量池中Long类型的数字所占的字节数 **/
    int    CONSTANT_LONG_BYTES                        = 4;
    /** 常量池中类或者接口对应的索引所占字节数 **/
    int    CONSTANT_CLASS_BYTES                       = 2;
    /** 常量池中String类型的引用对应的索引所占的字节数 **/
    int    CONSTANT_STRING_BYTES                      = 2;
    /** 常量池中字段所属类在常量池中对应索引所占字节数 **/
    int    CONSTANT_FIELD_CLASS_BYTES                 = 2;
    /** 常量池中字段描述符在常量池中对应的索引所占的字节数 **/
    int    CONSTANT_FIELD_DESCRIPTOR_BYTES            = 2;
    /** 常量池中方法所属的类在常量池中对应的索引所占的字节数 **/
    int    CONSTANT_METHOD_CLASS_BYTES                = 2;
    /** 常量池中方法的描述符在常量池中对应的索引所占的字节数 **/
    int    CONSTANT_METHOD_DESCRIPTOR_BYTES           = 2;
    /** 常量池中接口方法所属接口在常量池中的索引所占的字节数 **/
    int    CONSTANT_METHOD_INTERFACE_BYTES            = 2;
    /** 常量池中接口方法描述符在常量池中的索引所占的字节数 **/
    int    CONSTANT_INTERFACE_METHOD_DESCRIPTOR_BYTES = 2;
    /** 常量池中字段或者方法名称常量项的索引所占的字节数目 **/
    int    CONSTANT_NAME_AND_TYPE_NAME_BYTES          = 2;
    /** 常量池中字段或者方法描述符常量项索引所占的字节数目 **/
    int    CONSTANT_NAME_AND_TYPE_DESCRIPTOR_BYTES    = 2;
    /** 类访问权限标志在CLASS文件中所占的字节数目 **/
    int    ACCESS_FLAGS_BYTES                         = 2;
    /** 当前类全限定名在常量池中的描述符 **/
    int    THIS_CLASS_QUALIFIED_NAME_BYTES            = 2;
    /** 当前类的超类全限定名在常量池中的描述符 **/
    int    SUPER_CLASS_QUALIFIED_NAME_BYTES           = 2;
    /** 当前类实现的接口数目在CLASS文件所占的字节数目 **/
    int    INTERFACES_COUNT_BYTES                     = 2;
    /** 当前类实现的接口全限定名在常量池中的描述符所占的字节数 **/
    int    INTERFACE_QUALIFIED_NAME_BYTES             = 2;
    /** 字段的数目所占的字节数目 **/
    int    FIELDS_COUNT_BYTES                         = 2;
    /** 字段给访问标记所占的字节数目 **/
    int    FIELDS_ACCESS_FLAGS_BYTES                  = 2;
    /** 字段名索引所占的字节数目 **/
    int    FIELD_NAME_INDEX_COUNT                     = 2;
    /** 字段描述符所占的字节数目 **/
    int    FIELD_DESCRIPTOR_INDEX_BYTES               = 2;
    /** 字段的属性数目所占的字节数目 **/
    int    FIELD_ATTRIBUTES_COUNT_BYTES               = 2;
    /** 属性名称索引所占的字节数目 **/
    int    ATTRIBUTE_NAME_INDEX_BYTES                 = 2;
    /** 属性的长度所占的字节数目 **/
    int    ATTRIBUTE_LENGTH_BYTES                     = 4;
    /** 常量池中字面常量的索引所占的字节数目 **/
    int    CONSTANT_VALUE_INDEX_BYTES                 = 2;
    /** 类中方法数目在class文件中所占的字节数目 **/
    int    METHODS_COUNT_BYTES                        = 2;
    /** 类中方法的访问权限在class文件中所占的字节数目 **/
    int    METHOD_ACCESS_FLAGS_BYTES                  = 2;
    /** 类中方法名称索引所占的字节数目 **/
    int    METHOD_NAME_INDEX_BYTES                    = 2;
    /** 类中方法描述所占的字节数目 **/
    int    METHOD_DESCRIPTOR_BYTES                    = 2;
    /** 类中方法附件属性的数目所占的字节数 **/
    int    METHOD_ATTRIBUTE_COUNT_BYTES               = 2;
    /** 操作数所占的字节数目为1 **/
    int    OPERAND_ONE_BYTE                           = 1;
    /** 操作数所占的字节数目为2 **/
    int    OPERAND_TWO_BYTE                           = 2;
    /** 操作数所占的字节数目为4 **/
    int    OPERAND_FOUR_BYTE                          = 4;
    /** 方法的max_stack所占的字节数 **/
    int    METHOD_MAX_STACK_BYTE                      = 2;
    /** 方法的max_locals所占的字节数 **/
    int    METHOD_MAX_LOCALS_BYTE                     = 2;
    /** 方法的code_length所占的字节数 **/
    int    METHOD_CODE_LENGTH_BYTE                    = 4;
    /** 字节码编码所占的字节数目 **/
    int    BYTE_CODE_SYMBOL_CODE_BYTE                 = 1;
    /** 异常表相关的属性所占的字节数目 **/
    int    EXCEPTIONS_TABLE_BYTE                      = 2;
    /** code属性的附加属性数目所占的字节数组 **/
    int    CODE_INFO_ATTRIBUTE_LENGTH_BYTE            = 2;
    /** 方法的Exceptions属性的相关属性所占的字节数目 **/
    int    METHOD_EXCEPTIONS_ATTRIBUTE_BYTE           = 2;
    /** LineNumberTable属性相关的属性所占的字节数目 **/
    int    CODE_LINE_NUMBER_TABLE_BYTE                = 2;
    /** LocalVariableTable属性相关的属性所占的字节数目 **/
    int    CODE_LOCAL_VARIABLE_TABLE_BYTE             = 2;
}
