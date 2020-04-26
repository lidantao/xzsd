package com.xzsd.pc.hotGoods.entity;

/**
 * 作者：李丹涛
 * 时间：2020/04/13中午10：31分
 * 功能：热门商品实体类信息
 */

public class HotGoodsInfo {

    /**
     * 展示数量
     */
    private int showNum;

    /**
     * 商品编号
     */
    private String goodsCode;

    /**
     * 热门商品编号
     */
    private String hotGoodsCode;

    /**
     * 热门商品排序
     */
    private String hotGoodsSortNum;

    /**
     * 展示数量数量
     */
    private int hotGoodsShowNum;

    /**
     * 页数
     */
    private String pageNum;

    /**
     * 页数
     */
    private String size;

    /**
     * 总数
     */
    private int total;

    /**
     * 展示数量字典编号
     */
    private final String DICTIONARY_CODE = "123456789";

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品价格
     */
    private String goodsPrice;

    /**
     * 商品描述
     */
    private String goodsIntroduce;

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



    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public int getShowNum() {
        return showNum;
    }

    public void setShowNum(int showNum) {
        this.showNum = showNum;
    }

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce;
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

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getHotGoodsCode() {
        return hotGoodsCode;
    }

    public void setHotGoodsCode(String hotGoodsCode) {
        this.hotGoodsCode = hotGoodsCode;
    }

    public String getHotGoodsSortNum() {
        return hotGoodsSortNum;
    }

    public void setHotGoodsSortNum(String hotGoodsSortNum) {
        this.hotGoodsSortNum = hotGoodsSortNum;
    }

    public int getHotGoodsShowNum() {
        return hotGoodsShowNum;
    }

    public void setHotGoodsShowNum(int hotGoodsShowNum) {
        this.hotGoodsShowNum = hotGoodsShowNum;
    }

    public String getDICTIONARY_CODE() {
        return DICTIONARY_CODE;
    }
}
