package com.itqf.enums;

public enum PayStatus implements CodeEnum{

    WAIT((byte)0,"未支付"),
    SUCCESS((byte)1,"已支付");

    private Byte code;
    private String message;

    PayStatus(Byte code,String message){
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
