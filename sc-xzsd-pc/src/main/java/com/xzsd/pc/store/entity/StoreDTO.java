package com.xzsd.pc.store.entity;

/**
 * 作者：李丹涛
 * 时间：2020/04/13晚上23：13分
 * 功能：用于用户form传递多参数使用的dto实体类信息
 */

import java.util.List;

public class StoreDTO {

    /**
     * 最后一次修改者编号
     */
    private String lastUpdateUser;

    /**
     * 门店编号列表
     */
    private List<String> storeCodeList;

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public List<String> getStoreCodeList() {
        return storeCodeList;
    }

    public void setStoreCodeList(List<String> storeCodeList) {
        this.storeCodeList = storeCodeList;
    }
}
