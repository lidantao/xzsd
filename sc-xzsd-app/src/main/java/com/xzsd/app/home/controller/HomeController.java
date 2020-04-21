package com.xzsd.app.home.controller;

import com.xzsd.app.home.service.HomeService;
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
 * 时间：2020/04/14
 * 功能：首页轮播图controller类、热门商品controller类
 */

@RestController
@RequestMapping("/home")
@Validated
public class HomeController {


    //日志
    private final Logger logger = LoggerFactory.getLogger(HomeController.class);

    //注入HomeService类
    @Resource
    private HomeService homeService;

    /**
     * 作者：李丹涛
     * 时间：2020/04/14
     * 功能：查询首页轮播图接口
     */
    @PostMapping("listRotate")
    public Response listRotate() {
        try {
            return homeService.listRotate();
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询首页轮播图有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/14晚上19：54
     * 功能：分页查询热门商品接口
     */
    @PostMapping("listHotGoods")
    public Response listHotGoods(){
        try {
            return homeService.listHotGoods();
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询首页热门商品有误！");
        }
    }


}
