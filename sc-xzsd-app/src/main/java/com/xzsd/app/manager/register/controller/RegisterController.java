package com.xzsd.app.manager.register.controller;

import com.xzsd.app.manager.register.entity.RegisterInfo;
import com.xzsd.app.manager.register.service.RegisterService;
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
 * 时间：2020/04/15下午14：44分
 * 功能：注册用户Controller类
 */

@RestController
@RequestMapping("/register")
@Validated
public class RegisterController {


    //日志
    private final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    //注入RegisterService类
    @Resource
    private RegisterService registerService;


    /**
     * 作者：李丹涛
     * 时间：2020/04/15下午14：44分
     * 功能：注册用户
     */
    @PostMapping("clientRegister")
    public Response clientRegister(RegisterInfo registerInfo){
        try {
            return registerService.clientRegister(registerInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("注册客户操作有误！");
        }
    }

}
