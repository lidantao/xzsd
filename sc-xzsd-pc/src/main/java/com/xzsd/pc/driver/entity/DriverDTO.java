package com.xzsd.pc.driver.entity;


/**
 * 作者：李丹涛
 * 时间：2020/04/13凌晨01：50
 * 功能：用于接受前端form请求的多参数
 */


import java.util.List;

public class DriverDTO {

    /**
     * 最后一次修改者编号
     */
    private String lastUpdateUser;

    /**
     * 司机编号列表
     */
    private List<String> driverCodeList;

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public List<String> getDriverCodeList() {
        return driverCodeList;
    }

    public void setDriverCodeList(List<String> driverCodeList) {
        this.driverCodeList = driverCodeList;
    }
}
