package com.xzsd.pc.hotGoods.controller;


/**
 * 作者：李丹涛
 * 时间：2020/04/13中午10：31分
 * 功能：热门商品管理dao接口
 */


import com.xzsd.pc.goodsCate.controller.GoodsCateController;
import com.xzsd.pc.goodsCate.service.GoodsCateService;
import com.xzsd.pc.hotGoods.entity.HotGoodsDTO;
import com.xzsd.pc.hotGoods.entity.HotGoodsInfo;
import com.xzsd.pc.hotGoods.service.HotGoodsService;
import com.xzsd.pc.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.method.P;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/hotGoods")
@Validated
public class HotGoodsController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(HotGoodsController.class);

    //注入HotGoodsService类
    @Resource
    private HotGoodsService hotGoodsService;

    @PostMapping("addHotGoods")
    //新增热门商品接口,hotGoodsInfo是热门商品实体类信息
    public Response addHotGoods(HotGoodsInfo hotGoodsInfo){
        try {
            return hotGoodsService.addHotGoods(hotGoodsInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("新增热门商品有误！");
        }
    }


    @PostMapping("findHotGoods")
    //查询热门商品详情接口,hotGoodsInfo是热门商品实体类信息
    public Response findHotGoods(String hotGoodsCode){
        try {
            return hotGoodsService.findHotGoods(hotGoodsCode);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询热门商品详情操作有误！");
        }
    }



    @PostMapping("listHotGoods")
    //分页查询热门商品接口,hotGoodsInfo是热门商品实体类信息
    public Response listHotGoods(HotGoodsInfo hotGoodsInfo){
        try {
            return hotGoodsService.listHotGoods(hotGoodsInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询热门商品列表信息操作有误！");
        }
    }


    @PostMapping("updateHotGoods")
    //修改热门商品接口,hotGoodsInfo是热门商品实体类信息
    public Response updateHotGoods(HotGoodsInfo hotGoodsInfo){
        try {
            return hotGoodsService.updateHotGoods(hotGoodsInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("修改热门商品操作有误！");
        }
    }


    @PostMapping("findHotGoodsShowNum")
    //查询热门商品展示数量接口
    public Response findHotGoodsShowNum(){
        try {
            return hotGoodsService.findHotGoodsShowNum();
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询热门商品展示数量操作有误！");
        }
    }


    @PostMapping("updateHotGoodsShowNum")
    //修改热门商品数量展示接口,hotGoodsInfo是热门商品实体类信息
    public Response updateHotGoodsShowNum(HotGoodsInfo hotGoodsInfo){
        try {
            return hotGoodsService.updateHotGoodsShowNum(hotGoodsInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("修改热门商品数量展示操作有误！");
        }
    }


    @PostMapping("deleteHotGoods")
    //删除热门商品接口,hotGoodsDTO是前端传递多参数接收的实体类信息
    public Response deleteHotGoods(HotGoodsDTO hotGoodsDTO){
        try {
            return hotGoodsService.deleteHotGoods(hotGoodsDTO);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("删除热门商品操作有误！");
        }
    }

}
