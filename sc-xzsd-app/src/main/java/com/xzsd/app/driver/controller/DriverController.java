package com.xzsd.app.driver.controller;

import com.xzsd.app.driver.service.DriverService;
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
 * 时间：2020/04/15下午15：09分
 * 功能：查询司机负责门店，店长的相关信息Controller类，
 */

@RestController
@RequestMapping("/driverHome")
@Validated
public class DriverController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(DriverController.class);

    //注入StoreService类
    @Resource
    private DriverService driverService;

    /**
     * 作者：李丹涛
     * 时间：2020/04/15下午15：09分
     * 功能：查询司机负责门店，店长的相关信息，
     */
    @PostMapping("findDriverStore")
    public Response findDriverStore(){
        try {
            return driverService.findDriverStore();
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询司机负责门店，店长的相关信息有误！");
        }
    }
}
