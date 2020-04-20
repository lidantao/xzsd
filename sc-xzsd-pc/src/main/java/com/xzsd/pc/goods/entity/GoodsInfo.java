package com.xzsd.pc.goods.entity;


import java.util.List;
import java.util.Map;

/**
 * 作者：李丹涛
 * 时间：2020/04/11晚上19：57
 * 功能：商品管理实体类信息
 */


public class GoodsInfo {

    /**
     * List<Map>映射参数
     */
    private List<Map> mapList;

    /**
     * 商品编号
     */
    private String goodsCode;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 定价
     */
    private String goodsCostPrice;

    /**
     * 售价
     */
    private String goodsPrice;

    /**
     * 销售量
     */
    private String goodsSallNum;

    /**
     * 一级分类编号
     */
    private String firstCateCode;

    /**
     * 二级分类编号
     */
    private String secondCateCode;

    /**
     * 一级分类名称
     */
    private String firstCateName;

    /**
     * 二级分类名称
     */
    private String secondCateName;

    /**
     * 广告词
     */
    private String goodsAdvertise;

    /**
     * 商品介绍
     */
    private String goodsIntroduce;

    /**
     * 商品状态（在售1、已下架2、未发布3（格式：商品状态+状态编号））
     */
    private String goodsActive;

    /**
     * 上架时间
     */
    private String goodsStartTime;

    /**
     * 浏览量
     */
    private String goodsViewNum;

    /**
     * 商家名称
     */
    private String sallerName;

    /**
     * isbn书号
     */
    private String isbn;

    /**
     * 作者
     */
    private String goodsAuthor;

    /**
     * 出版社
     */
    private String goodsPublish;

    /**
     * 图片（图片路径）
     */
    private String goodsImagePath;

    /**
     * 库存
     */
    private String goodsStock;

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

    public String getGoodsCostPrice() {
        return goodsCostPrice;
    }

    public void setGoodsCostPrice(String goodsCostPrice) {
        this.goodsCostPrice = goodsCostPrice;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsSallNum() {
        return goodsSallNum;
    }

    public String getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(String goodsStock) {
        this.goodsStock = goodsStock;
    }

    public void setGoodsSallNum(String goodsSallNum) {
        this.goodsSallNum = goodsSallNum;
    }

    public String getFirstCateName() {
        return firstCateName;
    }

    public void setFirstCateName(String firstCateName) {
        this.firstCateName = firstCateName;
    }

    public String getSecondCateName() {
        return secondCateName;
    }

    public void setSecondCateName(String secondCateName) {
        this.secondCateName = secondCateName;
    }

    public String getFirstCateCode() {
        return firstCateCode;
    }

    public void setFirstCateCode(String firstCateCode) {
        this.firstCateCode = firstCateCode;
    }

    public String getSecondCateCode() {
        return secondCateCode;
    }

    public void setSecondCateCode(String secondCateCode) {
        this.secondCateCode = secondCateCode;
    }

    public String getGoodsAdvertise() {
        return goodsAdvertise;
    }

    public void setGoodsAdvertise(String goodsAdvertise) {
        this.goodsAdvertise = goodsAdvertise;
    }

    public List<Map> getMapList() {
        return mapList;
    }

    public void setMapList(List<Map> mapList) {
        this.mapList = mapList;
    }

    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce;
    }

    public String getGoodsActive() {
        return goodsActive;
    }

    public void setGoodsActive(String goodsActive) {
        this.goodsActive = goodsActive;
    }

    public String getGoodsStartTime() {
        return goodsStartTime;
    }

    public void setGoodsStartTime(String goodsStartTime) {
        this.goodsStartTime = goodsStartTime;
    }

    public String getGoodsViewNum() {
        return goodsViewNum;
    }

    public void setGoodsViewNum(String goodsViewNum) {
        this.goodsViewNum = goodsViewNum;
    }

    public String getSallerName() {
        return sallerName;
    }

    public void setSallerName(String sallerName) {
        this.sallerName = sallerName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGoodsAuthor() {
        return goodsAuthor;
    }

    public void setGoodsAuthor(String goodsAuthor) {
        this.goodsAuthor = goodsAuthor;
    }

    public String getGoodsPublish() {
        return goodsPublish;
    }

    public void setGoodsPublish(String goodsPublish) {
        this.goodsPublish = goodsPublish;
    }

    public String getGoodsImagePath() {
        return goodsImagePath;
    }

    public void setGoodsImagePath(String goodsImagePath) {
        this.goodsImagePath = goodsImagePath;
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
