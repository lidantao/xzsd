package com.xzsd.pc.order.entity;

import java.util.List;

public class OrderDTO {

    //订单编号列表
    private List<String> orderCodeList;

    //订单状态编号.取消订单1，订单到货2，取消到货0，订单已取货3，取消已取货2）
    private String orderActive;

    //修改者
    private String lastUpdateUser;

    //订单id
    private String orderId;

    //订单编码
    private String orderCode;

    //用户编号
    private String userCode;

    //总金额
    private String sumPrice;

    //售价
    private String goodsPrice;

    //定价
    private String goodsCostPrice;

    //商品编码
    private String goodsCode;

    //商品名称
    private String goodsName;

    //购买数量
    private String pucharNum;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(String sumPrice) {
        this.sumPrice = sumPrice;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsCostPrice() {
        return goodsCostPrice;
    }

    public void setGoodsCostPrice(String goodsCostPrice) {
        this.goodsCostPrice = goodsCostPrice;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getPucharNum() {
        return pucharNum;
    }

    public void setPucharNum(String pucharNum) {
        this.pucharNum = pucharNum;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public String getOrderActive() {
        return orderActive;
    }

    public void setOrderActive(String orderActive) {
        this.orderActive = orderActive;
    }

    public List<String> getOrderCodeList() {
        return orderCodeList;
    }

    public void setOrderCodeList(List<String> orderCodeList) {
        this.orderCodeList = orderCodeList;
    }
}
