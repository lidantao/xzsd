package com.xzsd.app.customer.shopCar.entity;


/**
 * 作者：李丹涛
 * 时间：2020/04/15中午11：49分
 * 功能：shopCarDTO为接受前端多参信息
 */

import java.util.List;

public class ShopCarDTO {

    /**
     * 购物车编号列表
     */
    List<String> shopCarCodeList;

    /**
     * 商品编号
     */
    private String goodsCode;

    /**
     * 最后一次修改者的用户编号
     */
    private String lastUpdateUser;


    public List<String> getShopCarCodeList() {
        return shopCarCodeList;
    }

    public void setShopCarCodeList(List<String> shopCarCodeList) {
        this.shopCarCodeList = shopCarCodeList;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }
}
