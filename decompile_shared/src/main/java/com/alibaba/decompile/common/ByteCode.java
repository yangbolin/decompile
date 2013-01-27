package com.alibaba.decompile.common;

/**
 * <pre>
 * 类ByteCode.java的实现描述：JAVA字节码对应的数据结构
 * </pre>
 * 
 * @author yangbolin Dec 14, 2012 10:03:48 AM
 */
public class ByteCode {

    /** 字节码的编码 **/
    private int     code;
    /** 字节码助记符 **/
    private String  symbol;
    /** 字节码的注释 **/
    private String  comment;
    /** 当前字节码的地址 **/
    private int     baseOffset;
    /** 操作数所占的字节数目 **/
    private int     operandBytes;
    /** 字节码前面是否有wide **/
    private boolean hasWide;
    /** 字节码类型 **/
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
