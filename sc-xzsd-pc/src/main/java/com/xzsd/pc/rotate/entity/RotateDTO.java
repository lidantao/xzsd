package com.xzsd.pc.rotate.entity;


/**
 * 作者：李丹涛
 * 时间：2020/04/12凌晨00：17分
 * 功能：首页轮播图RotateDTO实体类,
 * 用于接受用户form传递的多个参数和mybaties查询返回的多个参数实体类信息
 */


import java.util.List;


public class RotateDTO {


    //首页轮播图编号列表
    private List<String> rotateCodeList;

    //版本列表
    private List<String> versionList;

    //轮播图状态
    private String rotateActive;

    //商品名称
    private String goodsName;

    //商品编码
    private String goodsCode;

    //商品状态（在售1、已下架2、未发布3（格式：商品状态+状态编号））
    private String goodsActive;

    //一级分类
    private String firstCateName;

    //二级分类
    private String secondCateName;


    //最后一次修改者的用户编号
    private String lastUpdateUser;

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public List<String> getRotateCodeList() {
        return rotateCodeList;
    }

    public void setRotateCodeList(List<String> rotateCodeList) {
        this.rotateCodeList = rotateCodeList;
    }

    public String getRotateActive() {
        return rotateActive;
    }

    public void setRotateActive(String rotateActive) {
        this.rotateActive = rotateActive;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsActive() {
        return goodsActive;
    }

    public void setGoodsActive(String goodsActive) {
        this.goodsActive = goodsActive;
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

    public List<String> getVersionList() {
        return versionList;
    }

    public void setVersionList(List<String> versionList) {
        this.versionList = versionList;
    }
}
