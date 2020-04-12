package com.xzsd.pc.user.dao;


/**
 * 作者：李丹涛
 * 时间：2020/04/10晚上22：09分
 * 功能：用户管理userDao接口
 */

import com.xzsd.pc.user.entity.UserDTO;
import com.xzsd.pc.user.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    //查询账号或手机是否存在，userInfo用户信息
    int checkUser(UserInfo userInfo);

    //新增用户，userInfo用户信息
    int addUser(UserInfo userInfo);

    //查询用户详情，userCode用户编号
    UserInfo findUser(String userCode);

    //查询用户分页列表信息，userInfo用户信息
    List<UserInfo> listUserByPage(UserInfo userInfo);

    //修改用户，userInfo用户信息
    int updateUser(UserInfo userInfo);

    //删除用户，userDTO用户form传的参数
    int deleteUser(UserDTO userDTO);

}
