package com.xzsd.app.customer.home.entity;


/**
 * 作者：李丹涛
 * 时间：2020/04/14晚上19：58分
 * 功能：首页实体类信息
 */


public class HomeInfo {

    /**
     * 轮播图片路径
     */
    private String goodsImagePath;

    /**
     * 轮播图展示数量
     */
    private int hotGoodsShowNum;

    /**
     * 商品编号
     */
    private String goodsCode;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品价格
     */
    private String goodsPrice;

    /**
     * 版本号
     */
    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getGoodsImagePath() {
        return goodsImagePath;
    }

    public void setGoodsImagePath(String goodsImagePath) {
        this.goodsImagePath = goodsImagePath;
    }

    public int getHotGoodsShowNum() {
        return hotGoodsShowNum;
    }

    public void setHotGoodsShowNum(int hotGoodsShowNum) {
        this.hotGoodsShowNum = hotGoodsShowNum;
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

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
}
