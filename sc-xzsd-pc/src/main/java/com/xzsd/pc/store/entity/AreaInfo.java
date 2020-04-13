package com.xzsd.pc.store.entity;


/**
 * 作者：李丹涛
 * 时间：2020/04/13晚上22：42分
 * 功能：省市区实体类信息
 */


public class AreaInfo {

    /**
     * 地区编号
     */
    private String areaCode;

    /**
     * 地区名字
     */
    private String areaName;

    /**
     * 父级编号
     */
    private String parentCode;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }
}
