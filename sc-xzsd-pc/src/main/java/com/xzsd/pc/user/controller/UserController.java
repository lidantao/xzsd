package com.xzsd.pc.user.controller;


/**
 * 作者：李丹涛
 * 时间：2020/04/11凌晨00：10分
 * 功能：用户管理userController类
 */


import com.github.pagehelper.PageHelper;
import com.xzsd.pc.user.entity.UserDTO;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.service.UserService;
import com.xzsd.pc.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/user")
@Validated
public class UserController {


    //日志
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    //注入Userservice类
    @Resource
    private UserService userService;

    /**
     * 作者：李丹涛
     * 时间：2020/04/11凌晨00：10分
     * 功能：新增用户，userInfo用户信息
     */
    @PostMapping("addUser")
    public Response addUser(UserInfo userInfo) {
        try {
            return userService.addUser(userInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("新增用户操作有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/11凌晨00：10分
     * 功能：查询用户详情，userCode用户编号
     */
    @PostMapping("findUser")
    public Response findUser(String userCode) {
        try {
            return userService.findUser(userCode);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询用户详情操作有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/11凌晨00：10分
     * 功能：查询用户分页列表信息，userInfo用户信息
     */
    @PostMapping("listUser")
    public Response listUser(UserInfo userInfo) {
        try {
            return userService.listUser(userInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询用户分页列表信息操作有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/11凌晨00：10分
     * 功能：修改用户，userInfo用户信息
     */
    @PostMapping("updateUser")
    public Response updateUser(UserInfo userInfo) {
        try {
            return userService.updateUser(userInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("修改用户操作有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/11凌晨00：10分
     * 功能：删除用户，userDTO用户form传的参数
     */
    @PostMapping("deleteUser")
    public Response deleteUser(UserDTO userDTO) {
        try {
            return userService.deleteUser(userDTO);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("删除用户操作有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/11凌晨00：10分
     * 功能：修改密码，用于用户忘记原密码，无法修改时，启动管理员修改密码
     */
    @PostMapping("updatePassword")
    public Response updatePassword(UserInfo userInfo) {
        try {
            return userService.updatePassword(userInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("修改密码操作有误！");
        }
    }

}
