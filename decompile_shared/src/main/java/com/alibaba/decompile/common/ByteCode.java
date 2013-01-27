package com.alibaba.decompile.common;

/**
 * <pre>
 * ��ByteCode.java��ʵ��������JAVA�ֽ����Ӧ�����ݽṹ
 * </pre>
 * 
 * @author yangbolin Dec 14, 2012 10:03:48 AM
 */
public class ByteCode {

    /** �ֽ���ı��� **/
    private int     code;
    /** �ֽ������Ƿ� **/
    private String  symbol;
    /** �ֽ����ע�� **/
    private String  comment;
    /** ��ǰ�ֽ���ĵ�ַ **/
    private int     baseOffset;
    /** ��������ռ���ֽ���Ŀ **/
    private int     operandBytes;
    /** �ֽ���ǰ���Ƿ���wide **/
    private boolean hasWide;
    /** �ֽ������� **/
    private int     type;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getBaseOffset() {
        return baseOffset;
    }

    public void setBaseOffset(int baseOffset) {
        this.baseOffset = baseOffset;
    }

    public int getOperandBytes() {
        return operandBytes;
    }

    public void setOperandBytes(int operandBytes) {
        this.operandBytes = operandBytes;
    }

    public boolean isHasWide() {
        return hasWide;
    }

    public void setHasWide(boolean hasWide) {
        this.hasWide = hasWide;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d:\t%s", this.baseOffset, this.symbol));
        return sb.toString();
    }
}
