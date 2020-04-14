package com.xzsd.pc.store.controller;


/**
 * 作者：李丹涛
 * 时间：2020/04/13晚上23：36分
 * 功能：门店管理controller类
 */


import com.xzsd.pc.rotate.controller.RotateController;
import com.xzsd.pc.store.entity.AreaInfo;
import com.xzsd.pc.store.entity.StoreDTO;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.service.StoreService;
import com.xzsd.pc.utils.RandomCode;
import com.xzsd.pc.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/store")
@Validated
public class StoreController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(StoreController.class);

    //注入storeSercie类
    @Resource
    private StoreService storeService;

    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：27分
     * 功能：查询省市区下拉框接口
     * areaCode：区域编号（省传0，市传省编号，区传市编号）
     */
    @PostMapping("listArea")
    public Response listArea(String parentCode) {
        try {
            return storeService.listArea(parentCode);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询省市区操作有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：29分
     * 功能：新增门店信息接口
     * storeInfo：门店实体类信息
     */
    @PostMapping("addStore")
    public Response addStore(StoreInfo storeInfo) {
        try {
            return storeService.addStore(storeInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("新增门店操作有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：33分
     * 功能：查询门店信息详情接口
     * storeCode：门店编号
     */
    @PostMapping("findStore")
    public Response findStore(String storeCode) {
        try {
            return storeService.findStore(storeCode);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询门店信息有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：36分
     * 功能：分页查询门店信息
     * storeInfo：门店实体类信息
     */
    @PostMapping("listStore")
    public Response listStore(StoreInfo storeInfo) {
        try {
            return storeService.listStore(storeInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("分页查询门店信息有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：39分
     * 功能：修改门店信息接口
     * storeInfo：门店实体类信息
     */
    @PostMapping("updateStore")
    public Response updateStore(StoreInfo storeInfo) {
        try {
            return storeService.updateStore(storeInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("修改门店信息有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：42分
     * 功能：删除门店信息接口
     * storeDTO：用于用户传递多参数使用的实体类信息
     */
    @PostMapping("deleteStore")
    public Response deleteStore(StoreDTO storeDTO) {
        try {
            return storeService.deleteStore(storeDTO);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("删除门店信息有误！");
        }
    }
}
