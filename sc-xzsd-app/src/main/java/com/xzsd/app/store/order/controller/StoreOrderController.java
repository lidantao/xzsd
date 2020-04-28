package com.xzsd.app.store.order.controller;


import com.xzsd.app.store.order.entity.StoreOrderDTO;
import com.xzsd.app.store.order.entity.StoreOrderInfo;
import com.xzsd.app.store.order.service.StoreOrderService;
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
 * 时间：2020/04/25下午15：48分
 * 功能：店长订单controller类
 */

@RestController
@RequestMapping("/manangerOrder")
@Validated
public class StoreOrderController {


    //日志
    private final Logger logger = LoggerFactory.getLogger(StoreOrderController.class);

    //注入storeOrderService类
    @Resource
    private StoreOrderService storeOrderService;

    /**
     * 作者：李丹涛
     * 时间：2020/04/25下午15：48分
     * 功能：查询店长订单列表接口
     */
    @PostMapping("listManagerOrders")
    public Response listManagerOrders(StoreOrderDTO storeOrderDTO){
        try {
            return storeOrderService.listManagerOrders(storeOrderDTO);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询店长订单列表接口有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/25下午15：48分
     * 功能：修改店长订单状态接口
     */
    @PostMapping("updateManangerOrderState")
    public Response updateManangerOrderState(StoreOrderInfo storeOrderInfo){
        try {
            return storeOrderService.updateManangerOrderState(storeOrderInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("修改店长订单状态接口有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/25下午15：48分
     * 功能：查询店长订单详情接口
     */
    @PostMapping("listManagerOrderDeepen")
    public Response orderDetail(String orderCode){
        try {
            return storeOrderService.orderDetail(orderCode);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询店长订单详情接口有误！");
        }
    }


}
