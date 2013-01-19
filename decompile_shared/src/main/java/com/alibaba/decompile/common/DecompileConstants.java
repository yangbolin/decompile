package com.alibaba.decompile.common;

/**
 * ��Constants.java��ʵ��������һЩ�����Ķ���
 * 
 * @author yangbolin Dec 7, 2012 10:51:08 AM
 */
public interface DecompileConstants {

    /** ħ�����ֽڳ��� **/
    int    MAGIC_NUM_BYTES                            = 4;
    /** ÿ�ζ�ȡclass�ļ����ֽ���Ŀ **/
    int    READ_CLASS_FILE_UNIT_BYTE                  = 100;
    /** Class�ļ���ħ���ַ��� **/
    String MAGIC_NUM                                  = "CAFEBABE";
    /** ħ�������� **/
    String MAGIC_CONTEXT                              = "magic_context";
    /** class�ļ��а汾����Ҫ���ֽ��� **/
    int    VERSION_NUM_BYTES                          = 2;
    /** �汾�ŵ������� **/
    String VERSION_CONTEXT                            = "version_context";
    /** ������������ **/
    String CONSTANT_POOL_CONTEXT                      = "constant_pool_context";
    /** ����Ȩ�������� **/
    String ACCESS_FLAGS_CONTEXT                       = "access_flag_context";
    /** ��ǰ���Լ�����ȫ�޶����������� **/
    String CLASS_CONTEXT                              = "class_context";
    /** �ӿ������� **/
    String INTERFACES_CONTEXT                         = "interfaces_context";
    /** �ֶ������� **/
    String FIELDS_CONTEXT                             = "fields_context";
    /** �������г�������Ŀ��ռ���ֽ���Ŀ **/
    int    CONSTANT_NUM_BYTES                         = 2;
    /** ʮ������ **/
    int    HEX_RADIX                                  = 16;
    /** �������ж�ӦUTF8��������ַ���TAG **/
    int    CONSTANT_UTF8_STR_TAG                      = 1;
    /** ��������������������TAG **/
    int    CONSTANT_INTEGER_TAG                       = 3;
    /** �������и�������������TAG **/
    int    CONSTANT_FLOAT_TAG                         = 4;
    /** �������г�������������TAG **/
    int    CONSTANT_LONG_TAG                          = 5;
    /** ��������˫���ȸ����͵����泣��TAG **/
    int    CONSTANT_DOUBLE_TAG                        = 6;
    /** �����������ӿڵķ�������TAG **/
    int    CONSTANT_CLASS_TAG                         = 7;
    /** ���������ַ�������������TAG **/
    int    CONSTANT_STRING_TAG                        = 8;
    /** ���������ֶη�������TAG **/
    int    CONSTANT_FIELD_REF_TAG                     = 9;
    /** ���������෽���ķ�������TAG **/
    int    CONSTANT_METHOD_REF_TAG                    = 10;
    /** �������нӿڷ����ķ�������TAG **/
    int    CONSTANT_INTERFACE_METHOD_REF_TAG          = 11;
    /** ���������ֶκͷ����Ĳ��ַ�������TAG **/
    int    CONSTANT_NAME_ADN_TYPE_TAG                 = 12;
    /** �������е�0������ **/
    int    CONSTANT_ZERO_INDEX                        = 0;
    /** ��������UTF8���͵��ַ��������ĳ�����ռ�ֽ���Ŀ **/
    int    CONSTANT_UTF8STRING_LENGTH_BYTES           = 2;
    /** ������������������ռ���ֽ��� **/
    int    CONSTANT_INTEGER_BYTES                     = 4;
    /** �������и�������������ռ���ֽ��� **/
    int    CONSTANT_FLOAT_BYTES                       = 8;
    /** ��������Double���͵�������ռ���ֽ��� **/
    int    CONSTANT_DOUBLE_BYTES                      = 8;
    /** ��������Long���͵�������ռ���ֽ��� **/
    int    CONSTANT_LONG_BYTES                        = 4;
    /** ������������߽ӿڶ�Ӧ��������ռ�ֽ��� **/
    int    CONSTANT_CLASS_BYTES                       = 2;
    /** ��������String���͵����ö�Ӧ��������ռ���ֽ��� **/
    int    CONSTANT_STRING_BYTES                      = 2;
    /** ���������ֶ��������ڳ������ж�Ӧ������ռ�ֽ��� **/
    int    CONSTANT_FIELD_CLASS_BYTES                 = 2;
    /** ���������ֶ��������ڳ������ж�Ӧ��������ռ���ֽ��� **/
    int    CONSTANT_FIELD_DESCRIPTOR_BYTES            = 2;
    /** �������з������������ڳ������ж�Ӧ��������ռ���ֽ��� **/
    int    CONSTANT_METHOD_CLASS_BYTES                = 2;
    /** �������з������������ڳ������ж�Ӧ��������ռ���ֽ��� **/
    int    CONSTANT_METHOD_DESCRIPTOR_BYTES           = 2;
    /** �������нӿڷ��������ӿ��ڳ������е�������ռ���ֽ��� **/
    int    CONSTANT_METHOD_INTERFACE_BYTES            = 2;
    /** �������нӿڷ����������ڳ������е�������ռ���ֽ��� **/
    int    CONSTANT_INTERFACE_METHOD_DESCRIPTOR_BYTES = 2;
    /** ���������ֶλ��߷������Ƴ������������ռ���ֽ���Ŀ **/
    int    CONSTANT_NAME_AND_TYPE_NAME_BYTES          = 2;
    /** ���������ֶλ��߷���������������������ռ���ֽ���Ŀ **/
    int    CONSTANT_NAME_AND_TYPE_DESCRIPTOR_BYTES    = 2;
    /** �����Ȩ�ޱ�־��CLASS�ļ�����ռ���ֽ���Ŀ **/
    int    ACCESS_FLAGS_BYTES                         = 2;
    /** ��ǰ��ȫ�޶����ڳ������е������� **/
    int    THIS_CLASS_QUALIFIED_NAME_BYTES            = 2;
    /** ��ǰ��ĳ���ȫ�޶����ڳ������е������� **/
    int    SUPER_CLASS_QUALIFIED_NAME_BYTES           = 2;
    /** ��ǰ��ʵ�ֵĽӿ���Ŀ��CLASS�ļ���ռ���ֽ���Ŀ **/
    int    INTERFACES_COUNT_BYTES                     = 2;
    /** ��ǰ��ʵ�ֵĽӿ�ȫ�޶����ڳ������е���������ռ���ֽ��� **/
    int    INTERFACE_QUALIFIED_NAME_BYTES             = 2;
    /** �ֶε���Ŀ��ռ���ֽ���Ŀ **/
    int    FIELDS_COUNT_BYTES                         = 2;
    /** �ֶθ����ʱ����ռ���ֽ���Ŀ **/
    int    FIELDS_ACCESS_FLAGS_BYTES                  = 2;
    /** �ֶ���������ռ���ֽ���Ŀ **/
    int    FIELD_NAME_INDEX_COUNT                     = 2;
    /** �ֶ���������ռ���ֽ���Ŀ **/
    int    FIELD_DESCRIPTOR_INDEX_BYTES               = 2;
    /** �ֶε�������Ŀ��ռ���ֽ���Ŀ **/
    int    FIELD_ATTRIBUTES_COUNT_BYTES               = 2;
    /** ��������������ռ���ֽ���Ŀ **/
    int    ATTRIBUTE_NAME_INDEX_BYTES                 = 2;
    /** ���Եĳ�����ռ���ֽ���Ŀ **/
    int    ATTRIBUTE_LENGTH_BYTES                     = 4;
    /** �����������泣����������ռ���ֽ���Ŀ **/
    int    CONSTANT_VALUE_INDEX_BYTES                 = 2;
    /** ���з�����Ŀ��class�ļ�����ռ���ֽ���Ŀ **/
    int    METHODS_COUNT_BYTES                        = 2;
    /** ���з����ķ���Ȩ����class�ļ�����ռ���ֽ���Ŀ **/
    int    METHOD_ACCESS_FLAGS_BYTES                  = 2;
    /** ���з�������������ռ���ֽ���Ŀ **/
    int    METHOD_NAME_INDEX_BYTES                    = 2;
    /** ���з���������ռ���ֽ���Ŀ **/
    int    METHOD_DESCRIPTOR_BYTES                    = 2;
    /** ���з����������Ե���Ŀ��ռ���ֽ��� **/
    int    METHOD_ATTRIBUTE_COUNT_BYTES               = 2;
    /** ��������ռ���ֽ���ĿΪ1 **/
    int    OPERAND_ONE_BYTE                           = 1;
    /** ��������ռ���ֽ���ĿΪ2 **/
    int    OPERAND_TWO_BYTE                           = 2;
    /** ��������ռ���ֽ���ĿΪ4 **/
    int    OPERAND_FOUR_BYTE                          = 4;
    /** ������max_stack��ռ���ֽ��� **/
    int    METHOD_MAX_STACK_BYTE                      = 2;
    /** ������max_locals��ռ���ֽ��� **/
    int    METHOD_MAX_LOCALS_BYTE                     = 2;
    /** ������code_length��ռ���ֽ��� **/
    int    METHOD_CODE_LENGTH_BYTE                    = 4;
    /** �ֽ��������ռ���ֽ���Ŀ **/
    int    BYTE_CODE_SYMBOL_CODE_BYTE                 = 1;
    /** �쳣����ص�������ռ���ֽ���Ŀ **/
    int    EXCEPTIONS_TABLE_BYTE                      = 2;
    /** code���Եĸ���������Ŀ��ռ���ֽ����� **/
    int    CODE_INFO_ATTRIBUTE_LENGTH_BYTE            = 2;
    /** ������Exceptions���Ե����������ռ���ֽ���Ŀ **/
    int    METHOD_EXCEPTIONS_ATTRIBUTE_BYTE           = 2;
    /** LineNumberTable������ص�������ռ���ֽ���Ŀ **/
    int    CODE_LINE_NUMBER_TABLE_BYTE                = 2;
    /** LocalVariableTable������ص�������ռ���ֽ���Ŀ **/
    int    CODE_LOCAL_VARIABLE_TABLE_BYTE             = 2;
}
