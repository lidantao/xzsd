package com.xzsd.app.goods.controller;

import com.xzsd.app.goods.entity.GoodsInfo;
import com.xzsd.app.goods.service.GoodsService;
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
 * 时间：2020/04/15中午10：29分
 * 功能：商品管理Controller类
 */

@RestController
@RequestMapping("/goods")
@Validated
public class GoodsController {


    //日志
    private final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    //注入GoodsService类
    @Resource
    private GoodsService goodsService;

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午10：29分
     * 功能：查询商品信息详情接口，goodsCode为商品编号
     */
    @PostMapping("findGoods")
    public Response findGoods(String goodsCode){
        try {
            return goodsService.findGoods(goodsCode);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询商品信息详情有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午10：31分
     * 功能：查询商品评价列表接口，GoodsInfo为商品实体类信息
     */
    @PostMapping("listGoodsEvaluates")
    public Response listGoodsEvaluates(GoodsInfo goodsInfo){
        try {
            return goodsService.listGoodsEvaluates(goodsInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询商品评价列表有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午10：32分
     * 功能：查询一级商品分类列表接口
     */
    @PostMapping("listFirstGoodsCate")
    public Response listFirstGoodsCate(){
        try {
            return goodsService.listFirstGoodsCate();
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询一级商品分类列表有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午：10：33分
     * 功能：查询二级商品分类以及商品接口，goodsCateCode为一级商品分类编号
     */
    @PostMapping("listCateGoods")
    public Response listCateGoods(String goodsCateCode){
        try {
            return goodsService.listCateGoods(goodsCateCode);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询二级商品分类以及商品！");
        }
    }
}
