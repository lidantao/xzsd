package com.xzsd.pc.rotate.controller;


/**
 * 作者：李丹涛
 * 时间：2020/04/12凌晨00：17分
 * 功能：首页轮播图controller类
 */


import com.xzsd.pc.rotate.entity.RotateDTO;
import com.xzsd.pc.rotate.entity.RotateInfo;
import com.xzsd.pc.rotate.service.RotateService;
import com.xzsd.pc.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/rotate")
@Validated
public class RotateController {


    //日志
    private final Logger logger = LoggerFactory.getLogger(RotateController.class);


    //注入RotateService类
    @Resource
    private RotateService rotateService;



    /**
     * 作者：李丹涛
     * 时间：2020/04/12凌晨00：17分
     * 功能：新增首页轮播图接口,rotateInfo为轮播图实体类信息
     */
    @PostMapping("addRotate")
    public Response addRotate(RotateInfo rotateInfo){
        try {
            return rotateService.addRotate(rotateInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("新增首页轮播图操作有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/12凌晨00：17分
     * 功能：分页查询首页轮播图接口,rotateInfo为轮播图实体类信息
     */
    @PostMapping("listRotate")
    public Response listRotate(RotateInfo rotateInfo){
        try {
            return rotateService.listRotate(rotateInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("分页查询首页轮播图信息操作有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/12凌晨00：17分
     * 功能：分页查询商品接口（新增轮播图用）,rotateDTO为传递多参使用实体类信息
     */
    @PostMapping("listGoods")
    public Response listGoods(RotateDTO rotateDTO){
        try {
            return rotateService.listGoods(rotateDTO);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("分页查询商品列表信息操作有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/12凌晨00：17分
     * 功能：修改首页轮播图状态接口,rotateDTO为传递多参使用实体类信息
     */
    @PostMapping("updateRotate")
    public Response updateRotate(String rotateCodeList,String versionList, String rotateActive){
        try {
            return rotateService.updateRotate(rotateCodeList,versionList,rotateActive);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("修改首页轮播图操作有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/12凌晨00：17分
     * 功能：删除首页轮播图接口,rotateDTO为传递多参使用实体类信息
     */
    @PostMapping("deleteRotate")
    public Response deleteRotate(RotateDTO rotateDTO){
        try {
            return rotateService.deleteRotate(rotateDTO);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("删除首页轮播图操作有误！");
        }
    }


}
