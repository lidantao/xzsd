package com.xzsd.pc.goods.entity;


/**
 * 作者：李丹涛
 * 时间：2020/04/11晚上22：47分
 * 功能：goodsDTO，用于接收使用用户输入的Form数据
 */


import java.util.List;


public class GoodsDTO {

    /**
     * 商品编号列表
     */
    List<String> goodsCodeList;

    /**
     * 商品编号
     */
    private String goodsCode;

    /**
     * 最后一次修改者的用户编号
     */
    private String lastUpdateUser;

    public List<String> getGoodsCodeList() {
        return goodsCodeList;
    }

    public void setGoodsCodeList(List<String> goodsCodeList) {
        this.goodsCodeList = goodsCodeList;
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
