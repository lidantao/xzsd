package com.xzsd.pc.goodsCate.controller;


/**
 * 作者：李丹涛
 * 时间：2020/04/12下午15：21分
 * 功能：商品分类管理Controller类
 */


import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.goods.entity.GoodsDTO;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goodsCate.entity.GoodsCateInfo;
import com.xzsd.pc.goodsCate.service.GoodsCateService;
import com.xzsd.pc.user.controller.UserController;
import com.xzsd.pc.user.service.UserService;
import com.xzsd.pc.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/goodsCate")
@Validated
public class GoodsCateController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(GoodsCateController.class);

    //注入Userservice类
    @Resource
    private GoodsCateService goodsCateService;

    //新增商品分类接口,goodsCateInfo商品管理实体类信息
    @PostMapping("addGoodsCate")
    public Response addGoodsCate(GoodsCateInfo goodsCateInfo){
        try {
            return goodsCateService.addGoodsCate(goodsCateInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("新增商品分类有误！");
        }
    }

    //查询商品分类详情接口
    @PostMapping("findGoodsCate")
    public Response findGoodsCate(String goodsCateCode){
        try {
            return goodsCateService.findGoodsCate(goodsCateCode);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询商品分类详情操作有误！");
        }
    }

    //查询商品分类列表接口
    @PostMapping("listGoodsCate")
    public Response listGoodsCate(){
        try {
            return goodsCateService.listGoodsCate();
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询商品分类列表信息操作有误！");
        }
    }

    //修改商品分类接口，goodsCateInfo商品分类信息
    @PostMapping("updateGoodsCate")
    public Response updateGoodsCate(GoodsCateInfo goodsCateInfo) {
        try {
            return goodsCateService.updateGoodsCate(goodsCateInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("修改商品分类操作有误！");
        }
    }

    //删除商品分类接口，goodsCateInfo为商品分类实体类信息
    @PostMapping("deleteGoodsCate")
    public Response deleteGoodsCate(GoodsCateInfo goodsCateInfo) {
        try {
            return goodsCateService.deleteGoodsCate(goodsCateInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("删除商品操作有误！");
        }
    }


}
