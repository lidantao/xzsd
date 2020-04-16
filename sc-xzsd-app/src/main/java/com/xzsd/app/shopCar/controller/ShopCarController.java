package com.xzsd.app.shopCar.controller;

/**
 * 作者：李丹涛
 * 时间：2020/04/15中午11：49分
 * 功能：商品管理GoodsController类
 */


import com.xzsd.app.shopCar.entity.ShopCarDTO;
import com.xzsd.app.shopCar.entity.ShopCarInfo;
import com.xzsd.app.shopCar.service.ShopCarService;
import com.xzsd.app.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/goods")
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
    public Response deleteShopCar(ShopCarDTO shopCarDTO){
        try {
            return shopCarService.deleteShopCar(shopCarDTO);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("删除购物车有误！");
        }
    }
}
