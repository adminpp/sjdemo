package com.itqf.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.itqf.entity.OrderDetail;
import com.itqf.entity.OrderMaster;
import com.itqf.enums.OrderStatusEnum;
import com.itqf.enums.PayStatus;
import com.itqf.utils.DateToLong;
import com.itqf.utils.EnumUtil;

import java.util.Date;
import java.util.List;

public class OrderDTO extends OrderMaster {

    //一个订单对应多个订单详情
    private List<OrderDetail> orderDetailList;
    private Byte orderStatus;//订单状态
    private String buyerAddress;

    private Byte payStatus;
    @JsonSerialize(using= DateToLong.class)
    private Date createTime;

    @JsonSerialize(using = DateToLong.class)
    private Date updateTime; //把时间转成秒值

    @JsonIgnore  //不被转成json
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);

    }
    @JsonIgnore
    public PayStatus getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatus.class);

    }

    @Override
    public Byte getOrderStatus() {
        return orderStatus;
    }

    @Override
    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    @Override
    public Byte getPayStatus() {
        return payStatus;
    }

    @Override
    public void setPayStatus(Byte payStatus) {
        this.payStatus = payStatus;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
