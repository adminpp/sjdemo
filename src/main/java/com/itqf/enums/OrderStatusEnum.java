package com.itqf.enums;

public enum OrderStatusEnum implements CodeEnum{

    NEW((byte)0,"新订单"),
    FINISHED((byte)1,"已结束"),
    CANCEL((byte)2,"已取消");

    private Byte code;
    private String message;

    OrderStatusEnum(Byte code,String message){
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
