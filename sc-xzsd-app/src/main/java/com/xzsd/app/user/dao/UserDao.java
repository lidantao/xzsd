package com.xzsd.app.user.dao;

import com.xzsd.app.user.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 作者：李丹涛
 * 时间：2020/04/19凌晨02：44分
 * 功能：用户个人信息查询与修改密码dao接口
 */

@Mapper
public interface UserDao {


    /**
     * 作者：李丹涛
     * 时间：2020/04/19早上9：33分
     * 功能：查询登录用户角色
     */
    String checkRole(String userCode);


    /**
     * 作者：李丹涛
     * 时间：2020/04/19凌晨02：41分
     * 功能：查询个人信息(用户角色）
     */
    UserInfo findUser(String userCode);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19中午10：17分
     * 功能：根据角色查找相关门店信息
     */
    /**
     * 店长
     */
    UserInfo findStore(@Param("userCode") String userCode);
    /**
     * 客户
     */
    UserInfo findCustomer(String userCode);
    /**
     * 司机
     */
    UserInfo findDriver(String userCode);


    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午14：39分
     * 功能：查询原密码
     */
    String findUserPassword(String userCode);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19凌晨02：43分
     * 功能：修改密码
     */
    int updateUserPassword(UserInfo userInfo);

}
