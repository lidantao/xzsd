package com.xzsd.pc.rotate.entity;


import java.util.List;
import java.util.Map;

/**
 * 作者：李丹涛
 * 时间：2020/04/12凌晨00：17分
 * 功能：首页轮播图RotateInfo实体类信息
 */


public class RotateInfo {


    /**
     * List<Map> 映射
     */
    private List<Map> mapList;

    /**
     * 首页轮播图编号
     */
    private String rotateCode;

    /**
     * 排序
     */
    private int rotateSortNum;

    /**
     * 轮播图片（图片路径）
     */
    private String rotateImagePath;

    /**
     * 状态（启用0、禁用1）
     */
    private String rotateActive;

    /**
     * 有效期起
     */
    private String startTime;

    /**
     * 有效期止
     */
    private String endTime;

    /**
     * 商品编号
     */
    private String goodsCode;

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

    public String getIsDelete() {
        return isDelete;
    }

    public List<Map> getMapList() {
        return mapList;
    }

    public void setMapList(List<Map> mapList) {
        this.mapList = mapList;
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

    public String getRotateCode() {
        return rotateCode;
    }

    public void setRotateCode(String rotateCode) {
        this.rotateCode = rotateCode;
    }

    public int getRotateSortNum() {
        return rotateSortNum;
    }

    public void setRotateSortNum(int rotateSortNum) {
        this.rotateSortNum = rotateSortNum;
    }

    public String getRotateImagePath() {
        return rotateImagePath;
    }

    public void setRotateImagePath(String rotateImagePath) {
        this.rotateImagePath = rotateImagePath;
    }

    public String getRotateActive() {
        return rotateActive;
    }

    public void setRotateActive(String rotateActive) {
        this.rotateActive = rotateActive;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }
}
