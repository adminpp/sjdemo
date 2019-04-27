package com.itqf.dto;

/**
 * @Date: 2019/4/23 19:54
 */
public class CartDto {
    private String productId;
    private Integer productQuantity;


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

}
