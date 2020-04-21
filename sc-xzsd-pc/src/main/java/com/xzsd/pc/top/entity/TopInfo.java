package com.xzsd.pc.top.entity;

public class TopInfo {

    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户头像路径
     */
    private String userImagePath;

    /**
     * 用户角色 0管理员、1店长
     * （0可以使用全部的功能模块，
     * 1只能使用以下功能模块:
     * 客户管理模块；
     * 订单管理模块；
     * 门店管理的查询、重置和详情；
     * 司机管理的查询、重置和详情）
     */
    private String role;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImagePath() {
        return userImagePath;
    }

    public void setUserImagePath(String userImagePath) {
        this.userImagePath = userImagePath;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
