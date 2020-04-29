package com.xzsd.app.store.storeInfo.controller;

import com.xzsd.app.store.storeInfo.service.StoreService;
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
 * 时间：2020/04/15分下午14：16分
 * 功能：门店下司机信息controller类
 */

@RestController
@RequestMapping("/manangerInformation")
@Validated
public class StoreController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(StoreController.class);

    //注入StoreService类
    @Resource
    private StoreService storeService;

    /**
     * 作者：李丹涛
     * 时间：2020/04/15下午14：44分
     * 功能：店长个人信息之查询司机信息
     */
    @PostMapping("listManangerDriver")
    public Response listManangerDriver(){
        try {
            return storeService.listManangerDriver();
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询司机信息有误！");
        }
    }

}
