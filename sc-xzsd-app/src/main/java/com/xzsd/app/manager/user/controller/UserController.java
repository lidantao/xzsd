package com.xzsd.app.manager.user.controller;

import com.xzsd.app.manager.user.entity.UserInfo;
import com.xzsd.app.manager.user.service.UserService;
import com.xzsd.app.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 作者：李丹涛
 * 时间：2020/04/19凌晨02：44分
 * 功能：用户个人信息查询与修改密码controller类
 */

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    //注入UserSevice类
    @Resource
    private UserService userService;

    /**
     * 作者：李丹涛
     * 时间：2020/04/19凌晨02：41分
     * 功能：查询个人信息
     */
    @PostMapping("findUser")
    public Response findUser(){
        try {
            return userService.findUser();
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询个人信息有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/19凌晨02：43分
     * 功能：修改密码
     */
    @PostMapping("updateUserPassword")
    public Response updateUserPassword(UserInfo userInfo) {
        try {
            return userService.updateUserPassword(userInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("修改密码操作有误！");
        }
    }

}
