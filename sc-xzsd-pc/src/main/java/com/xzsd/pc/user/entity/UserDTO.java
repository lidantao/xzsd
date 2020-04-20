package com.xzsd.pc.user.entity;


/**
 * 作者：李丹涛
 * 时间：2020/04/10晚上22：15分
 * 功能：UserDTO，用于接收使用用户输入的Form数据
 */


import java.util.List;


public class UserDTO {

    //用户编号列表
    List<String> userCodeList;

    //用户编号
    private String userCode;

    //最后一次修改者的用户编号
    private String lastUpdateUser;

    public List<String> getUserCodeList() {
        return userCodeList;
    }

    public void setUserCodeList(List<String> userCodeList) {
        this.userCodeList = userCodeList;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }
}
