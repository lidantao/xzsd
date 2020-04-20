package com.xzsd.pc.hotGoods.entity;


/**
 * 作者：李丹涛
 * 时间：2020/04/13中午10：31分
 * 功能：接受用户form传递的多参数实体类
 */


import java.util.List;

public class HotGoodsDTO {

    /**
     * 设置最后更新者
     */
    private String lastUpdateUser;

    /**
     * 设置热门商品编号列表
     */
    private List<String> hotGoodsCodeList;


    public String GoodsDTO() {
        return lastUpdateUser;
    }

    /**
     * 热门商品展示数量字典编号
     */
    private String dictionaryCode;

    public String getDictionaryCode() {
        return dictionaryCode;
    }

    public void setDictionaryCode(String dictionaryCode) {
        this.dictionaryCode = dictionaryCode;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public List<String> getHotGoodsCodeList() {
        return hotGoodsCodeList;
    }

    public void setHotGoodsCodeList(List<String> hotGoodsCodeList) {
        this.hotGoodsCodeList = hotGoodsCodeList;
    }
}
