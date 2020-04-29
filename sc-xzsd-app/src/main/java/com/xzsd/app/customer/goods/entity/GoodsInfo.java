package com.xzsd.app.customer.goods.entity;


import java.util.List;
import java.util.Map;

/**
 * 作者：李丹涛
 * 时间：2020/04/17凌晨01：36分
 * 功能：商品详情实体类信息
 */

public class GoodsInfo {

    /**
     * 评价编号
     */
    private String goodsEvaluateCode;

    /**
     * 二级商品分类
     */
    private List<Map<String, String>> listSecondCate;

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 评价内容
     */
    private String goodsEvaluateContent;

    /**
     * 评价时间
     */
    private String goodsEvaluateTime;

    /**
     * 二级分类下商品列表
     */
    private List<GoodsInfo> goodsInfoList;

    /**
     * 一级分类编号
     */
    private String firstCateCode;

    /**
     * 二级分类编号
     */
    private String secondCateCode;

    /**
     * 商品分类编号
     */
    private String goodsCateCode;


    /**
     * 商品分类名称
     */
    private String goodsCateName;

    /**
     * 商品编号
     */
    private String goodsCode;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 书号
     */
    private String isbn;

    /**
     * 商品介绍
     */
    private String goodsIntroduce;

    /**
     * 售价
     */
    private String goodsPrice;

    /**
     * 商品图片路径
     */
    private String goodsImagePath;

    /**
     * 商品评价等级
     */
    private String goodsEvaluateScore;

    /**
     * 商品评价图片
     */
    private String goodsEvaluateImage;

    /**
     * 作者
     */
    private String goodsAuthor;

    /**
     * 出版社
     */
    private String goodsPublish;

    /**
     * 用户编号
     */
    private String userCode;

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


    public String getFirstCateCode() {
        return firstCateCode;
    }

    public void setFirstCateCode(String firstCateCode) {
        this.firstCateCode = firstCateCode;
    }

    public String getGoodsCateCode() {
        return goodsCateCode;
    }

    public void setGoodsCateCode(String goodsCateCode) {
        this.goodsCateCode = goodsCateCode;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsImagePath() {
        return goodsImagePath;
    }

    public void setGoodsImagePath(String goodsImagePath) {
        this.goodsImagePath = goodsImagePath;
    }

    public String getGoodsEvaluateScore() {
        return goodsEvaluateScore;
    }

    public void setGoodsEvaluateScore(String goodsEvaluateScore) {
        this.goodsEvaluateScore = goodsEvaluateScore;
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

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public String getGoodsEvaluateCode() {
        return goodsEvaluateCode;
    }

    public void setGoodsEvaluateCode(String goodsEvaluateCode) {
        this.goodsEvaluateCode = goodsEvaluateCode;
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

    public List<Map<String, String>> getListSecondCate() {
        return listSecondCate;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getGoodsEvaluateContent() {
        return goodsEvaluateContent;
    }

    public void setGoodsEvaluateContent(String goodsEvaluateContent) {
        this.goodsEvaluateContent = goodsEvaluateContent;
    }

    public String getGoodsEvaluateTime() {
        return goodsEvaluateTime;
    }

    public void setGoodsEvaluateTime(String goodsEvaluateTime) {
        this.goodsEvaluateTime = goodsEvaluateTime;
    }

    public void setListSecondCate(List<Map<String, String>> listSecondCate) {
        this.listSecondCate = listSecondCate;
    }

    public String getGoodsCateName() {
        return goodsCateName;
    }

    public void setGoodsCateName(String goodsCateName) {
        this.goodsCateName = goodsCateName;
    }

    public List<GoodsInfo> getGoodsInfoList() {
        return goodsInfoList;
    }

    public void setGoodsInfoList(List<GoodsInfo> goodsInfoList) {
        this.goodsInfoList = goodsInfoList;
    }

    public String getGoodsEvaluateImage() {
        return goodsEvaluateImage;
    }

    public void setGoodsEvaluateImage(String goodsEvaluateImage) {
        this.goodsEvaluateImage = goodsEvaluateImage;
    }

    public String getSecondCateCode() {
        return secondCateCode;
    }

    public void setSecondCateCode(String secondCateCode) {
        this.secondCateCode = secondCateCode;
    }
}
