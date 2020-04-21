package com.xzsd.app.shopCar.controller;

import com.xzsd.app.shopCar.entity.ShopCarDTO;
import com.xzsd.app.shopCar.entity.ShopCarInfo;
import com.xzsd.app.shopCar.service.ShopCarService;
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
 * 时间：2020/04/15中午11：49分
 * 功能：购物车GoodsController类
 */

@RestController
@RequestMapping("/shopCar")
@Validated
public class ShopCarController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(ShopCarController.class);

    //注入GoodsService类
    @Resource
    private ShopCarService shopCarService;

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午11：33分
     * 功能：新增购物车接口，ShopCarInfo为购物车实体类信息
     */
    @PostMapping("addShopCar")
    public Response addShopCar(ShopCarInfo shopCarInfo){
        try {
            return shopCarService.addShopCar(shopCarInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("新增购物车有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午11：33分
     * 功能：查询购物车接口
     */
    @PostMapping("listShopCar")
    public Response listShopCar(){
        try {
            return shopCarService.listShopCar();
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询购物车有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午11：33分
     * 功能：修改购物车接口，ShopCarInfo为购物车实体类信息
     */
    @PostMapping("updateShopCar")
    public Response updateShopCar(ShopCarInfo shopCarInfo){
        try {
            return shopCarService.updateShopCar(shopCarInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("修改购物车有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午11：33分
     * 功能：删除购物车接口，shopCarDTO为接受前端多参信息
     */
    @PostMapping("deleteShopCar")
    public Response deleteShopCar(ShopCarDTO shopCarDTO){
        try {
            return shopCarService.deleteShopCar(shopCarDTO);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("删除购物车有误！");
        }
    }
}
