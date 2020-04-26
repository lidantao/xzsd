package com.xzsd.app.store.order.entity;

import java.util.List;
import java.util.Map;

public class StoreOrderInfo {

    /**
     * 订单详情列表
     */
    private List<StoreOrderInfo> orderDetailList;

    /**
     * 商品编号
     */
    private String goodsCodeList;

    /**
     * 商品编号列表
     */
    private String newGoodsCodeList;

    /**
     * 平均星级
     */
    private double avgStar;

    /**
     * 商品详情map
     */
    private List<Map> mapList;

    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 商品编号
     */
    private String goodsCode;

    /**
     * 商品数量
     */
    private int goodsCount;

    /**
     * 商品价格
     */
    private String goodsPrice;

    /**
     * 门店编号
     */
    private String storeCode;

    /**
     * 订单状态
     */
    private String orderActive;

    /**
     * 订单编号
     */
    private String orderCode;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品图片路径
     */
    private String goodsImagePath;

    /**
     * 商品介绍
     */
    private String goodsIntroduce;

    /**
     * 商品合计
     */
    private String goodsSumPrice;

    /**
     * 订单总价
     */
    private double sumPrice;

    /**
     * 支付状态 0:支付，1：未支付
     */
    private String payActive;

    /**
     * 订单商品总数量
     */
    private int pucharNum;

    /**
     * 门店名称
     */
    private String storeName;

    /**
     * 省编号
     */
    private String provinceCode;

    /**
     * 省名称
     */
    private String provinceName;

    /**
     * 市编号
     */
    private String cityCode;

    /**
     * 市名称
     */
    private String cityName;

    /**
     * 区编号
     */
    private String areaCode;

    /**
     * 区名称
     */
    private String areaName;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 支付时间
     */
    private String payTime;

    /**
     * 评价内容
     */
    private String evaluateContent;

    /**
     * 评价等级
     */
    private String evaluateScore;

    /**
     * 评价图片排序
     */
    private String imageSortNum;

    /**
     * 删除标记（1删除、0不删除）
     */
    private String isDelete;

    /**
     * 订单详情编号
     */
    private String orderDetailCode;


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


    public String getGoodsCodeList() {
        return goodsCodeList;
    }

    public void setGoodsCodeList(String goodsCodeList) {
        this.goodsCodeList = goodsCodeList;
    }

    public String getNewGoodsCodeList() {
        return newGoodsCodeList;
    }

    public void setNewGoodsCodeList(String newGoodsCodeList) {
        this.newGoodsCodeList = newGoodsCodeList;
    }

    public double getAvgStar() {
        return avgStar;
    }

    public List<StoreOrderInfo> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<StoreOrderInfo> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public void setAvgStar(double avgStar) {
        this.avgStar = avgStar;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getOrderActive() {
        return orderActive;
    }

    public void setOrderActive(String orderActive) {
        this.orderActive = orderActive;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImagePath() {
        return goodsImagePath;
    }

    public void setGoodsImagePath(String goodsImagePath) {
        this.goodsImagePath = goodsImagePath;
    }

    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce;
    }

    public String getGoodsSumPrice() {
        return goodsSumPrice;
    }

    public void setGoodsSumPrice(String goodsSumPrice) {
        this.goodsSumPrice = goodsSumPrice;
    }

    public double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public String getPayActive() {
        return payActive;
    }

    public void setPayActive(String payActive) {
        this.payActive = payActive;
    }

    public int getPucharNum() {
        return pucharNum;
    }

    public void setPucharNum(int pucharNum) {
        this.pucharNum = pucharNum;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }

    public String getEvaluateScore() {
        return evaluateScore;
    }

    public void setEvaluateScore(String evaluateScore) {
        this.evaluateScore = evaluateScore;
    }

    public String getImageSortNum() {
        return imageSortNum;
    }

    public void setImageSortNum(String imageSortNum) {
        this.imageSortNum = imageSortNum;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getOrderDetailCode() {
        return orderDetailCode;
    }

    public void setOrderDetailCode(String orderDetailCode) {
        this.orderDetailCode = orderDetailCode;
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
