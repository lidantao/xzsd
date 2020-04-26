package com.xzsd.pc.order.entity;

/**
 * 作者：李丹涛
 * 时间：2020/04/20下午13：33分
 * 功能：订单管理实体类信息
 */

import java.util.List;
import java.util.Map;

public class OrderInfo {

    /**
     * 下单人
     */
    private String payUser;

    /**
     * 下单人手机号
     */
    private String payPhone;

    /**
     * maplist
     */
    private List<Map> mapList;

    /**
     * 用户角色（管理员0，店长1）
     */
    private String userRole;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 订单编码
     */
    private String orderCode;

    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 总金额
     */
    private String sumPrice;

    /**
     * 售价
     */
    private String goodsPrice;

    /**
     * 定价
     */
    private String goodsCostPrice;

    /**
     * 商品编码
     */
    private String goodsCode;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 购买数量
     */
    private String pucharNum;

    /**
     * 客户账号
     */
    private String userAccount;

    /**
     * 门店编码
     */
    private String storeCode;

    /**
     * 下单人姓名
     */
    private String userName;

    /**
     * 下单人手机号
     */
    private String userPhone;

    /**
     * 确认付款时间
     */
    private String payTime;

    /**
     * 付款时间开始
     */
    private String payStartTime;

    /**
     * 付款时间截止
     */
    private String payEndTime;

    /**
     * 当前登录角色
     */
    private String role;

    /**
     * 订单状态0已下单，1已取消，2已到货，3已取货，4已完成未评价，5已完成已评价
     */
    private String orderActive;

    /**
     * 支付状态,0未支付，1支付
     */
    private String isPay;


    /**
     * 删除标记（1删除、0不删除）
     */
    private String isDelete;

    /**
     * 创建者
     */
    private String createUser;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 最后一次更新者
     */
    private String lastUpdateUser;

    /**
     * 最后一次更新时间
     */
    private String lastUpdateTime;

    /**
     * 版本
     */
    private String version;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public List<Map> getMapList() {
        return mapList;
    }

    public void setMapList(List<Map> mapList) {
        this.mapList = mapList;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPayStartTime() {
        return payStartTime;
    }

    public void setPayStartTime(String payStartTime) {
        this.payStartTime = payStartTime;
    }

    public String getPayEndTime() {
        return payEndTime;
    }

    public void setPayEndTime(String payEndTime) {
        this.payEndTime = payEndTime;
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

    public String getPayUser() {
        return payUser;
    }

    public void setPayUser(String payUser) {
        this.payUser = payUser;
    }

    public String getPayPhone() {
        return payPhone;
    }

    public void setPayPhone(String payPhone) {
        this.payPhone = payPhone;
    }

    public String getGoodsCostPrice() {
        return goodsCostPrice;
    }

    public void setGoodsCostPrice(String goodsCostPrice) {
        this.goodsCostPrice = goodsCostPrice;
    }


    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
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

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getOrderActive() {
        return orderActive;
    }

    public void setOrderActive(String orderActive) {
        this.orderActive = orderActive;
    }

    public String getIsPay() {
        return isPay;
    }

    public void setIsPay(String isPay) {
        this.isPay = isPay;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
