package com.itqf.enums;

public enum ProductStatusEnum implements CodeEnum{

     UP((byte)0,"在架"),
    DOWN((byte)1,"下架");

     private Byte code;
     private String message;

    ProductStatusEnum(Byte code,String message){
        this.code=code;
        this.message=message;
    }

    public Byte getCode() {
        return code;
    }

    public void setCode(Byte code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
