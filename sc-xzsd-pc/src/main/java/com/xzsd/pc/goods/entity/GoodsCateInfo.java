package com.xzsd.pc.goods.entity;


/**
 * 作者：李丹涛
 * 时间：2020/04/11
 * 功能：商品分类下拉框实体类信息
 */


public class GoodsCateInfo {


    //商品分类编号
    private String goodsCateCode;

    //分类父类编号（一级分类传0，二级分类传一级分类编号）
    private String cateParentCode;

    //商品分类名称
    private String goodsCateName;

    //删除标记（1删除、0不删除）
    private String isDelete;

    //创建者
    private String createUser;

    //创建时间
    private String createTime;

    //最后一次更新者
    private String lastUpdateUser;

    //最后一次更新时间
    private String lastUpdateTime;

    //版本
    private String version;


    public String getGoodsCateCode() {
        return goodsCateCode;
    }

    public void setGoodsCateCode(String goodsCateCode) {
        this.goodsCateCode = goodsCateCode;
    }

    public String getCateParentCode() {
        return cateParentCode;
    }

    public void setCateParentCode(String cateParentCode) {
        this.cateParentCode = cateParentCode;
    }

    public String getGoodsCateName() {
        return goodsCateName;
    }

    public void setGoodsCateName(String goodsCateName) {
        this.goodsCateName = goodsCateName;
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
