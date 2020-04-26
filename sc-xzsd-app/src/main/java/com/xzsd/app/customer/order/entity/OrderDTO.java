package com.xzsd.app.customer.order.entity;

import java.util.List;
import java.util.Map;

/**
 * 作者：李丹涛
 * 时间：2020/04/21晚上22：53分
 * 功能：app订单管理DTO实体类
 */

public class OrderDTO {

    /**
     * 商品价格列表
     */
    private List<String> goodsPriceList;

    /**
     * 订单状态
     */
    private String orderActive;

    /**
     * 页码
     */
    private int PageNum;

    /**
     * 页数量
     */
    private int PageSize;

    /**
     * 总数量
     */
    private int total;

    /**
     * 库存mapList
     */
    private List<Map> stockMapList;

    /**
     * 商品编号列表
     */
    private List<String> goodsCodeList;

    /**
     * 商品数量列表
     */
    private List<String> goodsCountList;

    /**
     * 商品合计列表
     */
    private List<String> goodsSumPriceList;

    /**
     * 购物车编号
     */
    private List<String> shopCarCodeList;

    /**
     * 商品价格
     */
    private String goodsPrice;

    /**
     * 门店编号
     */
    private String storeCode;

    /**
     * 更新后的库存列表
     */
    private List<Integer> stockList;

    /**
     * 最后一次更新者
     */
    private String lastUpdateUser;

    public String getOrderActive() {
        return orderActive;
    }

    public void setOrderActive(String orderActive) {
        this.orderActive = orderActive;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public List<Integer> getStockList() {
        return stockList;
    }

    public void setStockList(List<Integer> stockList) {
        this.stockList = stockList;
    }

    public List<Map> getStockMapList() {
        return stockMapList;
    }

    public void setStockMapList(List<Map> stockMapList) {
        this.stockMapList = stockMapList;
    }

    public List<String> getGoodsCodeList() {
        return goodsCodeList;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public void setGoodsCodeList(List<String> goodsCodeList) {
        this.goodsCodeList = goodsCodeList;
    }

    public List<String> getGoodsCountList() {
        return goodsCountList;
    }

    public void setGoodsCountList(List<String> goodsCountList) {
        this.goodsCountList = goodsCountList;
    }

    public int getPageNum() {
        return PageNum;
    }

    public List<String> getGoodsPriceList() {
        return goodsPriceList;
    }

    public void setGoodsPriceList(List<String> goodsPriceList) {
        this.goodsPriceList = goodsPriceList;
    }

    public void setPageNum(int pageNum) {
        PageNum = pageNum;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<String> getGoodsSumPriceList() {
        return goodsSumPriceList;
    }

    public void setGoodsSumPriceList(List<String> goodsSumPriceList) {
        this.goodsSumPriceList = goodsSumPriceList;
    }

    public List<String> getShopCarCodeList() {
        return shopCarCodeList;
    }

    public void setShopCarCodeList(List<String> shopCarCodeList) {
        this.shopCarCodeList = shopCarCodeList;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }
}
