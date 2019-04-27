package com.itqf.enums;

public enum ResultEnum {

    PRODUCT_NOT_EXISTS(6,"商品不存在"),
    PRODUCT_STOCK_ERROR(7,"商品库存不足"),
    PARAM_ERROR(8,"参数不正确"),
    CART_ERROR(9,"购物车为空"),
    OPENID_NULL(10,"微信号为空"),
    ORDER_NOT_EXISTS(11,"订单不存在"),
    ORDER_DETAIL_NOT_EXISTS(12,"订单详情不存在"),
    ORDER_OWNER_ERROR(13,"不是订单所有者"),
    ORDER_STATUS_ERROR(14,"订单状态不对"),
    ORDER_UPDATE_ERROR(15,"订单修改失败"),
    ORDER_PAY_STATUS_ERROR(16,"订单支付状态错误"),
    ORDER_PAY_UPDATE_ERROR(17,"订单支付状态修改错误"),
    PAY_ERROR(18,"支付错误"),
    PRODUCT_STATUS_ERROR(19,"商品状态错误");


    private Integer code;
    private String message;

    ResultEnum(Integer code,String message){
        this.code=code;
        this.message=message;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
